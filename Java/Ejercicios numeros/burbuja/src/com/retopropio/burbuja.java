package com.retopropio;

public class burbuja {
    public static void main(String[] args)
    {

        int[] array_numeros = new int[6];
        for (int i = 0; i < array_numeros.length; i++) {
            array_numeros[i] = i + 1;
        }

        // el array tiene los numeros ordenados de menor a mayor
        // ahora quiero ordenar de mayor a menor usando burbujeo

        // la ultima posicion es la posicion final menos 1, por la comparacion entre numero y su siguiente
        int array_burbuja_largo;
        int ordenados = 0;
        int temporal = 0;
        // el < largo expresa el numero de veces reales que se hace la pasada, si tengo un largo de 6, se hacen 6 pasadas desde 0 hasta 5
        for (int indice = 0; indice < array_numeros.length - 1; indice ++) {

            array_burbuja_largo = array_numeros.length - 1 - ordenados; // no puedo poner menos 2, xq el ultimo caso es de dos elementos, arranco de la posicion 0 para comparar con la 1

            for (int indice_burbuja = 0; indice_burbuja < array_burbuja_largo; indice_burbuja ++) {

                if (array_numeros[indice_burbuja] < array_numeros[indice_burbuja + 1]) {
                    temporal = array_numeros[indice_burbuja + 1]; // reservo el mayor
                    array_numeros[indice_burbuja + 1] = array_numeros[indice_burbuja]; // guardo el menor
                    array_numeros[indice_burbuja] = temporal; // guardo el mayor
                }
            }

            ordenados = ordenados + 1;

        }

        for (int i = 0; i < array_numeros.length; i++) {
            System.out.print(array_numeros[i] + "\n");
        }

    }
}
