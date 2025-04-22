package boletin1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		
		try (BufferedReader bf = new BufferedReader(new FileReader("src\\boletin1.archivos\\ejercicio3"))){
			
			
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
