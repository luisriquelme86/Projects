package com.blogspot.programavideojuegos;

/* Que lea una cadena y la muestre al revés.
* */

import java.util.Arrays;
import java.util.Scanner;

public class Reto4 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String cadena = entrada.nextLine();
        int contador = 0;

        // asigno allocate memoria al array
        // type[] nombre = new type[size]
        char[] chars = new char[cadena.length()];

        for (int indice = cadena.length() -1 ; indice >= 0; indice--) {
            chars[contador] = cadena.charAt(indice);
            contador++;
            // System.out.print(cadena.charAt(indice)); incluso aqui es aceptable
        }
        System.out.print(new String(chars) + "\n");
    }
}

// chars.toString => aqui no esta 'definido' como se deberia convertir un array de chars a un string asi que muestra lo que puede,
// una representacion de numeros

/*
* . Primero que nada, importa como es una cadena segun el lenguaje? Es decir, influye en mi ejercicio, o el pseudocodigo es el mismo?
. Que es una cadena, un array de chars? O un string? Dependo del lenguaje?

. Leer cadena
. declarar nueva cadena
. desde final de la cadena hasta 0
	. leer caracter
	. escribir caracter en nueva cadena
. mostrar nueva cadena
* */

// En java: camino -> Converting String to character array: