package com.propio.arrayscomunes;

/*
* - Objetivo:
* . Suponiendo un array de 10 posiciones con nombres, remover un nombre del array y al hacerlo, desplazar los restantes a la izquierda
*
* - Pistas
. Rellenar un array de 10 posiciones con nombres (automatico, no interactivo)
*
* */

public class PruebaRemover {

    public static void main(String[] args) {

        // array de nombres de 10 posiciones
        String[] nombres = {
                "luis",
                "juan",
                "pedro",
                "diego",
                "pablo",
                "lucas",
                "nicolas",
                "andres",
                "german",
                "guille",
        };

        System.out.println("================ ARRAY DE NOMBRES ================");

        for (int index = 0; index < nombres.length; index++) {
            System.out.println("Nombre: " + nombres[index]);
        }

        System.out.println("================ ARRAY DE NOMBRES ================");

        // removamos alguno

        // se me ocurre pensando en papel
        // creo otro array de posiciciones array anterior -1
        // recorro el viejo y la posicion que quiero eliminar "la salto" y sigo de largo posicionando
        // No desplazo nada en si, solo me muevo de array

        // otra opcion. Arranco de la posicion indicada y copia a partir de ahi en cada posicion la anterior. la ultima la marco como null
        // que pasa ahi? Sigue teniendo 10 y la ultima null, o pasa a 9?
        int removeIndex = 5;

        System.out.println("================ VOY A REMOVER A  ================ " + nombres[removeIndex]);
        for ( ; removeIndex < nombres.length - 1 ; removeIndex++) {
            nombres[removeIndex] = nombres[removeIndex + 1];
        }
        nombres[nombres.length - 1] = null;

        for (int index = 0; index < nombres.length - 1; index++) {
            System.out.println("Nombre: " + nombres[index]);
        }

        // La opcion que elegi al final concordando con los ejemplos de internet es la ultima, a partir de la posicion a remover
        // modifico y "desplazo" a la izquierda. Lamentablemente el lenght de un array en java (y quizas en otros lenguajes) es inmutable
        // una vez creado un array de 10 posiciones siempre tendra 10 posiciones. Una alternativa es usar una variable size para mantener el tamaño del array y
        // asi no pasarse, y no hace falta poner en null la parte no usada. En el caso de una agenda, el array es de por ejemplo 100 posiciones pero se conoce el numero
        // de personas ingresadas y se puede jugar con eso
    }
}

/*
 * Preguntas y consideraciones
 * Partimos de un array de 10 posiciones de nombres, todas llenas. Remuevo algo de la posicion numero 2.
 * Suponiendo que trabajmos con arrays literales, y no con ArrayList que se puede hacer add y remover y que si algo se remueve da igual porque la proxima posicion
 * es nula (da igual, porque no es fija) como se procede?
 * Si de un array fijo de 10 posiciones, borro la posicion 2, desplazo todo a la izquierda, que sucede con la ultima posicion, la 9? Queda en null, pero no estaria mal?
 * Despues si se recorre y se quiere mostrar el contenido despareceria?
 * Cual es la opcion?
 * Pasar el array a otro de la misma cantidad de posiciones?
 * Primero lo primero hacer el remove y el desplazamiento de la mejor manera posible
 *
 * */
