package model;

public class LinkedListOrdered<T extends Comparable<T>> implements ListaEnlazadaOrdenada<T> { 
	
	private Nodo<T> first;
	
	public LinkedListOrdered() {
		this.first = null;
	}

	public Nodo<T> getFirst() {
		return first;
	}

	public void setFirst(Nodo<T> first) {
		this.first = first;
	}

	@Override
	public void addOrdenered(T newOrdered) {
		if(first == null) {
			first = new Nodo<T>(newOrdered);
		}else {
			if(first.getElement().compareTo(newOrdered)<0) {
				Nodo<T> temp = new Nodo<T>(newOrdered);
				temp.setNext(first);
				first = temp;
			}else {
				addOrdered(first, newOrdered);
			}
		}
	}
	
	public void addOrdered(Nodo<T> current, T newOrdered) {
		if(current.getElement().compareTo(newOrdered)>0 && current.getNext() == null) {
			current.setNext(new Nodo<T>(newOrdered));
		}else if(current.getElement().compareTo(newOrdered)>0 && current.getNext() != null) {
			if(current.getNext().getElement().compareTo(newOrdered)<=0) {
				Nodo<T> temp = new Nodo<T>(newOrdered);
				temp.setNext(current.getNext());
				current.setNext(temp);
			}else {
				addOrdered(current.getNext(), newOrdered);
			}
		}
	}

	@Override
	public void deleteElement(T deleteElement) {
		
	}

	@Override
	public void deleteByPosition(int position) {
		
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T getPositionElement(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getElementByPosition(int position) {
		
		return null;
	}

	@Override
	public void deleteAll() {
		
	}

	@Override
	public String showElements() {
		/*
		if(first != null) ;
			System.out.println(first.toString());
			System.out.println(first.toString());
			System.out.println(first.toString());
		}else {
			System.err.println("No hay");
		}*/
		return null;
	}
	
	

}
