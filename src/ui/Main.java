package ui;
import java.util.Scanner;

import model.*;

public class Main {

	private static Scanner in = new Scanner(System.in);
	private static LinkedListOrdered<Prueba> linked = new LinkedListOrdered<>();
	
	public static void main(String[] args) {
		boolean exit = true;
		while(exit) {
			menu();
			System.out.println("regresar a menu?\n(1) si\n(2) No");
			int answer = Integer.parseInt(in.nextLine());
			exit = (answer == 1)?true:false;
		}
	}
	
	public static void menu() {
		System.out.println("opciones: ");
		System.out.println("(1)<--Agregar pruebas");
		System.out.println("(2)<--Imprimir lista enlazada");
		System.out.println("(3)<--Buscar Posición");
		int option = Integer.parseInt(in.nextLine());
		
		switch(option) {
			case 1:
				addTest();
			break;
			
			case 2:
				printList();
			break;
			
			case 3:
				//searchElemPosList();
			break;
				
		}
	}
	
	public static void addTest() {
		Prueba p1 = new Prueba("ford","raptor",2018);
		Prueba p2 = new Prueba("ford","fusion",2016);
		Prueba p3 = new Prueba("kia","sportage",2017);
		Prueba p4 = new Prueba("audi","R8",2021);
		Prueba p5 = new Prueba("audi","A4",2018);
		
		linked.addOrdenered(p1);
		linked.addOrdenered(p2);
		linked.addOrdenered(p3);
		linked.addOrdenered(p4);
		linked.addOrdenered(p5);
		//System.out.println(linked.getPositionElement(p1));
		//System.out.println(linked.getLength());
		//System.out.println(linked.getElementByPosition(1));
		
	}
	
	public static void printList() {
		System.out.println(linked.showElements());
		//System.out.println(linked.deleteByPosition(3));
	}
	
	
}
