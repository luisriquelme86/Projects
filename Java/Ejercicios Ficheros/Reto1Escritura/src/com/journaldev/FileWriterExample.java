package com.journaldev;


import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

    public static void main(String[] args) {

        // donde lo abro para escribir, path absoluto o relativo
        String nombre = "file.txt";
        FileWriter fileWriter = null;
        FileWriter otroFileWriter = null;
        try {
            // en este modo siempre lo crea y lo pisa si esta creado
            fileWriter = new FileWriter(nombre);
            fileWriter.write("This is a FileWriter example");

            otroFileWriter = new FileWriter("otrofile.txt", true);
            // se escribira esto tantas veces como abra el archivo
            otroFileWriter.write("nuevo dato" + "\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
                if (otroFileWriter != null) {
                    otroFileWriter.close();
                }
            }
            catch (IOException ioex) {
                ioex.printStackTrace();
            }
        }
    }

}

/*
* Escritura de archivos de texto
*
* donde
* abrir => a veces es por modo. Cargo en memoria secundaria ese archivo
* si existe lo abre, sino lo crea. puede poner el puntero al final si ya existe para abrir y escribirlo
* escribe
* cierra
*
* Adicionales en java: obliga a atrapar excepciones en caso de errores de abrir el archivo
*
* */
