package com.application.java;

/*
 * Objetivo
 * Dado el siguiente array de 9 valores {54, 26, 93, 17, 77, 31, 44, 55, 20}, ordenarlo con el metodo de ordenamiento quicksort
 *
 */

public class Main {

    public static void main(String[] args) {

    /*  int[] array = new int[] {54, 26, 93, 17, 77, 31, 44, 55, 20};
        ordenamientoRapidoAuxiliar(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    // perfecto, no se toca
    public static void intercambio(int[] array, int pos1, int pos2) {
        int temporal = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temporal;
    }

    public static void ordenamientoRapidoAuxiliar(int[] array, int primero, int ultimo) {
        if (primero < ultimo) {
            int marcaIzq = primero + 1;
            int marcaDer = ultimo;
            int pivote = array[primero];
            while (marcaDer >= marcaIzq) {

                if (array[marcaIzq] < pivote) {
                    marcaIzq++;
                    continue;
                }
                if (array[marcaDer] > pivote) {
                    marcaDer--;
                    continue;
                }
                intercambio(array, marcaIzq, marcaDer);
                marcaIzq++;
                marcaDer--;
            }
            intercambio(array, primero, marcaDer);
            ordenamientoRapidoAuxiliar(array, primero, marcaDer - 1);
            ordenamientoRapidoAuxiliar(array, marcaDer + 1, ultimo);
        }
    */

        int[] array = new int[] {54, 26, 93, 17, 77, 31, 44, 55, 20};
        System.out.println("Array sin ordenar: ");
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + ", ");
        }
        quicksort(array, 0 , array.length - 1);
        System.out.println(" ");
        System.out.println("Array ordenado: ");
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + ", ");
        }
        System.out.println("");
    }

    public static void  quicksort(int[] array, int begin, int end) {
        // condicion de corte, nada que ver con el while
        if (begin < end) {
            int indexLeft = begin;
            int indexRight = end;
            while (indexLeft < indexRight) {
                if (array[indexLeft] < array[indexRight]) {
                    indexLeft++;
                }
                else {
                    swap(array, indexLeft, indexRight);
                    indexLeft++;
                    indexRight--;
                }
            }
            // notar que esto siempre se ejecuta, la condicion es para el while, no hay condicion para el quicksort
            int middle = (indexLeft + indexRight) / 2;
            quicksort(array, begin, indexRight - 1);
            quicksort(array, indexLeft + 1, end);
        }
    }

    public static void swap(int[] array, int begin, int end) {
        int temp = array[begin];
        array[begin] = array[end];
        array[end] = temp;
    }

}

/*
 * Error grave de concepto -> Ese size === 1 no se cumple jamas. No va a suceder porque el array siempre es el mismo, en ningun momento creo arrays mas chicos
 * no lo hice porque no se como es la idea de unirlos, si es return la funcion, si es void. La idea de marcas y pivote la aprendi y la pude escribir, pero me falta eso
 * de desarmar el array, solo paso posiciones donde ordenar... cual es mi funcion de corte?

 * Leccion: El array no cambia de size, ni tengo nuevos arrays, lo que hago es el mismo array tratarlo pero a partir de diferentes anchuras, cambiando el inicio y fin
 * de dicho array y considerando esos limites como un subarray. Ademas, hay un error conceptual grave. Si bien arranque poniendo la marca izquierda y la derecha, y podria solucionarse
 * cambiando los nombres a inicio y fin (que es lo que hize), el gran problema que tiene eso es que al poner la marca izquierda como inicio + 1, nunca permito que se considere
 * el array de 1 solo elemento, que es cuando el ciclo corta (se cumple para algunos ciclos segun como terminen marcaIzq y marcaDer, pero no siempre). El otro error grave que tuve es
 * considerar solo la primera recursion, cuando se separa en dos mitades y el pivote al medio, considere siempre el final del subarray restante como el largo del array principal o inicial.
 * Ademas, otro problema, es no recordar o saber bien que la recursion funciona como pila, cuando llega al punto de no poder hacer mas recursion,
 * vuelve al valor anterior y sigue, no al principio de la pila donde se quedo (asi funcionan las promesas y lo asincronico en cierta forma?)
 * Los errores conceptuales se solucionaron facil considerando el inicio, el fin, y pasando esos parametros.
 *
 * */


