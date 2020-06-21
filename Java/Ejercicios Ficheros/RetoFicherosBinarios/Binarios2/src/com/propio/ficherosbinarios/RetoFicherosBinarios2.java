package com.propio.ficherosbinarios;

/*
* - Objetivo:
. Un programa que copie el contenido del archivo binario project.zip a otro fichero llamado project_copy.zip
. En este caso, la idea no es copiar de a un byte, sino de a mas
. Dicho de otra forma, copiar el archivo
* */

/*
 * En el ejercicio anterior, copiaba un archivo byte a byte en otro
 * El ejercicio de aqui es diferente: Dado un archivo, copio todos los bytes de un archivo origen en otro destino
 * El objetivo no es la eficiencia, sino para fines demostrativos. Es claro que no es conveniente porque si el archivo es enorme
 * puede haber desbordes de memoria o cosas asi. Para fines didactivos es perfecto
 * */

import java.io.*;

public class RetoFicherosBinarios2 {

    public static void main(String[] args) {


        // It is supposed to be created "project.zip"
        File fileOrigin = new File("project.zip");
        File fileDestination = new File("project_copy.zip");
        try {
            FileInputStream in = new FileInputStream(fileOrigin);
            FileOutputStream out = new FileOutputStream(fileDestination);
            // para leer, uso read que devuelve un int que indica la cantidad de bytes leidos
            try {
                /*
                * Esto no es valido y es un error de logica. Estoy leyendo bytes con un input stream y guardo el numero de bytes leidos
                * Luego ese numero (proe ejemplo, lei 686 bytes) lo quiero escribir con write, que es mas similar a write(int b) o sea un byte especifico
                * Solo guarda 1 byte de informacion, el de la posicion, digamos el byte 686
                * */

                // int bytesRead = in.read(allBytes);
                // System.out.println("Bytes read " + bytesRead);
                // aca dice : Writes the specified byte to this file output stream. O sea, solo un byte en special
                // out.write(bytesRead);

                /*
                * Menciones y errores
                * Inicialmente quise solo hacer out.write(allBytes) y que funcionara. Imposible sin hacer el read
                * Lo considere "lleno de informacion". Pero la primera linea de allBytes, no "llena" nada, solo declara un array de bytes de "x" size
                * La linea in.read(allBytes) se puede interpretar como "el input stream (canal por donde circulan datos de entrada)
                * "lee" los datos asociados (el fileOrigin). Pero a donde los asigna? Funciona parecido a los "read" de pascal, donde se toma un texto y lo asigna a la variable
                * Aca es lo mismo, lee los datos del file con un stream y los asigna a la variable allBytes (se podria decir que los rellena) Si leemos la documentacion
                * read(byte[] b)
                * Reads up to b.length bytes of data from this input stream into an array of bytes.
                *
                * */
                // int [] array = new int[10]
                byte[] allBytes = new byte[(int) fileOrigin.length()];
                in.read(allBytes);
                out.write(allBytes);
                in.close();
                out.close();
            }
            catch (IOException e) {
                //
            }
            // el loop de abajo es incorrecto, lo puse solo por costumbre
            /*
            int bytesRead;
            try {
                while((bytesRead = in.read(allBytes)) != -1) {

                }
            }
            catch (IOException e) {
                //
            } */
        }
        catch (FileNotFoundException e) {
            //
        }
    }
}
