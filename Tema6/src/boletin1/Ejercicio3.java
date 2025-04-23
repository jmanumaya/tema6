package boletin1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicio3 {

	private static final String RUTA_TXT = "src\\boletin1\\archivos\\ejercicio3.txt";

	public static void main(String[] args) {
		
		String line;
		
		String datos[];
		
		int mediaEdades = 0;
		
		int sumaEdades = 0;
		
		int count = 0;
		
		double mediaAlturas = 0;
		
		double sumaAlturas = 0;
		
		try (BufferedReader bf = new BufferedReader(new FileReader(RUTA_TXT))){
			
			line = bf.readLine();
			
			while(line != null) {
				
				line = line.trim();
				
				datos = line.split(" ");
				
				System.out.println(line);

				sumaEdades += Integer.parseInt(datos[1]);
				sumaAlturas += Double.parseDouble(datos[2]);
				
				++count;
				
				line = bf.readLine();
			}
			
			mediaEdades = sumaEdades / count;
			mediaAlturas = sumaAlturas / count;
			
			System.out.println("Media de Edades: " + mediaEdades);
			System.out.println("Media de Alturas: " + mediaAlturas);
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
