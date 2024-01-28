package co.edu.unbosque.util;

public class RedBlackTree<T extends Comparable<T>> {
	
	private RBNode<T> root;
	private MyLinkedList<T> route;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	public RedBlackTree() {
		root=null;
		route=new MyLinkedList<>();
	}

	public RBNode<T> getRoot() {
		return root;
	}

	public void setRoot(RBNode<T> root) {
		this.root = root;
	}

	public MyLinkedList<T> getRoute() {
		return route;
	}

	public void setRoute(MyLinkedList<T> route) {
		this.route = route;
	}
	
	public void leftRotate(RBNode<T> node) {
		RBNode<T> rigthChild=node.getRight();
		node.setRight(rigthChild.getLeft());
		if(rigthChild.getLeft()!=null) {
			rigthChild.getLeft().setFather(node);
		}
		
		rigthChild.setFather(node.getFather());
		if(rigthChild.getFather()==null) {
			root=rigthChild;
		}
		else if(node==node.getFather().getLeft()) {
			node.getFather().setLeft(rigthChild);
		}
		else {
			node.getFather().setRight(rigthChild);
		}
		rigthChild.setLeft(node);
		node.setFather(rigthChild);
	}
	
	public void rigthRotate(RBNode<T> node) {
		RBNode<T> leftChild=node.getLeft();
		node.setLeft(leftChild.getRight());
		if(leftChild.getRight()!=null) {
			leftChild.getRight().setFather(node);
		}
		
		leftChild.setFather(node.getFather());
		if(leftChild.getFather()==null) {
			root=leftChild;
		}
		else if(node==node.getFather().getLeft()) {
			node.getFather().setLeft(leftChild);
		}
		else {
			node.getFather().setRight(leftChild);
		}
		leftChild.setRight(node);
		node.setFather(leftChild);
	}
	
	public void fixedRedBlackTree(RBNode<T> node) {
		while(RBNode.colorNode(node.getFather())==RED) {
			if(node.getFather()==node.getGrandfather().getLeft()) {
				if(RBNode.colorNode(node.getGrandfather().getRight())==RED) {
					node.getFather().setColor(BLACK);
					node.getGrandfather().getRight().setColor(BLACK);
					node.getGrandfather().setColor(RED);
					node=node.getGrandfather();
				}
				else {
					if(node==node.getFather().getRight()) {
						node=node.getFather();
						leftRotate(node);
					}
					node.getFather().setColor(BLACK);
					node.getGrandfather().setColor(RED);
					rigthRotate(node.getGrandfather());
				}
			}
			else {
				if(RBNode.colorNode(node.getGrandfather().getLeft())==RED) {
					node.getFather().setColor(BLACK);
					node.getGrandfather().getLeft().setColor(BLACK);
					node.getGrandfather().setColor(RED);
					node=node.getGrandfather();
				}
				else {
					if(node==node.getFather().getLeft()) {
						node=node.getFather();
						rigthRotate(node);
					}
					node.getFather().setColor(BLACK);
					node.getGrandfather().setColor(RED);
					leftRotate(node.getGrandfather());
				}
			}
		}
		root.setColor(BLACK);
	}
	
	public void insert(T key) {
		RBNode<T> newNode=new RBNode<>(key,RED);
		RBNode<T> current=root;
		RBNode<T> father=null;
		while(current!=null) {
			father=current;
			if(newNode.getKey().compareTo(current.getKey())<=0) {
				current=current.getLeft();
			}
			else {
				current=current.getRight();
			}
		}
		if(father==null) {
			root=newNode;
		}
		else if(newNode.getKey().compareTo(father.getKey())<=0) {
			father.setLeft(newNode);
		}
		else {
			father.setRight(newNode);
		}
		newNode.setFather(father);
		fixedRedBlackTree(newNode);
	}
	
	public void postOrderRec(RBNode<T> root) {
		if(root!=null) {
			postOrderRec(root.getLeft());
			postOrderRec(root.getRight());
			route.addLast(root.getKey());
		}
	}
	
	public MyLinkedList<T> postOrder() {
		route.clear();
		postOrderRec(root);
		return route;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		int level=0;
		MyLinkedList<RBNode<T>> aux=new MyLinkedList<>();
		aux.add(root);
		while (!aux.isEmpty()) {
			int n=aux.getSize();
			sb.append("Level "+level+": \n");
			while (n>0) {
				RBNode<T> u=aux.get(aux.getSize()-1);
				aux.remove(aux.getSize()-1);
				sb.append(u.toString()+"\n");
				if(u.getLeft()!=null)aux.add(u.getLeft());
				if(u.getRight()!=null)aux.add(u.getRight());
				n--;
			}
			sb.append("\n");
			level++;
		}
		return sb.toString();
	}
	

}
