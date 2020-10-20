package com.blogspot.puntocomnoesunlenguaje;
import java.io.FileWriter;
import java.util.Scanner;

/*- Objetivo:
 *  . Leer lineas de texto por teclado y escribirlas en un fichero de texto hasta teclear la palabra "fin"
 */

public class Principal {

    public static void main(String[] args) {
        System.out.println("Ingrese el texto deseado por linea. Cuando quiera terminar, ingrese la palabra 'fin' sin ninguna otra palabra en la nueva linea");
        // Asigno la entrada de teclado a un scanner
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("output.txt");
            while (!line.equalsIgnoreCase("FIN")) {
                fileWriter.write(line + "\n");
                line = scanner.nextLine();
            }
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
