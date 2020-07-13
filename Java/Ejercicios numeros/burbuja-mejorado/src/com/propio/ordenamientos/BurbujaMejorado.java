package com.propio.ordenamientos;
import java.util.Scanner;
/*
* Objetivo: hacer un burbuja mejorado
* */

public class BurbujaMejorado {

    public static void main(String[] args) {
        boolean done = false;
        do {
            mostrarMenu();
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1: burbujaComun();
                        break;
                case 2: burbujaMejorado();
                    break;
                case 3: done = true;
                    break;
                default: System.out.println("Opcion incorrecta...");
                    break;
            }
        } while (!done);
    }

    private static void mostrarMenu() {
        System.out.println("Elija una opcion");
        System.out.println("1. Array burbuja");
        System.out.println("2. Array burbuja mejorado");
        System.out.println("3. Salir");
    }

    private static void burbujaComun() {
        System.out.println("Metodo de la burbuja comun, se ordena de menor a mayor. Totalmente desordenado");
        int[] numbers = {100, 90, 80, 70, 60};
        for (int index = 0; index < numbers.length; index++) {
            System.out.print(numbers[index] + ", ");
        }
        for (int outerIndex = 0; outerIndex < numbers.length; outerIndex++) {
            for (int innerIndex = 0; innerIndex < numbers.length - outerIndex - 1; innerIndex++) {
                if (numbers[innerIndex] > numbers[innerIndex + 1]) {
                    int aux = numbers[innerIndex];
                    numbers[innerIndex] = numbers[innerIndex + 1];
                    numbers[innerIndex + 1] = aux;
                }
            }
        }
        System.out.println("Mostrando el array ordenado");
        for (int index = 0; index < numbers.length; index++) {
            System.out.print(numbers[index] + ", ");
        }
        System.out.println("");
    }

    private static void burbujaMejorado() {
        System.out.println("Metodo de la burbuja mejorado, se ordena de menor a mayor. Casi nada desordenado");
        int[] numbers = {100, 60, 70, 80, 90};
        for (int index = 0; index < numbers.length; index++) {
            System.out.print(numbers[index] + ", ");
        }
        boolean beenSwaps;
        int innerSize = numbers.length;
        for (int outerIndex = 0; outerIndex < numbers.length; outerIndex++) {
            beenSwaps = false;
            for (int innerIndex = 0; innerIndex < numbers.length - outerIndex - 1; innerIndex++) {
                if (numbers[innerIndex] > numbers[innerIndex + 1]) {
                    int aux = numbers[innerIndex];
                    numbers[innerIndex] = numbers[innerIndex + 1];
                    numbers[innerIndex + 1] = aux;
                    beenSwaps = true;
                }
                innerSize = numbers.length - outerIndex;
            }
            if (!beenSwaps) {
                System.out.println("No ha habido intercambio en una de las pasadas, un subarray del array principal ya esta ordenado, saliendo...");
                System.out.println("El tamaño del subarray que ya esta ordenado es el longitud " + innerSize);
                break;
            }
        }
        System.out.println("Mostrando el array ordenado");
        for (int index = 0; index < numbers.length; index++) {
            System.out.print(numbers[index] + ", ");
        }
        System.out.println("");
    }
}


/*
* Teoria:
* . Suponiendo ordenamiento de menor a mayor
* . Es un poco mas facil recordarlo de esta manera. Se tiene un ciclo exterior y un ciclo interior. Si solo existiera el ciclo exterior, en una sola pasada
*   quedaria el mayor de todos al final. Y ahi termina todo. El ciclo interior se encarga de justamente repetir ese proceso un determinado numero de veces, pero de vuelta
* . El ciclo interior se puede pensar, ademas, que realiza una tarea determinada, que a medida que pase el tiempo sobre un objeto cada vez menor, no mayor. Es decir, el ciclo
*   interior repite una tarea (la del ciclo exterior) pero sobre cada vez menos elementos. En este caso, la porcion de array, o mejor dicho, de subarray que va recorriendo es
*   cada vez mas chica hasta que llega un punto minimo donde termina y se supone el array ordenado
*
* La parte de la mejora:
* . La parte de la mejora es que deberia cortar en el momento que se encuentra con una parte que ya esta ordenada. Una buena forma de saberlo es que si
*   al momento de ordenar un subarray, no se hizo ningun swap o intercambio, es porque ese subarray esta ordenado y ya se puede cortar el ciclo
*
* Ejemplos
* . Una buena forma de verlo es con los dos ejemplos. Uno un caso totalmente desordenado y otro donde con un sola pasada esta ordenada y desestima las pasadas
*   por eso (el metodo de burbuja tradicional recorre todo siempre, independientemente si esta ordenado o no todo el array)
*   Incluso, si el array esta ya ordenado, el metodo comun haria todo. El mejorado al detectar que nunca existio un swap dejaria de ejecutarse automaticamente
*
* . Como ultimo detalle que aprendi al hacer este ejercicio, hay que "reiniciar" el boolean de swap cada vez que comienza el ciclo de afuera. Porque?
*   Porque se supone que el ciclo de afuera es que el arranca el ciclo de adentro, donde suponemos que el subarray estara ordenado (noSwaps) y solo
*   cambiara cuando hay un swap, en ese momento sale
* */