/*
    public static void ordenamientoRapidoAuxiliar(int[] array, int marcaIzq, int marcaDer) {
        if (array.length == 1) {
            // nada
        }
        else (marcaIzq >= marcaDer) {
            int pivote = array[0];
            while (marcaDer >= marcaIzq) {

                if (array[marcaIzq] < pivote) {
                    marcaIzq++;
                    continue;
                }
                if (array[marcaDer] > pivote) {
                    marcaDer--;
                    continue;
                }
                intercambio(array, marcaIzq, marcaDer);
                marcaIzq++;
                marcaDer--;
            }
            intercambio(array, 0, marcaDer);
            ordenamientoRapidoAuxiliar(array, 1, marcaDer - 1);
            ordenamientoRapidoAuxiliar(array, marcaDer + 1, array.length - 1);
        }

    }
*/

/*
 * Errores conceptuales: Cuando escribi esto, no recordaba como era el quicksort. Tenia nocion y recordaba las marcas de inicio y fin, el trato como subarray
 * (como cometi el error de arriba) pero olvide el pivote y me centre tanto en el ciclo que no razone que el mismo aunque no se ejecute sale y sigue llamando al
 * metodo recursivo de quicksort.
 * Lo importante es recordar como funciona realmente el metodo. Lo poco que recorde me llevo a esto. A considerar un indice en cada punta, y si quiero hacer un ordenamiento
 * ascendente, comparo el indice de la izquierda contra el de la derecha y me muevo en consecuencia o cambio. O sea, si el elemento del indice izquierdo es menor al de la derecha, avanzo
 * el de la izquierda hacia adelante y si el de la izquierda es mayor lo intercambio. La idea del quicksort es parecida, pero diferente. Debo COMPARAR AMBOS INDICES
 * CON RESPECTO A UN VALOR (PIVOTE) y no comparando un solo indice con respecto a otro
 * Y algo importantisimo que recordaba pero no tenia nocion del alcance que tenia. La sentencia continue. Recordar siempre la palabra "continue". Si bien la conocia, ahora tome consciencia de
 * la importancia. Es una manera de que cuando se ejecute algo dentro de un ciclo, ignore todo lo demas dentro de un ciclo a partir de su declaracion y el ciclo recomienze. Es importantisimo porque sin
 * esto, no es posible hacer quicksort. Porque? Porque si bien necesito mover ambos indices, necesito que se mueva uno a la vez por ciclo, y no ambos en cada ciclo. Esto ultimo no puede
 * suceder jamas
 * El problema es lograr un intercambio sin usar el continue. O sea, en el momento que los indices no se pueden mover mas que se haga el swap. El swap se ejecutaria siempre, y la idea es que se ejecute
 * en el caso que los otros dos if pasen de largo, y que se mueva de uno a la vez, uno fijo y el otro moviendose para hacer el swap cuando ambos "esten quietos"
 *
 * El ejemplo de abajo no cumple ninguna de las de arriba. El ciclo comienza, compara el indice de la izquierda con el de la derecha y se mueve solo el de la izquierda y el de la derecha
 * con swap. Ademas es un ciclo infinito porque el while aunque no se ejecute llama al quicksort (no hay condicion de corte)
 *
 * */

/*
*
* public static void  quicksort(int[] array, int begin, int end) {
        int subBegin = begin;
        int subEnd = end;
        while (begin < end) {
            if (array[begin] < array[end]) {
                begin++;
            }
            else {
                swap(array, begin, end);
                begin++;
                end--;
            }
        }
        int middle = (begin + end) / 2;
        if (subBegin <= middle - 1) {                       // intente poner una condicion de corte
            quicksort(array, subBegin, middle - 1);
        }
        if (subEnd >= middle) {                             // intente poner una condicion de corte
            quicksort(array, middle, subEnd);
        }
    }
* */
