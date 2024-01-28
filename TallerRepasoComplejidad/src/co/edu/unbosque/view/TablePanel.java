package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TablePanel extends JPanel{
	
	private JScrollPane sptable;
	private JTable ttable;
	private JComboBox<String> cborder;
	
	public TablePanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.DARK_GRAY);
		
		startingComponents();
		
		setVisible(false);
	}
	
	private void startingComponents() {
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		ttable=new JTable();
		ttable.setBorder(new LineBorder(Color.black));
		sptable=new JScrollPane(ttable);
		sptable.setPreferredSize(new Dimension(600,345));
		gbc.gridy=0;
		gbc.gridx=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weighty=1.0;
		gbc.weightx=1.0;
		add(sptable,gbc);
		
		cborder=new JComboBox<>();
		cborder.setToolTipText("Select order of information.");
		cborder.setActionCommand("ORDER");
		cborder.addItem("Normal by addition");
		cborder.addItem("Descending by age");
		cborder.setFont(new Font("Arial",ALLBITS, 18));
		cborder.setBackground(Color.CYAN);
		cborder.setBorder(new LineBorder(Color.BLACK));
		cborder.setPreferredSize(new Dimension(200,30));
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.ipady=10;
		add(cborder,gbc);
		
	}
	
	public void startingTable(String[]columns, String[][] information) {
		ttable.setModel(new DefaultTableModel(information, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		for(int i=0;i<columns.length;i++) {
			ttable.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
				@Override
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {
					Component celda=super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
					((JLabel)celda).setHorizontalAlignment(JLabel.CENTER);
					return celda;				
				}
			});
		}
		ttable.setRowHeight(32);
	}

	public JScrollPane getSptable() {
		return sptable;
	}

	public void setSptable(JScrollPane sptable) {
		this.sptable = sptable;
	}

	public JTable getTtable() {
		return ttable;
	}

	public void setTtable(JTable ttable) {
		this.ttable = ttable;
	}

	public JComboBox<String> getCborder() {
		return cborder;
	}

	public void setCborder(JComboBox<String> cborder) {
		this.cborder = cborder;
	}

}
