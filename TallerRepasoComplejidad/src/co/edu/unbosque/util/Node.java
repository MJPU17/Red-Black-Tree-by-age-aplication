package co.edu.unbosque.util;

import java.io.Serializable;

public class Node<T> implements Serializable{
	
	private static final long serialVersionUID = 5101361749593814689L;
	private T info;
	private Node<T> next;
	
	public Node() {}

	public Node(T info, Node<T> next) {
		this.info = info;
		this.next = next;
	}
	
	public Node(T info) {
		this.info = info;
		this.next = null;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	
}
