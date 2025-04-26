package boletin1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio7 {

	
	static HashMap<String, Integer> agenda = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Set <String> claves = null;
		int opcion;
		String nombre;
		int telefono;
		
		try (BufferedReader br = new BufferedReader(new FileReader("src\\boletin1\\archivos\\ejercicio7.txt"))) {
		    String linea;
		    while ((linea = br.readLine()) != null) {
		        String[] partes = linea.split(": ");
		        if (partes.length == 2) {
		            nombre = partes[0];
		            telefono = Integer.parseInt(partes[1]);
		            agenda.put(nombre, telefono);
		        }
		    }
		    System.out.println("Datos cargados correctamente.");
		} catch (IOException e) {
		    System.out.println("No se encontraron datos guardados. La Agenda está Vacía.");
		} catch (NumberFormatException e) {
		    System.out.println("Error en el formato de algún teléfono en el archivo.");
		}
		
		do {
			menu();
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch(opcion) {
			
				case 1 -> {
					System.out.println("=== Nuevo Contacto ===");
					System.out.println("Indica el Nombre: ");
					nombre = sc.nextLine();
					System.out.println("Indica el Telefono: ");
					telefono = sc.nextInt();
					sc.nextLine();
					System.out.print(introduceDatos(nombre, telefono));
				}
				
				case 2 -> {
					System.out.println("=== Buscador ===");
					System.out.println("Indica el Nombre del Contacto para Conocer su Telefono: ");
					nombre = sc.nextLine();
					if(agenda.containsKey(nombre)) {
						System.out.println("Nombre: " + nombre + " Telefono: " + agenda.get(nombre));
					} else {
						System.err.println("El Nombre Indicado (" + nombre + ") no se Encuentra en la Agenda.");
					}
				}
				
				case 3 -> {
					claves = agenda.keySet();
					List<String> listaNombres = new ArrayList<>(claves);
					Collections.sort(listaNombres);
					System.out.println("=== Agenda ===");
					for(String nom : listaNombres) {
						telefono = agenda.get(nom);
						System.out.println("Nombre: " + nom + " Telefono: " + telefono);
					}
				}
				
				case 4 -> {
				    try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\boletin1\\archivos\\ejercicio7.txt", false))) {
	
				        for (Map.Entry<String, Integer> entrada : agenda.entrySet()) {
				            String linea = entrada.getKey() + ": " + entrada.getValue();
				            bw.write(linea);
				            bw.newLine();
				        }
	
				    } catch (IOException e1) {
				        e1.printStackTrace();
				    }
	
				    String mensajeBase = "Guardando datos antes de salir";
				    try {
				        for (int i = 0; i < 3; i++) {
				            System.out.print(mensajeBase);
				            Thread.sleep(1000);
				            System.out.print(".");
				            Thread.sleep(1000);
				            System.out.print(".");
				            Thread.sleep(1000);
				            System.out.print(".");
				            Thread.sleep(1000);
				            System.out.print("\r");
				        }
				    } catch (InterruptedException e) {
				        e.printStackTrace();
				    }
	
				    System.out.println("\nDatos guardados correctamente.");
				}
				
				default -> {
					System.out.println("Opción (" + opcion + ") no Válida. Recuerda 1, 2, 3 o 4 🖤");
				}
			}
			
		} while(opcion != 4);
		
		System.err.println("Programa Finalizado.");
		sc.close();
	}
	
	static String introduceDatos(String nombre, int telefono) {
		
		String mensaje = "";
		
		if(agenda.size() < 20) {
			
			if(!agenda.containsKey(nombre)) {
				
				agenda.put(nombre, telefono);
				mensaje = "Contacto Agregado Correctamente.";
				
			} else {
				mensaje = "Error. El Nombre Indicado ya se Encuentra Insertado.";
			}
			
		} else {
			mensaje = "La agenda está completa.";
		}
		
		return mensaje;
		
	}
	
	static void menu() {
		System.out.println("\n---Menú---\n"
				+ "1. Nuevo contacto.\r\n"
				+ "2. Buscar por nombre.\r\n"
				+ "3. Mostrar todos.\r\n"
				+ "4. Salir.\r\n"
				+ "- Elección: ");
	}

}
