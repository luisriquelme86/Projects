package com.blogspot.puntocomnoesunlenguaje;

// 8. Calcular el mayor de tres números enteros en Java.

public class reto5 {

    public static void main(String[] args) {

    int num1 = 3;
    int num2 = 2;
    int num3 = 2;

    int max = num1;

    if (max < num2) {
        max = num2;
    }
    if (max < num3) {
        max = num3;
    }
    System.out.print("mas grande es " + max + "\n");

    }
}


/* 5. Calcular el mayor de tres números enteros

        . Declarar 3 numeros -> 5, 69, 83, num1, num2, num3
        . Agarro el primero, lo tacho
        . Escribo debajo
        . Comparo ese numero contra el siguiente
        . Si es mas grande el siguiente numero, tacho el numero escrito debajo y lo reemplazo por el siguiente
        . Repetir con toda la lista original

        . La logica en pseudocodigo y a nivel papel es impecable. Algo tan simple no podia realizarlo hasta que lo vi en papel de la forma mas facil, pensando en pasos
        como hacerlos en papel. Despues usando las estructuras de programacion lo logre convertir de algo abstracto a realidad
        . Ahora necesito los ciclos, la declaracion de variables, etc par llevar la idea a la realidad
        .

         */