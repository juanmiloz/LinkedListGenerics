package model;

public interface ListaEnlazadaOrdenada <T extends Comparable<T>> {
	public void addOrdenered(T newOrdered);
	public void deleteElement(T deleteElement);
	public void deleteByPosition(int position);
	public int getLength();
	public int getPositionElement(T element);
	public T getElementByPosition(int position);
	public void deleteAll();
	public String showElements();
}
