package com.blogspot.puntocomnoesunlenguaje;


/*
*
*  Leer lineas de texto por teclado y escribirlas en un fichero de texto.*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Reto2Escritura {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        FileWriter fw = null;
        try {
            fw = new FileWriter("prueba.txt", true);
            while (!line.equalsIgnoreCase("FIN")) {
                fw.write(line + "\n");
                line = scanner.nextLine();
            }
            fw.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
