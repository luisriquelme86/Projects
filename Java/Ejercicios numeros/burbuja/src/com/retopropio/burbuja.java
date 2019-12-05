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


/* No es la manera que se ve en las guias pero al menos la pense yo primero en pseudocodigo o lenguaje hablado y luego en
 * algo mas parecido a codigo de programacion
 * Tengo un array de pe 6 numeros. Si ordeno de mayor a menor, los mas ligeros o los mas chicos se mueven al final
 * En una primera pasada, basica, suponemos 2, 3, 20, 50, 80.
 * Si a un inicio leo A, leo B, donde A es un numero y B su siguiente, y al ser A<B lo intercambio. Si repito este ciclo mientras B no sea el ultimo numero, y actualizo A y B con a = a+1 y b= a+1
 * resulta que obtengo esto  3, 20, 50, 80, 2.
 * Ahora, este ciclo deberia repetirlo otra vez? Cuantas veces? La idea de N ciclos esta mal aunque se peude ocurrir. la clave para notarlo fue en el diagrama de flujo, al inicio
 * recordando que el primer ciclo se mantiene si B (o siguiente al numero que pruebo menor) es menor al ultimo numero del array
 * Entonces puedo dibujar otro ciclo que en verdad le pase el ultimo numero o posicion. Este ultimo numero va variando, debe ser cada vez mas chico porque cada vez mas numeros
 * quedan del otro del array ordenados.
 *
 * Si tengo 3, 20, 50, 80, 2 -> puedo notar que 3, 20, 50, 80 es un subgrupo y el 2 ya seria el menor de todos al final (recordar que quiero ordenar de mayor a menor)
 * Entonces, ese ultimo numero para que no se pase el largo del array - 1 (porq comparo siempre con proximos) menos los que ya ordene
 *
 * el superior realiza n-1 pasadas (porq quiero setear n-1 veces ese valor ultimo del ciclo interior). La clave e spreguntarse cuantas veces le paso ese 'ultimo' valor o posicion
 * para que el array interior conozca hasta donde hacer swap?
 *
 * Ayudarse con dibujos, por ejemplo, de un array donde el mas chico de todos ya quedo al final en la primera pasada, y debo reordenar solo un subgrupo que no incluya a ese
 *
 */
