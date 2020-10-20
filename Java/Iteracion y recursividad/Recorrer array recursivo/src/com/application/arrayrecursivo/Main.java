package com.application.arrayrecursivo;

/*
 * Objetivo
 * Recorrer recursivamente un array de 10 numeros
 * Implementar dos funciones, una que recorra el array descendentemente y otra ascendentemente
 *
 */

public class Main {

    public static void main(String[] args) {

        int[] array = new int[] {0, 1, 2, 3, 4, 6, 7, 8, 9, 10};

        System.out.println("Recorrido descendente de array en forma recursiva: ");
        goThroughDesc(array, array.length - 1);
        System.out.println("\n" + " Recorrido ascendente de array en forma recursiva: ");
        goThroughAsc(array, 0, array.length - 1);
        System.out.println("");
    }

    public static void goThroughDesc(int[] array, int index) {

        if (index >= 0) {
            System.out.print(array[index] + ", ");
            goThroughDesc(array, index - 1);
        }
    }

    public static void goThroughAsc(int[] array, int begin, int end) {
        if (begin <= end) {
            System.out.print(array[begin] + ", ");
            goThroughAsc(array, begin + 1, end);
        }
    }
}


/*
 * El gran secreto en recursividad es arrancar con los dibujos
 * El caso inicialmente lo pense como un caso de iteracion (lamentablemente) en el sentido de
 *    Mostrar una posicion del array con un indice
 *    Restar ese indice
 *  Hasta que indice sea 0
 *
 *  Yendo mas alla, una vez hecho y pensado eso, al modo de funciones recursivas, el indice inicial en este caso es el largo del array
 *  Pero no me interesa o esta mal 'mantener vivo el indice' y operar sobre el, asi como estaria mal sobre cualquier variable. Se supone que cada
 *  llamada a la funcion recursiva tiene su propio ambito o scope, asi que no deberia pensar q dicha variable 'sigue viva' en una posterior llamada para operar
 *  en este caso el indice. Aqui yo pase el largo del array, y funciona como el indice, pero no hay que engañarse o sacar conclusiones equivocadas
 *
 *  Despues de resolver el ejercicio asi, se puede ver como claramente, la idea seria que, muestro el array partiendo de su ultimo indice, y luego, mas que mover el indice
 *  le digo a la llamada 'la proxima llamada es sobre este array pero tomando el indice anterior a este', o sea, un subarray del array mas grande
 *  Esto tiene una explicacion. Dado un array de n elementos, desde el indice 0 hasta el n, si considero el mismo array anterior comenzando desde el indice 0
 *  pero que vaya hasta a un indice menor a n y mayor a 0, tengo un "subarray" de ese array inicial (solo es una imagen mental, el array inicial nunca cambio,
 *  solo cambia sus "limites" para recorrerlo). Asi que se puede considerar que la funcion recursiva descendente lo unico que hace es mostrar el ultimo
 *  elemento de un "subarray" del principal, que esta dado por el principio del array principal y por un final dado por un indice menor al del array original.
 *  El proceso de mostrar el ultimo elemento de un subarray del principal, donde la posicion del ultimo elemento esta dada por el indice que se pasa en la funcion,
 *  se termina cuando el subarray es tan pequeño que coincide la primera y ultima posicion
 *  Basicamente, mostrame el ultimo elemento del array, tomando como indice de la posicion, el indice actual - 1
 *
 *  La llamada corta cuando el array 'llego a la primera posicion' aunque en realidad es 'cuando el subarray es tan pequeño que ya no tiene subarrays'
 *  No se evalua el caso de array vacio ni null, no es la idea del ejercicio
 *
 */

/*
 *  El caso de ascendente es un poco menos obvio pero se puede ver asi
 *  Un subarray donde se indica el inicio y el fin del mismo, y siempre se muestra el principio, hasta que el princioio y el fin del subarray coincidan, aunque inicialmente
 *  tambien lo pense como iteracion. El gran secreto en recursividad es arrancar con los dibujos. El subarray siempre tiene la misma posicion final que el array completo,
 *  asi que se mantiene hasta que terminen las llamadas, y el inicio de cada subarray es un poco mayor que el anterior, hasta que queda un subarray de misma posicion inicial y final
 *  o sea, un subarray de largo 1. Siempre se muestra el inicio de cada subarray, asi que se completa asi
 *
 */