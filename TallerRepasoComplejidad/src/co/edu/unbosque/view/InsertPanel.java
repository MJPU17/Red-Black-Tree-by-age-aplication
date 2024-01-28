package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

public class InsertPanel extends JPanel{
	
	private JLabel lname, ldate;
	private JTextField tfname;
	private JDateChooser dcdate;
	private JButton binsert;
	private JPanel pcontainer;
	
	public InsertPanel() {
		setLayout(new GridBagLayout());
		
		startComponents();
		
		setBackground(Color.DARK_GRAY);
		setVisible(true);	
	}

	private void startComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		pcontainer=new JPanel(new GridBagLayout());
		pcontainer.setPreferredSize(new Dimension(450, 450));
		pcontainer.setBackground(Color.DARK_GRAY);
		
		lname=new JLabel("Enter complete name:");
		lname.setForeground(Color.WHITE);
		lname.setFont(new Font("Arial",ALLBITS, 18));
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		pcontainer.add(lname,gbc);
		
		ldate=new JLabel("Enter date of birth:");
		ldate.setForeground(Color.WHITE);
		ldate.setFont(new Font("Arial",ALLBITS, 18));
		gbc.gridy=1;
		pcontainer.add(ldate,gbc);
		
		tfname=new JTextField();
		tfname.setPreferredSize(new Dimension(200,30));
		tfname.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=0;
		gbc.gridx=1;
		pcontainer.add(tfname,gbc);
		
		dcdate=new JDateChooser();
		dcdate.setPreferredSize(new Dimension(200,30));
		dcdate.setBorder(new LineBorder(Color.black,2));
		gbc.gridy=1;
		pcontainer.add(dcdate,gbc);
		
		binsert=new JButton("Insert");
		binsert.setActionCommand("INSERT DATA");
		binsert.setFont(new Font("Arial",ALLBITS, 18));
		binsert.setBackground(Color.CYAN);
		binsert.setBorder(new LineBorder(Color.black));
		binsert.setPreferredSize(new Dimension(145, 30));
		gbc.gridwidth=2;
		gbc.gridx=0;
		gbc.gridy=2;
		pcontainer.add(binsert,gbc);
		
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weighty=1.0;
		gbc.weightx=1.0;
		add(pcontainer,gbc);
		
	}

	public JLabel getLname() {
		return lname;
	}

	public void setLname(JLabel lname) {
		this.lname = lname;
	}

	public JLabel getLdate() {
		return ldate;
	}

	public void setLdate(JLabel ldate) {
		this.ldate = ldate;
	}

	public JTextField getTfname() {
		return tfname;
	}

	public void setTfname(JTextField tfname) {
		this.tfname = tfname;
	}

	public JDateChooser getDcdate() {
		return dcdate;
	}

	public void setDcdate(JDateChooser dcdate) {
		this.dcdate = dcdate;
	}

	public JButton getBinsert() {
		return binsert;
	}

	public void setBinsert(JButton binsert) {
		this.binsert = binsert;
	}

}
