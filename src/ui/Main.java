package ui;
import model.*;

public class Main {

	public static void main(String[] args) {
		Prueba p1 = new Prueba("ford","raptor",2018);
		Prueba p2 = new Prueba("ford","fusion",2016);
		Prueba p3 = new Prueba("kia","sportage",2017);
		Prueba p4 = new Prueba("audi","R8",2021);
		Prueba p5 = new Prueba("audi","A4",2018);
		
		LinkedListOrdered<Prueba> linked = new LinkedListOrdered<>();
		
		linked.addOrdenered(p1);
		System.out.println(linked.getFirst().toString());
		System.out.println("\n");
		
		linked.addOrdenered(p2);
		System.out.println(linked.getFirst().toString());
		System.out.println(linked.getFirst().getNext().toString());
		System.out.println("\n");
		
		linked.addOrdenered(p3);
		System.out.println(linked.getFirst().toString());
		System.out.println(linked.getFirst().getNext().toString());
		System.out.println(linked.getFirst().getNext().getNext().toString());
		System.out.println("\n");
		
		linked.addOrdenered(p4);
		System.out.println(linked.getFirst().toString());
		System.out.println(linked.getFirst().getNext().toString());
		System.out.println(linked.getFirst().getNext().getNext().toString());
		System.out.println(linked.getFirst().getNext().getNext().getNext().toString());
		System.out.println("\n");
		
		
		linked.addOrdenered(p5);
		System.out.println(linked.getFirst().toString());
		System.out.println(linked.getFirst().getNext().toString());
		System.out.println(linked.getFirst().getNext().getNext().toString());
		System.out.println(linked.getFirst().getNext().getNext().getNext().toString());
		System.out.println(linked.getFirst().getNext().getNext().getNext().getNext().toString());
		System.out.println("\n");
		
	}
}
