package com.ficheros.principal;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyFile {

    public static void main(String args[]) {

        // Creo un lector de files de texto y un escritor de files de texto
        // Podria usar otros, pero estos son los basicos
        // La api es muy clara, tengo un file, y estos dos son los primeros que se analizan
        // Es uno de los ejemplos mas sencillos, donde se presuponen creados los dos archivos de antemano, uno con informacion y el otro vacio

        FileReader fileReader;
        FileWriter fileWriter;

        try {
            // creados de antemano, el primero con contenido el segundo vacio
            fileReader = new FileReader("input.txt");
            fileWriter = new FileWriter("output.txt");

            int character;

            // read lee un caracter hasta que no hay mas
            while((character = fileReader.read()) != -1) {
                fileWriter.write(character);
            }
            fileReader.close();
            fileWriter.close();
        }
        catch (Exception e) {
            // Atrapa FileNotFoundException y IOException
        }
        finally {
            // Ira algo aca pero cerre las conexiones arriba
        }
    }
}
