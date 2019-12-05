package com.blogspot.programavideojuegos;


// Que rellene un array con los números primos comprendidos entre 1 y 100 y los muestre en pantalla en orden ascendente.

public class Reto3 {

    public static void main(String[] args) {

        int[] array = new int[100];
        int contador = 0;
        for (int numero = 1; numero <= 100; numero++) {
            if (esPrimo(numero)) {
                array[contador] = numero;
                contador++;
            }
        }

        for (int indice = 0; indice < contador; indice++) {
            System.out.print(array[indice] + "\n");
        }

    }

    public static boolean esPrimo(int numero) {
        int divisor = numero - 1;
        while (divisor > 1) {
            if (numero % divisor == 0) {
                break;
            }
            else {
                divisor = divisor - 1;
            }
        }
        return divisor < 2;
    }
}


/*
* . declaro array[100]
. desde indice 1 hasta 100
  	si indice es primo
  		escribir indice en array[indice]
. desde indice 1 hasta 100
	leer y mostrar array[indice]

. indice primo ? divisible SOLO por 1 y por si mismo. Si es divisible por otro, ya no es primo
  diagrama de flujo para apoyar ?

  . Leer indice
  . anterior <- indice - 1
  . mientras indice > 1
  	. si indice modulo anterior es 0
  		corta, no es primo
  	. si indice modulo anterior es no 0
  	    anterior <- anterior - 1
  . si indice = 1 entonces es primo
* */