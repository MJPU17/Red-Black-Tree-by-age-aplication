package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Date;

import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.model.persistence.PersonDAO;
import co.edu.unbosque.util.RedBlackTree;
import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.PopUpMessages;

public class Controller implements ActionListener{
	
	private MainWindow view;
	private PersonDAO people;
	
	public Controller() {
		people=new PersonDAO();
		view=new MainWindow();
	}
	
	public void assignListeners() {
		view.getPmenu().getBinsert().addActionListener(this);
		view.getPmenu().getBtable().addActionListener(this);
		view.getPmenu().getBtree().addActionListener(this);
		view.getPinsert().getBinsert().addActionListener(this);
		view.getPtable().getCborder().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		
		switch (command) {
		case "INSERT":{
			view.getPtable().setVisible(false);
			view.getPtree().setVisible(false);
			view.getPinsert().setVisible(true);
			break;
		}
		case "TABLE":{
			view.getPinsert().setVisible(false);
			view.getPtree().setVisible(false);
			insertInfo();
			view.getPtable().setVisible(true);
			break;
		}
		case "INSERT DATA":{
			boolean error=false;
			String name=view.getPinsert().getTfname().getText();
			Date dateBirth=view.getPinsert().getDcdate().getDate();
			int id=people.generateID();
			if(name.trim().isEmpty()) {
				PopUpMessages.errorMessage(view, "Please enter name.");
				error=true;
			}
			if(dateBirth==null) {
				PopUpMessages.errorMessage(view, "Please enter date.");
				error=true;
			}
			if(!error) {
				people.create(new PersonDTO(name, dateBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), id));
				PopUpMessages.infoMessage(view, "Person successfully added.");
				view.getPinsert().getTfname().setText("");
			}
			break;
		}
		case "ORDER":{
			int option=view.getPtable().getCborder().getSelectedIndex();
			if(option==0) {
				insertInfo();
			}
			else {
				decedentInfo();
			}
			break;
		}
		case "TREE":
			view.getPtable().setVisible(false);
			view.getPinsert().setVisible(false);
			view.getPtree().startingComponents(tree());
			view.getPtree().setVisible(true);
			break;
		}
	}
	
	public void insertInfo() {
		String[][] information=new String[people.getPersonList().getSize()][4];
		int i=0;
		String[] columns={"Element No","Name","Date of birth","id"};
		for(PersonDTO person:people.getPersonList()) {
			information[i][0]=Integer.toString(i+1);
			information[i][1]=person.getName();
			information[i][2]=person.getBirthDay().toString();
			information[i][3]=Integer.toString(person.getId());
			i++;
		}
		view.getPtable().startingTable(columns,information);
	}
	
	public void decedentInfo() {
		PersonDTO[] arr=new PersonDTO[people.getPersonList().getSize()];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=people.getPersonList().get(i);
		}
		sort(arr, 0, arr.length-1);
		String[][] information=new String[arr.length][4];
		int i=0;
		String[] columns={"Element No","Name","Date of birth","id"};
		for(PersonDTO person:arr) {
			information[i][0]=Integer.toString(i+1);
			information[i][1]=person.getName();
			information[i][2]=person.getBirthDay().toString();
			information[i][3]=Integer.toString(person.getId());
			i++;
		}
		view.getPtable().startingTable(columns,information);
	}
	
	public int partition(PersonDTO[] arr, int low, int high) {
        PersonDTO pivot = arr[high];
        int i = (low - 1); 
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot)>=0) {
                i++;
                PersonDTO temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        PersonDTO temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
	
	public void sort(PersonDTO[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
	
	public RedBlackTree<PersonDTO> tree(){
		RedBlackTree<PersonDTO> rbTree=new RedBlackTree<>();
		for(PersonDTO person:people.getPersonList()) {
			rbTree.insert(person);
		}
		return rbTree;
	}
	
}
