package boletin1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		Path path = Paths.get("src", "boletin1", "archivos", "ejercicio5.txt");
		Scanner sc = new Scanner(System.in);
		String nombre = "";
		int edad;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile(), true))) {
			
			System.out.println("Introduce tu nombre: ");
			nombre = sc.nextLine();
			
			System.out.println("Introduce tu edad: ");
			edad = sc.nextInt();
			
			bw.write(nombre + " -> " + edad + "años");
			
			bw.newLine();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		sc.close();

	}

}
