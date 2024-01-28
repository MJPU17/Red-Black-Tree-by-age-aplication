package co.edu.unbosque.view;

import javax.swing.tree.DefaultMutableTreeNode;

public class RBTreeNode extends DefaultMutableTreeNode{
	
	private boolean color;
	
	public RBTreeNode(Object object, boolean color) {
		super(object, true);
		this.color=color;
	}
	
	public RBTreeNode() {
		super();
		this.color=false;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

}
