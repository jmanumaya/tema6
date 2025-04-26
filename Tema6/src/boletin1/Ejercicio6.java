package boletin1;

import java.io.*;
import java.util.*;

public class Ejercicio6 {
    public static void main(String[] args) {
    	
        List<Integer> numeros = new ArrayList<>();
        String linea;

        try (BufferedReader br = new BufferedReader(new FileReader("src\\boletin1\\archivos\\ejercicio6out.txt"))) {
            while ((linea = br.readLine()) != null) {
                numeros.add(Integer.parseInt(linea));
            }

            Collections.sort(numeros);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\boletin1\\archivos\\ejercicio6in.txt", true))) {
                for (int num : numeros) {
                    bw.write(String.valueOf(num));
                    bw.newLine();
                }
            }
            
            System.out.println("Terminado");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
