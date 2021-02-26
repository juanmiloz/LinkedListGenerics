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
		if(first.getElement().equals(deleteElement)) {
			Nodo<T> temp = new Nodo<T>(deleteElement);
			temp.setNext(first.getNext());
			first = temp;
		}else {
			deleteElement(first, deleteElement);
		}
	}
	
	public void deleteElement(Nodo<T> current, T deleteElement) {
		if(current.getNext().getElement().equals(deleteElement)) {
			Nodo<T> temp = new Nodo<T>(deleteElement);
			temp.setNext(current.getNext().getNext());
			current.setNext(temp);
		}else {
			deleteElement(current.getNext(), deleteElement);
		}
	}
	
	@Override
	public void deleteByPosition(int position) {
		
	}

	@Override
	public int getLength() {
		int cont = 0;
		if(first!=null) {
			cont += 1;
			cont += getLength(first);
		}
		return cont;
	}
	
	public int getLength(Nodo<T> current) {
		int cont = 0;
		if(current.getNext()!= null) {
			cont += 1;
			cont += getLength(current.getNext());
		}
		return cont;
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
		first = null;
	}

	@Override
	public String showElements() {
		String message = "";
		int cont = 0;
		if(first != null) {
			cont += 1;
			message += cont + "- ===============================================\n";
			message += first.getElement().toString()+"\n";
			message += showElements(first.getNext(),cont);
		}else {
			message = "Lista vacia"; 
		}
		return message;
	}
		
	public String showElements(Nodo<T> current, int cont) {
		String message = "";
		if(current != null) {
			cont += 1;
			message += cont + "- ===============================================\n";
			message += current.getElement().toString()+"\n";
			message += showElements(current.getNext(),cont);
		}
		return message;
	}
	
}
