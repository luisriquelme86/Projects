package com.application.quicksort;

/*
 * Objetivo
 * Dado el siguiente array de 9 valores {54, 26, 93, 17, 77, 31, 44, 55, 20}, ordenarlo con el metodo de ordenamiento quicksort
 *
 */

public class Main {

    public static void main(String[] args) {

        int[] array = {54, 26, 93, 17, 77, 31, 44, 55, 20}; // 9 valores
        System.out.println("Lista de numeros");
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + ", ");
        }
        System.out.println("\n" + "Se ordenara el array con el metodo quicksort");
        quicksort(array, 0 , array.length - 1);
        System.out.println("Array ordenado");
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + ", ");
        }
        System.out.println("");
    }

    public static void quicksort(int[] array, int begin, int end) {
        if (begin < end) {
            // elijo mi pivote como el primer elemento de la lista, no como el primer indice
            int pivot = array[begin];
            // mi indice izquierdo es uno mas del pivote
            int leftIndex = begin + 1;
            int rightIndex = end;
            // o sea, que el indice derecho sobre pase al izquierdo. La igualdad es porque muchas veces son iguales y yo necesito que el indice derecho haga una comprobacion mas
            // para sobrepasar el indice izquierdo
            // el izquierdo termina avanzando hasta encontrar el menor de todos los mayores y ahi se queda
            // el derecho termina avanzando y encuentra algo menor, entonces se cruzaron
            // Esto pasa asi porque el indice izquierdo al comenzar primero "llega antes" a un valor que el indice derecho y lo puede "igualar" antes
            while (rightIndex >= leftIndex) {
                if (array[leftIndex] < pivot) {
                    leftIndex++;
                    continue;
                }
                if (array[rightIndex] > pivot) {
                    rightIndex--;
                    continue;
                }
                int temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;
            }
            // termino, muevo el pivote a su posicion definitiva
            int temp = array[rightIndex];
            array[rightIndex] = pivot;
            array[begin] = temp;

            quicksort(array, begin, rightIndex - 1);
            quicksort(array, rightIndex + 1, end);
        }
    }
}

/*
 * Leccion: En general siempre pense que despues del swap era necesario mover los indices (incluso que habia que mover los indices dentro del swap, pero esta idea es la peor
 * el swap solo debe mover los elementos y no mover los indices. Debe cumplir solo su funcion). A mi ahora me parece una idea que no tiene mucho sentido. La idea de poner que el indice derecho debe
 * al menos sobrepasar o ser igual al izquierdo y forzar asi a entrar al while me parece mejor
 *
 * */