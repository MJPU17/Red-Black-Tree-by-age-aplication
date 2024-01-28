package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	
	private MenuPanel pmenu;
	private JPanel pcontainer;
	private InsertPanel pinsert;
	private TablePanel ptable;
	private TreePanel ptree;
	
	public MainWindow() {
		setTitle("Person Manager");
		setSize(800,600);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		
		startingComponets();
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void startingComponets() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weighty=1.0;
		gbc.weightx=1.0;
		gbc.fill=GridBagConstraints.BOTH;
		
		pmenu=new MenuPanel();
		getContentPane().add(pmenu,BorderLayout.NORTH);
		
		pcontainer=new JPanel(new GridBagLayout());
		
		pinsert=new InsertPanel();
		pcontainer.add(pinsert,gbc);
		
		ptable=new TablePanel();
		pcontainer.add(ptable,gbc);
		
		ptree=new TreePanel();
		pcontainer.add(ptree,gbc);
		
		getContentPane().add(pcontainer,BorderLayout.CENTER);
	}

	public MenuPanel getPmenu() {
		return pmenu;
	}

	public void setPmenu(MenuPanel pmenu) {
		this.pmenu = pmenu;
	}

	public JPanel getPcontainer() {
		return pcontainer;
	}

	public void setPcontainer(JPanel pcontainer) {
		this.pcontainer = pcontainer;
	}

	public InsertPanel getPinsert() {
		return pinsert;
	}

	public void setPinsert(InsertPanel pinsert) {
		this.pinsert = pinsert;
	}

	public TablePanel getPtable() {
		return ptable;
	}

	public void setPtable(TablePanel ptable) {
		this.ptable = ptable;
	}

	public TreePanel getPtree() {
		return ptree;
	}

	public void setPtree(TreePanel ptree) {
		this.ptree = ptree;
	}

}
