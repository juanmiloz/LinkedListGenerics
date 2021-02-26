package model;

public class Nodo<T extends Comparable<T>> {

	private T element;
	private Nodo<T> next;
	
	public Nodo(T element) {
		this.element = element;
		this.next = null;
	}
	
	public T getElement() {
		return element;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
	public Nodo<T> getNext(){
		return next;
	}
	
	public void setNext(Nodo<T> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return element.toString();
	} 
}
