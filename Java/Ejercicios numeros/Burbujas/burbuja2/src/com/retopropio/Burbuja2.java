package com.retopropio;

public class Burbuja2 {

    public static void main(String[] args) {
        // int[] array_numeros = {1, 2, 10, 9, 8, 7, 6, 5, 4, 3};
        int[] array_numeros = new int[6];
        for (int i = 0; i < array_numeros.length; i++) {
            array_numeros[i] = i + 1;
        }

        // int[] array_numeros = {1, 2, 5, 4, 3};
        // el array tiene los numeros ordenados de menor a mayor
        // ahora quiero ordenar de mayor a menor usando burbujeo
        // la ultima posicion es la posicion final menos 1, por la comparacion entre numero y su siguiente
        int array_burbuja_largo;
        int indice_burbuja = 0;
        int cantidad_ordenados = 0;
        int temporal = 0;
        boolean estan_ordenados = false;
        int indice = 0;
        // el < largo expresa el numero de veces reales que se hace la pasada, si tengo un largo de 6, se hacen 6 pasadas desde 0 hasta 5
        while (indice < array_numeros.length - 1 && !estan_ordenados) {
            array_burbuja_largo = array_numeros.length - 1 - cantidad_ordenados; // no puedo poner menos 2, xq el ultimo caso es de dos elementos, arranco de la posicion 0 para comparar con la 1
            estan_ordenados = true;
            while (indice_burbuja < array_burbuja_largo) {
                if (array_numeros[indice_burbuja] < array_numeros[indice_burbuja + 1]) {
                    temporal = array_numeros[indice_burbuja + 1]; // reservo el mayor
                    array_numeros[indice_burbuja + 1] = array_numeros[indice_burbuja]; // guardo el menor
                    array_numeros[indice_burbuja] = temporal; // guardo el mayor
                    estan_ordenados = false;
                }
                indice_burbuja++;
            }
            indice_burbuja = 0; // para un while interno hay que volver a poner esto en 0
            cantidad_ordenados = cantidad_ordenados + 1;
            indice++;
        }

        // para ver menos pasadas y si sale probar esto
        // int[] array_numeros = {1, 2, 10, 9, 8, 7, 6, 5, 4, 3};
        System.out.print("se hicieron " + indice + " pasadas" + "\n");

        System.out.print("Hubo " + indice + " pasadas" + "\n");
        for (int i = 0; i < array_numeros.length; i++) {
            System.out.print(array_numeros[i] + "\n");
        }

    }

    /*
    * En este caso como se que tiene que hacer menos pasadas? Armando un diagrama de flujo, se ve que el ciclo interior tiene que 'avisarle' al ciclo de afuera
    * que nunca entro al swap. Si no entra al swap, quiere decir que estan todos ordenados los numeros. Marco el swap como ordenado en falso si entro al swap
    * Si entro es porque no estan ordenados
    * Como le aviso al ciclo de afuera ? El ciclo de afuera cuando analiza la condicion debe comprobar que este flag. El ciclo comienza suponiendo
    * que no estan ordenados. Sin embargo, el ciclo interior presupone ese subarray ordenado y querra cortar la condicion a menos que se encuentre con lo contrario
    *
    * QUIERO CONSTRUIR UN EDIFICIO -> EMPIEZO A CONSTRUIRLO
    *
    * Lo cual implica, simplemente, comenzar una tarea sin la preparación necesaria. En el ejemplo del edificio sólo en situaciones de extrema sencillez
    * (por ejemplo levantar un cuarto) el resultado será satisfactorio. En el resto de los casos la falta de método llevará a defectos o colapsos debido a
    * la ausencia de proyecto, planos, cálculos, etc.
    *
    * */
}
