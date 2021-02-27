package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.LinkedListOrdered;
import model.Prueba;

class ListaEnlazadaOrdenadaTest {
	
	static Prueba p1 = new Prueba("ford","raptor",2018);
	static Prueba p2 = new Prueba("ford","fusion",2016);
	static Prueba p3 = new Prueba("kia","sportage",2017);
	static Prueba p4 = new Prueba("audi","R8",2021);
	static Prueba p5 = new Prueba("audi","A4",2018);
	
	@Test
	public void addOrderedTest() {
		LinkedListOrdered<Prueba> linked = new LinkedListOrdered<>();
		linked.addOrdenered(p1);
		linked.addOrdenered(p2);
		linked.addOrdenered(p3);
		linked.addOrdenered(p4);
		linked.addOrdenered(p5);
		
		assertEquals(p2, linked.getFirst().getElement());
		assertEquals(p3, linked.getFirst().getNext().getElement());
		assertEquals(p5, linked.getFirst().getNext().getNext().getElement());
		assertEquals(p1, linked.getFirst().getNext().getNext().getNext().getElement());
		assertEquals(p4, linked.getFirst().getNext().getNext().getNext().getNext().getElement());
	}
	
	@Test
	public void deleteElementTest() {
		LinkedListOrdered<Prueba> linked = new LinkedListOrdered<>();
		linked.addOrdenered(p1);
		linked.addOrdenered(p2);
		linked.addOrdenered(p3);
		linked.addOrdenered(p4);
		linked.addOrdenered(p5);
		
		linked.deleteElement(p5);
		
		assertEquals(p2, linked.getFirst().getElement());
		assertEquals(p3, linked.getFirst().getNext().getElement());
		assertEquals(p1, linked.getFirst().getNext().getNext().getElement());
		assertEquals(p4, linked.getFirst().getNext().getNext().getNext().getElement());
		
		linked.deleteElement(p2);
		
		assertEquals(p3, linked.getFirst().getElement());
		assertEquals(p1, linked.getFirst().getNext().getElement());
		assertEquals(p4, linked.getFirst().getNext().getNext().getElement());
		
		Prueba x = new Prueba("", "", 0);
		
		assertFalse(linked.deleteElement(x));
	}
	
	@Test
	public void deleteByPositionTest() {
		LinkedListOrdered<Prueba> linked = new LinkedListOrdered<>();
		linked.addOrdenered(p1);
		linked.addOrdenered(p2);
		linked.addOrdenered(p3);
		linked.addOrdenered(p4);
		linked.addOrdenered(p5);
		
		linked.deleteByPosition(3);
		
		assertEquals(p2, linked.getFirst().getElement());
		assertEquals(p3, linked.getFirst().getNext().getElement());
		assertEquals(p5, linked.getFirst().getNext().getNext().getElement());
		assertEquals(p4, linked.getFirst().getNext().getNext().getNext().getElement());
		
		linked.deleteByPosition(0);
		
		assertEquals(p3, linked.getFirst().getElement());
		assertEquals(p5, linked.getFirst().getNext().getElement());
		assertEquals(p4, linked.getFirst().getNext().getNext().getElement());
		
		assertFalse(linked.deleteByPosition(10));
	}
	
	@Test
	public void getLengthTest() {
		LinkedListOrdered<Prueba> linked = new LinkedListOrdered<>();
		linked.addOrdenered(p1);
		linked.addOrdenered(p2);
		linked.addOrdenered(p3);
		linked.addOrdenered(p4);
		linked.addOrdenered(p5);
		
		assertEquals(5, linked.getLength());
		
		linked.deleteByPosition(1);
		linked.deleteByPosition(1);
		
		assertEquals(3, linked.getLength());
	}
	
	@Test
	public void searchPositionElement() {
		LinkedListOrdered<Prueba> linked = new LinkedListOrdered<>();
		linked.addOrdenered(p1);
		linked.addOrdenered(p2);
		linked.addOrdenered(p3);
		linked.addOrdenered(p4);
		linked.addOrdenered(p5);
		
		assertEquals(linked.getPositionElement(p2),0);
		assertEquals(linked.getPositionElement(p3),1);
		assertEquals(linked.getPositionElement(p5),2);
		assertEquals(linked.getPositionElement(p1),3);
		assertEquals(linked.getPositionElement(p4),4);
		
		Prueba x = new Prueba("", "", 0);
		
		assertEquals(-1, linked.getPositionElement(x));
	}

	@Test
	public void getElementByPosition() {
		LinkedListOrdered<Prueba> linked = new LinkedListOrdered<>();
		linked.addOrdenered(p1);
		linked.addOrdenered(p2);
		linked.addOrdenered(p3);
		linked.addOrdenered(p4);
		linked.addOrdenered(p5);
		
		assertEquals(linked.getElementByPosition(0), p2);
		assertEquals(linked.getElementByPosition(1), p3);
		assertEquals(linked.getElementByPosition(2), p5);
		assertEquals(linked.getElementByPosition(3), p1);
		assertEquals(linked.getElementByPosition(4), p4);
		assertNull(linked.getElementByPosition(5));
		assertNull(linked.getElementByPosition(6));
	}
	
	@Test
	public void deleteAllTest() {
		LinkedListOrdered<Prueba> linked = new LinkedListOrdered<>();
		linked.addOrdenered(p1);
		linked.addOrdenered(p2);
		linked.addOrdenered(p3);
		linked.addOrdenered(p4);
		linked.addOrdenered(p5);
		
		linked.deleteAll();
		
		assertNull(linked.getFirst());
	}
}
