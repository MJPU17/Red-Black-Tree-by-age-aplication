package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MenuPanel extends JPanel{
	
	private JButton btable,binsert,btree;
	
	public MenuPanel() {
		setLayout(new GridBagLayout());
		
		startingComponents();
		
		setVisible(true);
	}

	private void startingComponents() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		btable=new JButton("Show Table");
		btable.setActionCommand("TABLE");
		btable.setBackground(Color.CYAN);
		btable.setBorder(new LineBorder(Color.BLACK));
		btable.setFocusPainted(false);
		btable.setToolTipText("Show table with person information.");
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.weighty=1.0;
		gbc.weightx=1.0;
		gbc.ipady=10;
		gbc.fill=GridBagConstraints.BOTH;
		add(btable,gbc);
		
		binsert=new JButton("Insert Person");
		binsert.setActionCommand("INSERT");
		binsert.setBackground(Color.CYAN);
		binsert.setBorder(new LineBorder(Color.BLACK));
		binsert.setFocusPainted(false);
		binsert.setToolTipText("Show panel to enter people.");
		gbc.gridx=1;
		add(binsert,gbc);
		
		btree=new JButton("Show Tree");
		btree.setActionCommand("TREE");
		btree.setBackground(Color.CYAN);
		btree.setBorder(new LineBorder(Color.BLACK));
		btree.setFocusPainted(false);
		btree.setToolTipText("Show red-black tree information.");
		gbc.gridx=2;
		add(btree,gbc);
		
	}

	public JButton getBtable() {
		return btable;
	}

	public void setBtable(JButton btable) {
		this.btable = btable;
	}

	public JButton getBinsert() {
		return binsert;
	}

	public void setBinsert(JButton binsert) {
		this.binsert = binsert;
	}

	public JButton getBtree() {
		return btree;
	}

	public void setBtree(JButton btree) {
		this.btree = btree;
	}
	
}
