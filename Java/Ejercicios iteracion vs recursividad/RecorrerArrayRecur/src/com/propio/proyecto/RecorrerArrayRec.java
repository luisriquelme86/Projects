package com.propio.proyecto;

public class RecorrerArrayRec {


    public static void main(String[] args) {

        int[] array = new int[] {1, 2, 3, 4, 6, 7, 8, 9, 10};

        recorrerArrayRecursivoDescendente(array, array.length - 1);
        recorrerArrayRecurAscendente(array, 0,array.length - 1);

    }
    // le dicen 'n' en el sentido de la posicion n, o lo mismo, el largo
    public static void recorrerArrayRecursivoDescendente(int[] array, int largo) {

        if (largo >= 0) {
            System.out.println(array[largo]);
            recorrerArrayRecursivoDescendente(array, largo - 1);
        }
    }

    public static void recorrerArrayRecurAscendente(int[] array, int inicio, int fin) {
        if (inicio <= fin) {
            System.out.println(array[inicio]);
            recorrerArrayRecurAscendente(array, inicio + 1, fin);
        }
    }
}

/*
* El gran secreto en recursividad es arrancar con los dibujos
* El caso inicialmente lo pense como un caso de iteracion (lamentablemente) en el sentido de
*    Mostrar una posicion del array con un indice
*    restar ese indice
*  hasta que indice sea 0
*
*  Yendo mas alla, una vez hecho y pensado eso, al modo de funciones recursivas, el indice en esta caso es el largo del array
*  Pero no me interesa o esta mal 'mantener vivo el indice' y operar sobre el, asi como estaria mal sobre cualquier variable. Se supone que cada
*  llamada al funcion recursiva tiene su propio ambito o scope, asi que no deberia pensar q dicha variable 'sigue viva' en una posterior llamada para operar
*  en este caso el indice. Aqui yo pase el largo del array, y funciona como el indice, pero no hay que engañarse o sacar conclusiones equivocadas
*
*  Despues de resolver el ejercicio asi, se puede ver como claramente, la idea seria que, muestro el array partiendo de su ultima posicion, y luego mas que mover el indice
*  le digo a la llamada 'la proxima llamada es sobre el largo del array que queda despues de leer esta posicion' o sea, sobre el largo actual - 1, o sea, un subarray
*  del array mas grande
*
*  La llamada corta cuando el array 'llego a la primera posicion' aunque en realidad es 'cuando el subarray es tan pequeño que ya no tiene subarrays'
*  No se evalua el caso de array vacio ni null, no es la idea del ejercicio.
*
* */

/*
*  El caso de ascendente es un poco menos obvio pero se puede ver asi
*  Un subarray donde se indica el inicio y el fin del mismo, y siempre se muestra el principio, hasta que el princioio y el fin del subarray coincidan, aunque inicialmente
*   tambien lo pense como iteracion. El gran secreto en recursividad es arrancar con los dibujos. El subarray siempre tiene la misma posicion final que el array completo,
*   asi que se mantiene hasta que terminen las llamadas, y el inicio de cada subarray es un poco mayor que el anterior, hasta que queda un subarray de misma posicion inicial y final
*   o sea, un subarray de largo 1. Siempre se muestra el inicio de cada subarray, asi que se completa asi
* */