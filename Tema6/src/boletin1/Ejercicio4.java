package boletin1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String linea = "";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\boletin1\\archivos\\ejercicio4.txt", true))) {
			
			System.out.println("Introduce Cosas en el Fichero: ");
			linea = sc.nextLine();
			
			while(!linea.equals("fin")) {
				bw.write(linea);
				bw.newLine();
				
				System.out.println("Introduce Cosas en el Fichero: ");
				linea = sc.nextLine();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		sc.close();
	}

}
