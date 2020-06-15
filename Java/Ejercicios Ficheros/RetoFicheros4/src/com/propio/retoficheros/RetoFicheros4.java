package com.propio.retoficheros;
import java.io.*;
/*
*
* Objetivo:
* . Un programa que muestre en pantalla todo el contenido del fichero "nombres2.txt".
* */

public class RetoFicheros4 {

    public static void main(String[] args) {

        // It is supposed "nombres2.txt" was created
        File file = new File("nombres2.txt");
        // I need a class to read file, something like File Reader
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                String line = bufferedReader.readLine();
                // si es null no rompe
                while(line != null) {
                    System.out.println("la linea es " + line);
                    line = bufferedReader.readLine();
                }
                fileReader.close();
            }
            catch (IOException ex) {
                System.out.println("An exception has ocurred reading line in buffered");
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("An exception has ocurred in file reader to open the file");
        }
    }
}

/*
* Es necesario conocer un poco de los streams para poder operar
* Es logico pensar en un file reader. Pero no basta. El file reader y el reader permiten leer caracteres individuales o buffers (aun no se que son)
* pero no "lineas" de string
* Hay que dar otro paso, donde el reader tiene una clase hija que es para leer Buffers (sea lo que sea) y que si me permite hacer esto
* La clase abstracta Reader de por si, permite leer streams de caracteres
* El Filereader tiene un link misterioso a InputStreamReader que usa el BufferedReader y de ahi sale la idea
* Leyendo la documentacion se puede leer que el readline si es no tiene nada devuelve null
* */