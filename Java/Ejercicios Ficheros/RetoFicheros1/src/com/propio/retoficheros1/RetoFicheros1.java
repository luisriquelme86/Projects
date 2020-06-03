package com.propio.retoficheros1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
* Objetivo:
*
* Abrir un fichero de texto para lectura, y leerlo linea a linea
* Mostrar el nombre del fichero, el numero de lineas y el numero de caracteres
*
* Nota 1:
* El objetivo es abrir un fichero, asi que en este caso voy a tener creado un fichero de antemano con un texto cualquiera
*
* Nota 2:
* Ficheros o file. Buscar esto como java Files
* Basicamente tengo la api de Java llamada File y leyendo la documentacion deberia poder entender como realizar el ejercicio, aunque es bueno tener
* una idea general de cualquier archivo. Leyendo la api y sus metodos deberia poder actuar, mas alla de buscar un ejemplo en internet
*
*
* Cuales serian los pasos ?
* Conosco el nombre del fichero -> Se llama archivo-ejemplo.txt y esta en la carpeta del proyecto
* Es un archivo de texto, un .txt. Deberia poder leer facilmente cada una de las lineas
* En cada una de las lineas deberia poder contar los caracteres
*
* Pasos que recuerdo
* . Indicar el nombre de archivo
* . Abrirlo (a veces distinguen para lectura o escritura)
* . Leer el archivo
* . Cerrar el archivo
* Es la parte basica. Luego esta el manejo de excepciones por si el archivo no existe
* */

/*
 * Modo Java. La api de file no tiene forma de obtener los caracteres del archivo de por si. Necesito la api de Scanner
 * Con la api del scanner puedo obtener las lineas
 * Con Java en si no cierro el archivo, cierro el reader
* * */

public class RetoFicheros1 {

    public static void main(String[] args) {


        File file = new File("archivo-ejemplo.txt");
        int contadorDeLineas = 0;
        int contadorPalabras = 0;
        int contadorDeCaracteres = 0;
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                contadorDeLineas++;
                contadorPalabras += line.split(" ").length;
                contadorDeCaracteres += line.length();
                System.out.println(line);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
        finally {
            System.out.println("El nombre del archivo es " + file.getName());
            System.out.println("El archivo tiene " + contadorDeLineas + " lineas");
            System.out.println("El archivo tiene " + contadorPalabras + " palabras");
            System.out.println("El archivo tiene " + contadorDeCaracteres + " caracteres");
        }
    }
}
