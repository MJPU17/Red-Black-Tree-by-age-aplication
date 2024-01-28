package co.edu.unbosque.util;

public class RBNode<T> {
	
	private T key;
	private boolean color;
	private RBNode<T> father,left,right;
	
	public RBNode() {}
	
	public RBNode(T key, boolean color, RBNode<T> father, RBNode<T> left, RBNode<T> right) {
		this.key = key;
		this.color = color;
		this.father = father;
		this.left = left;
		this.right = right;
	}
	
	public RBNode(T key, boolean color) {
		this.key = key;
		this.color = color;
		this.father = null;
		this.left = null;
		this.right = null;
	}


	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public RBNode<T> getFather() {
		return father;
	}

	public void setFather(RBNode<T> father) {
		this.father = father;
	}

	public RBNode<T> getLeft() {
		return left;
	}

	public void setLeft(RBNode<T> left) {
		this.left = left;
	}

	public RBNode<T> getRight() {
		return right;
	}

	public void setRight(RBNode<T> right) {
		this.right = right;
	}
	
	public RBNode<T> getGrandfather(){
		if(father!= null) {
			return father.father;
		}
		return null;
	}
	
	public static boolean colorNode(RBNode<?> node) {
		if(node==null) {
			return false;
		}
		return node.color;
	}

	@Override
	public String toString() {
		String rbnode="[key=" + key + ", color=" + (color?"Rojo":"Negro") +"]";
		if(father!=null) {
			rbnode=father.toString()+"\\"+rbnode;
		}
		return rbnode;
	}
	
	

}
