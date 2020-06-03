package com.propio.ficheros;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
/*
* - Objetivo:
. Un programa que te pida tres nombres y los vuelque a un fichero de texto llamado "nombres.txt".
* */

public class RetoFicheros2 {

    public static void main(String[] args) {

        // String nombre1 = "Luis";
        // String nombre2= "Juan";
        // String nombre3 = "Diego";

        Scanner scanner = new Scanner(System.in);
        String nombre1 = scanner.next();
        String nombre2 = scanner.next();
        String nombre3 = scanner.next();

        System.out.println("El nombre 1 es " + nombre1);
        System.out.println("El nombre 2 es " + nombre2);
        System.out.println("El nombre 3 es " + nombre3);

        File file = new File("nombres.txt");
        boolean fileAlreadyExists = file.exists();
        if (fileAlreadyExists) {
            file.delete();
        }
        try {
            boolean successfullyFileCreation = file.createNewFile();
            if (successfullyFileCreation) {
                System.out.println("El archivo se creo ");
                // Tengo un archivo creado y listo para operar (abierto?)
                // Scanner scanner = new Scanner(file);
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(nombre1 + "\n");
                fileWriter.write(nombre2 + "\n");
                fileWriter.write(nombre3 + "\n");
                fileWriter.close();
            }
            else {
                System.out.println("El archivo no se creo ");
            }
        }
        catch (IOException e) {
            System.out.println("IOExpection");
        }
        finally {
            // System.out.println("El archivo no se creo ");
        }
    }
}


/*
* - Pasos:
*
* . Pedir 3 nombres
* . Inicialmente el archivo no existe, asi que lo creamos
* . Guardamos los 3 (algo en especial? separados por espacio, comas, uno por linea ?)
* . Cerramos el archivo?
* --------------------------------------------------------------------------------------
* . Tengo muchas dudas, arranco por aproximaciones. Inicio con 3 nombres por variable
* . Consulto api de file
* . Creo una instancia y hago un createNewFile
* . La clase Scanner es para leer. Yo quiero poner mis nombres dentro. Como lo logro? Ccomo hago un "write" en un archivo
* . Busco una api writer en java
* . Resulta que es una clase abstracta. No puedo instanciar nada, pero... Si miro en la seccion de mirar tambien veo un fileWriter, ahi se peude ver algo
* . Leyendo la documentacion, te enteras que la clase FileWriter escribe streams de caracteres. Para los bytes hay que usar FileOutputStream, cual uso?
*   No es muy claro. Por una parte el archivo es un txt puro, no otra terminacion como .dat. habra que probar...
* . Despues de todo, por ahora voy a borrar el archivo cada vez que se ejecute...
* . Inicialmente metio los nombres todos juntos. Salio al primer intento. Me gustaria que sea uno por linea o separados al menos
* . Con un \n s soluciono. Quizas en otro momento hay una forma mas elegante
* . Y si ejecuto esto mas veces y ya esta creado?
* . Lo pude solucionar con algunos metodos
* . Ahora la parte final. Que sean 3 ingresados por teclado. Que el programa pida 3 nombres por teclado
* */