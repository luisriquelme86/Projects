package com.propio.retoficheros;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;
// import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;
/*
* - Objetivo:
* . Un programa que lea el contenido del fichero "nombres2.txt" (que puede estar desordenado) y lo vuelque, ordenado alfabéticamente,
*   al fichero "nombres4.txt". En una primera aproximación, supón que todos los datos cabrán en memoria y se podrán ordenar en memoria.
* */

public class RetoFicheros7 {

    public static void main(String[] args) {

        File file1 = new File("nombres2.txt");
        File file2 = new File("nombres4.txt");
        if (file2.exists()) {
            file2.delete();
            try {
                file2.createNewFile();
            }
            catch (IOException e) {
                System.out.println("An error was ocurred, nombres4.txt could not be created");
            }
        }

        // Need a collection in order to order data from nombres2.txt -> Most simply -> ArrayList
        ArrayList<String> names = new ArrayList<>();

        try {
            FileWriter fileWriter = new FileWriter(file2);
            try {
                Scanner scanner = new Scanner(file1);
                while (scanner.hasNextLine()) {
                   names.add(scanner.nextLine());
                }
                scanner.close();
                // Array list is filled with lines from nombres2.txt, now it will order
                Collections.sort(names);
            }
            catch (FileNotFoundException e) {
                System.out.println("File nombres2.txt not found");
            }
            // loop arraylist and write one by one in the file nombres4.txt
            for (String name: names) {
                fileWriter.write(name + "\n");
            }
            // close file writer
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println("An IOException has ocurred trying to write in nombres3.txt");
        }
    }
}

/*
* Pasos:
* El primer dilema es... si esta desordenado, como se ordena?
* 1. Se copia todo el archivo "nombres2.txt" a "nombres4.txt" y ese archivo se ordena alfabeticamente? Quizas, pero si se sigue el enunciado al pie de la letra
*    debe volcarse ya ordenado
* 2. Todo hace suponer que hay que ordenarlo en memoria alfabeticamente, y luego de eso, recien volcarlo
*
* Mas pasos:
* Como ordenar alfabeticamente?
* 1. Poner todos los datos en una estructura (cual?), ordenarlos alfabeticamente (como?) y una vez listo, recorrer esa estructura y volcarlo
*    en "nombres4.txt"
* 2. Opcion mas comun -> Un array de N elementos y ordenar por burbuja (muy ineficiente, de n*n, pero muy sencillo)
*
* Estructuras en Java -> De cuales dispongo? Como se arma un array? Investigar y buscar array list o como armar listas
* Mi idea era usar un array (a secas) en Java. Pero tiene un problema. El tamaño es fijo y debo indicarlo pero el tamaño no lo conozco de antemano
* el fichero es de texto, para saber cuantos registros hay tengo que recorrerlo todo (no es de acceso aleatorio el .txt). No es como en javascript que puedo hacer push
* Por lo tanto, solo me queda investigar los arraylist
* Como creo array list? Y como las recorro
*
* Primero que nada:
* Tengo esto
* Class ArrayList<E>
* Donde <E> es Type Parameters: E - the type of elements in this list
* Y asi como tengo Class Scanner y hago
* Scanner scanner = new Scanner(System.in)
* La misma logica sigo con Array List. Es un parametro diferente, que se pasa entre <>, no en los corchetes
* Usar para recorrer un ciclo mejorado for o enhancement for loop que sigue la sintaxis tipo, variable y que le asigno
* --------------------------------------------------------------------------------------------------------------------
* Y que pasa con el sort. En resumidas cuentas. La clase ArrayList es subclase de una clase muy por encima que es AbstractCollection y ArrayList
* implementa la interface List. Y ademas de todo, en el java.util (paquete) hay un framework (conjunto de herramientas) que tiene la clase Collections (si con "s")
* que tiene metodos estaticos y se pueden usar de alguna manera con las colecciones, como ArrayList
* El Collections.sort() ordena en el orden natural, asi que no hay problema. Pero es bueno ver de poner una clase comparador para hacer otro orden
* La clase Collections de java.util tiene algoritmos polimorficos que son aplicables a todo tipo de colecciones (Collection es una interfaz) y el de sort es uno de ellos
* Ademas, la interfaz de List en versiones pasadas la JDK 7 puede implementar el sort en sus implementaciones (en esta altura de codigo puedo hacerlo, pero no me interesa
* hacerlo asi).
* --------------------------------------------------------------------------------------------------------------------
* Acerca del ordenamiento por burbuja
* La idea inicialmente aplica si hay que hacer todo de cero. Sin embargo, dado que en general los lenguajes poseen librerias que hacen un ordenamiento
* eficiente, no tiene sentido. La funcion sort() existe en muchos lenguajes y permiten ordenar colecciones de primitivos facilmente o de objetos con algo mas de esfuerzo
* */
