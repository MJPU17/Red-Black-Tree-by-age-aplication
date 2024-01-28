package co.edu.unbosque.model.persistence;

import java.util.Random;

import co.edu.unbosque.model.PersonDTO;
import co.edu.unbosque.util.MyLinkedList;

public class PersonDAO implements CRUDOperations<PersonDTO> {
	
	private MyLinkedList<PersonDTO> personList;
	
	public PersonDAO() {
		personList=loadData();
		if(personList==null) {
			personList=new MyLinkedList<>();
		}
	}

	public MyLinkedList<PersonDTO> getPersonList() {
		return personList;
	}

	public void setPersonList(MyLinkedList<PersonDTO> personList) {
		this.personList = personList;
	}

	@Override
	public void create(PersonDTO info) {
		int min=0;
		int index=-1;
		for (int i = 0; i < personList.getSize(); i++) {
			int id=personList.get(i).getId();
			if(i==0 || id<min) {
				min=id;
				index=i;
			}
		}
		if(index!=-1 && info.getId()<min) {
			personList.remove(index);
			personList.add(personList.getSize()-1, info);
			return;
		}
		personList.add(info);
	}

	@Override
	public boolean delete(int index) {
		if(index>=0 && index<personList.getSize()) {
			personList.remove(index);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(int index, PersonDTO info) {
		if(index>=0 && index<personList.getSize()) {
			personList.set(index, info);
			return true;
		}
		return false;
	}
	
	public boolean containsID(int id) {
		for(PersonDTO person: personList) {
			if(person.getId()==id) {
				return true;
			}
		}
		return false;
	}
	
	public int generateID() {
		int id=0;
		Random random=new Random();
		do {
			id=random.nextInt(800)+1;
		}while(containsID(id));
		return id;
	}
	
	
	public MyLinkedList<PersonDTO> loadData(){
		return(MyLinkedList<PersonDTO>)FileHandler.readSerializable("people.mjpu");
	}

}
