package com.propio.retoficheros;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

/* Objetivo:
   . Un programa que te pida nombres y los vaya volcando a un fichero de texto llamado "nombres2.txt", hasta que teclees "fin" (esa palabra no deberá volcarse a fichero)
 */

public class RetoFicheros3 {

    public static void main(String[] args) {

        // Recuerdo la clase Scanner para almacenar cosas por teclado
        // read by keyboard
        // importala
        /*
        boolean terminado = false;
        while (!terminado) {
            Scanner scanner = new Scanner(System.in);
            String nombre = scanner.nextLine();
            // especifico de java -> No se puede hacer nombre == "fin"
            if (nombre.equals("fin")) {
                terminado = true;
            }
            else {
                System.out.println("El nombre es: " + nombre);
            }
        } */
        // puedo usar mejor do while que verifica la condicion al final
        /* String name = "John";
        if (name == "John") {
            // Esto funciona por la memoria heap
            System.out.println("Hola soy John");
        } */


        File file = new File("nombres2.txt");
        FileWriter fileWriter ;
        // It is supposed to be created earlier
        if (file.exists()) {
            file.delete();
            try {
                boolean created = file.createNewFile();
                System.out.println("Archive created? " + created);
                /* fileWriter = new FileWriter(file);
                fileWriter.write("Luis");
                fileWriter.write("Pedro");
                fileWriter.write("Juan");
                fileWriter.close(); */
            }
            catch (Exception ex) {
                System.out.println("An exception as ocurred in new file creation");
            }
        }


        boolean seguirIngresando = true;
        try {
            fileWriter = new FileWriter(file) ;
            do {
                Scanner scanner = new Scanner(System.in);
                String nombre = scanner.nextLine();
                if (!nombre.equals("fin")) {
                    fileWriter.write(nombre + "\n");
                } else {
                    seguirIngresando = false;
                }
            } while (seguirIngresando);
            // aqui se garantiza que no es null porque estan dentro del try o se que fue todo bien
            fileWriter.close();
        }
        catch (IOException ioe) {
                System.out.println("An exception as ocurred in file write creation");
        }
        finally {
        }
    }

}

/*
* Primero tengo que descomponen la tarea en otras mas sencillas
* Pasos:
* Paso 1:
*   . Primero que pida nombres por teclado, y que cuando se teclee fin deje de pedirlos
*   . Cada vez que se ingresen, muestro un mensaje del estilo "El nombre es: "
* Paso 2:
*   .Cuidado con el manejo de strings en java, se manejan de forma diferente a otros lenguajes los operadores de igualdad (==) e equals
*    es recomendable leerlos un poco para evitar tener sorpresas desagradables. La memoria heap y los strings es necesario conocerlos
*    La idea es que para comparar contenidos entre cadenas hay que usar el equals, no el operador de igualdad, salvo en algunas circunstancias
* Paso 3:
*   . Suponer un fichero existente "nombres2.txt" (crearlo de antemano) siempre para que funcione el codigo
*
*
* El concepto basicamente es
*
* Abrir fichero
* do
*   leer teclado y poner en nombre
*   si nombre no es "fin"
*       escribir fichero
*
* while no "fin"
* cerrar fichero
*
*
*
* */