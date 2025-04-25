package boletin1;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio7 {

	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> agenda = new HashMap<>();
		int opcion;
		String nombre;
		int telefono;
		
		do {
			menu();
			opcion = sc.nextInt();
			
			switch(opcion) {
			
			case 1 -> {
				System.out.println("=== Nuevo Contacto ===");
				System.out.println("Indica el Nombre: ");
				nombre = sc.nextLine();
				System.out.println("Indica el Telefono: ");
				telefono = sc.nextInt();
				
			}
			}
			
		} while(opcion != 4);
			
	}
	
	static void menu() {
		System.out.println("---Menú---"
				+ "1. Nuevo contacto.\r\n"
				+ "2. Buscar por nombre.\r\n"
				+ "3. Mostrar todos.\r\n"
				+ "4. Salir.\r\n"
				+ "- Elección: ");
	}

}
