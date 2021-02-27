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
	public boolean deleteElement(T deleteElement) {
		boolean delete = false;
		if(first.getElement().equals(deleteElement)) {
			first = first.getNext();
			delete = true;
		}else {
			delete = deleteElement(first, deleteElement);
		}
		return delete;
	}

	public boolean deleteElement(Nodo<T> current, T deleteElement) {
		boolean delete = false;
		if(current.getNext() != null && current.getNext().getElement().equals(deleteElement)) {
			current.setNext(current.getNext().getNext());
			delete = true;
		}else if(current.getNext() != null){
			delete = deleteElement(current.getNext(), deleteElement);
		}
		return delete;
	}

	@Override
	public boolean deleteByPosition(int position) {
		boolean success;


		if(position<0 || position> getLength()) {
			success=false;
		}else {
			

			if(position==0) {
				first=first.getNext();
				success=true;
			}else {
				int cont=0;
				Nodo<T>temp1= first;
				Nodo<T>temp2= first;

				while(cont<position && temp1.getNext()!=null) {
					temp2=temp1;
					temp1= temp1.getNext();
					cont++;
				}
				
				if(temp1.getNext()==null) {
					temp2.setNext(null);
					success=true;
				}else {
					temp2.setNext(temp1.getNext());
					success=true;
				}
			
			}

		}


		return success;


	}

	@Override
	public int getLength() {
		int cont = 0;
		Nodo<T>temp= first;
		while(temp!=null) {
			cont++;
			temp= temp.getNext();
		}
		return cont;
	}



	@Override
	public int getPositionElement(T searchElement) {
		int pos=0;

		Nodo<T>temp= first;

		while(!temp.getElement().equals(searchElement) && temp.getNext()!=null) {
			pos++;
			temp= temp.getNext();
		}

		if(!temp.getElement().equals(searchElement)) {
			pos=-1;
		}

		return pos;
	}



	@Override
	public T getElementByPosition(int position) {
		T element = null;


		if(position<0 || position>= getLength()) {
			element=null;
		}else {
			int cont=0;

			Nodo<T>temp= first;

			while(cont<position) {
				temp= temp.getNext();
				cont++;
			}

			element=temp.getElement();

		}


		return element;
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
