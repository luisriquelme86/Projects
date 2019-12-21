package com.propio.quick;

public class OrdenamientoRapido {


    public static void main(String[] args) {

        int[] array = new int[] {54, 26, 93, 17, 77, 31, 44, 55, 20};
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

    }

}

/*
error grave de concepto -> Ese size === 1 no se cumple jamas. No va a suceder el array siempre es el mismo, en ningun momento creo arrays mas chicos
no lo hice porq no se como es la idea de unirlos, si es return la funcion, si es void. La idea de marcas y pivote la aprendi y la pude escribir, pero me falta eso
de desarmar el array, solo paso posiciones donde ordernar... cual es mi funcion de corte?

Leccion: El array no cambia de size, ni tengo nuevos arrays, lo que hago es el mismo array tratarlo pero a partir de diferentes anchuras, cambiando el inicio y fin
de dicho array y considerando esos limites como un subarray. Ademas, hay un error conceptual grave. Si bien arranque poniendo la marca izquierda y la derecha, y podria solucionarse
cambiando los nombres a inicio y fin (que es lo que hize), el gran problema que tiene eso es que al poner la marca izquierda como inicio + 1, nunca permito que se considere
el array de 1 solo elemento, que es cuando el ciclo corta (se cumple para algunos ciclos segun como terminen marcaIzq y marcaDer, pero no siempre). El otro error grave que tuve es considerar
solo la primera recursion, cuando se separa en dos mitadas y el pivote al medio, considere siempre el final del subarray restante como el largo del array principal o inicial.
Ademas, otro problema, es no recordar o saber bien que la recursion funciona como pila, cuando llega al punto de no poder hacer mas recursion,
vuelve al valor anterior y sigue, no al principio de la pila donde se quedo (asi funcionan las promesas y lo asincronico en cierta forma?)
Los errores conceptuales se solucionaron facil considerando el inicio, el fin, y pasando esos parametros.
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

    }*/