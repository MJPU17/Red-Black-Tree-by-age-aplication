package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultTreeCellRenderer;

import co.edu.unbosque.util.RBNode;
import co.edu.unbosque.util.RedBlackTree;

public class TreePanel extends JPanel{
	
	private JLabel ltree,lroute;
	private JTree tredblack;
	private JTextArea taroute;
	private JScrollPane sptree,sproute;
	private RBTreeNode root;
	
	public TreePanel() {
		setLayout(new GridBagLayout());
		setBackground(Color.darkGray);	
		setVisible(true);
	}

	public void startingComponents(RedBlackTree<?> tree) {
		removeAll();
		
		GridBagConstraints gbc=new GridBagConstraints();
		
    	Image redImage = new ImageIcon("src/resources/rojo.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
    	ImageIcon redIcon = new ImageIcon(redImage);
    	
    	Image blackImage = new ImageIcon("src/resources/negro.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
    	ImageIcon blackIcon = new ImageIcon(blackImage);
		
		if(tree.getRoot()==null) {
			root=new RBTreeNode();
		}
		else {
			root=new RBTreeNode(tree.getRoot().getKey().toString(),tree.getRoot().isColor());
			addNodes(root, tree.getRoot());
		}
		tredblack=new JTree(root);
		for (int i = 0; i < tredblack.getRowCount(); i++) {
			tredblack.expandRow(i);
		}
		tredblack.setCellRenderer(new DefaultTreeCellRenderer() {
			@Override
			public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
					boolean leaf, int row, boolean hasFocus) {
				super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
				if(value instanceof RBTreeNode) {
					RBTreeNode node=(RBTreeNode)value;
					if(node.isColor()==false) {
						setIcon(blackIcon);
					}
					else {
						setIcon(redIcon);
					}
				}
				return this;
			}
		});
		sptree=new JScrollPane(tredblack);
		sptree.setPreferredSize(new Dimension(350,350));
		sptree.setBorder(new LineBorder(Color.black,2));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		add(sptree,gbc);
		
		ltree=new JLabel("Red-Black Tree");
		ltree.setForeground(Color.WHITE);
		ltree.setFont(new Font("Arial",ALLBITS, 18));
		ltree.setPreferredSize(new Dimension(350, 30));
		ltree.setHorizontalAlignment(JLabel.CENTER);
		gbc.gridy=1;
		add(ltree,gbc);
		
		taroute=new JTextArea(route(tree));
		taroute.setEditable(false);
		taroute.setFont(new Font("Arial",ALLBITS, 18));
		taroute.setWrapStyleWord(true);
        taroute.setLineWrap(true);
		sproute=new JScrollPane(taroute);
		sproute.setBorder(new LineBorder(Color.black,2));
		sproute.setPreferredSize(new Dimension(350,350));
		gbc.gridy=0;
		gbc.gridx=1;
		add(sproute,gbc);
		
		lroute=new JLabel("Postorder");
		lroute.setForeground(Color.WHITE);
		lroute.setFont(new Font("Arial",ALLBITS, 18));
		lroute.setPreferredSize(new Dimension(350, 30));
		lroute.setHorizontalAlignment(JLabel.CENTER);
		gbc.gridy=1;
		add(lroute,gbc);
		
	}
	
	
	
	public void addNodes(RBTreeNode node, RBNode<?> root) {
		if (root.getLeft() != null) {
			RBTreeNode left = new RBTreeNode(root.getLeft().getKey().toString(),root.getLeft().isColor());
			node.add(left);
			addNodes(left, root.getLeft());
		}
		if (root.getRight() != null) {
			RBTreeNode right = new RBTreeNode(root.getRight().getKey().toString(),root.getRight().isColor());
			node.add(right);
			addNodes(right, root.getRight());
		}
	}
	
	public String route(RedBlackTree<?> tree) {
		StringBuffer sb=new StringBuffer();
		int i=1;
		for(Object object:tree.postOrder()) {
			sb.append(i+")"+object.toString()+"\n");
			i++;
		}
		return sb.toString();
	}

	public JLabel getLtree() {
		return ltree;
	}

	public void setLtree(JLabel ltree) {
		this.ltree = ltree;
	}

	public JLabel getLroute() {
		return lroute;
	}

	public void setLroute(JLabel lroute) {
		this.lroute = lroute;
	}

	public JTree getTredblack() {
		return tredblack;
	}

	public void setTredblack(JTree tredblack) {
		this.tredblack = tredblack;
	}

	public JTextArea getTaroute() {
		return taroute;
	}

	public void setTaroute(JTextArea taroute) {
		this.taroute = taroute;
	}

	public JScrollPane getSptree() {
		return sptree;
	}

	public void setSptree(JScrollPane sptree) {
		this.sptree = sptree;
	}

	public JScrollPane getSproute() {
		return sproute;
	}

	public void setSproute(JScrollPane sproute) {
		this.sproute = sproute;
	}

	public RBTreeNode getRoot() {
		return root;
	}

	public void setRoot(RBTreeNode root) {
		this.root = root;
	}

}
