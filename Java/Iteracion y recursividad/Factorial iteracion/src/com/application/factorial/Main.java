package com.application.factorial;

/*
 * Objetivo
 * Implementar una funcion que calcule el factorial de 6 (se usa 6 para no sobrecargar la memoria) pero iterativamente, no en forma recursiva como se acostumbra
 * a ejemplificar
 *
 */

public class Main {

    public static void main(String[] args) {
        int number = 6;
        System.out.println("El factorial de " + number + " comenzando de el mismo");
        getFactorialFromNumber(6);
        System.out.println("");
        System.out.println("El factorial de " + number + " comenzando de 1 hasta " + number);
        getFactorialToNumber(6);
        System.out.println("");
    }

    public static void getFactorialFromNumber(int number) {
        int result = number;
        for (int counter = number; counter > 2; counter --) {
            result = result * (counter - 1);
        }
        System.out.print(result);
    }

    // Similar al caso de arriba donde contador es mayor a 2 para que cierre la cuenta de adentro del ciclo
    // Aqui contador es menor al numero, solo para que cierre la cuenta del ciclo. Este razonamiento no se ve mientras se hace en papel
    // ni el pseudocodigo, se razona aqui mismo luego de ver q no anda o con la experiencia
    public static void getFactorialToNumber(int number) {
        int result = 1;
        for (int contador = 1; contador < number; contador++) {
            result = result * (contador + 1);
        }
        System.out.print(result);
    }
}

/*
 * Como lo pense:
 *
 * Recordando que un factorial es el numero por todos los naturales anteriores, entonces ->
 * 5! = 5.4! o mejor aun 5! = 5.4.3.2.1
 * Antes de hacer nada, incluso pseudocodigo, deberia tomar lapiz y papel y pensar en como resolver esto en simples pasos, luego en pseudocodigo y luego
 * a lenguaje de alto nivel
 *
 * Podria ser asi: Dado un numero, por ejemplo 5, y siendo que 5! = 5*4*3*2*1
 * Tomo el numero dado, lo multiplico por el anterior y obtengo un resultado. Luego ese resultado lo multiplico por el anterior del anterior, y asi. Graficamente
 *
 * 5.4.3.2.1
 * 5*4 =20
 *   3x20=60
 *   2x60=120
 *   1x120=120
 *
 * A nivel pseudocodigo
 *
 * Leer numero
 *   Multiplico ese numero por su anterior (numero -1)
 *   El resultado anterior lo reservo (guardar en variable)
 *   Al anterior le resto 1 de nuevo y multiplico por ese resultado (y lo asigno al nuevo resultado)
 * Repetir estos pasos hasta llegar a 1
 *
 * Este codigo aun necesita pulirse, es la idea principal, pero esta muy bien. Basicamente, un ciclo que comienze en donde esta el numero y a ese numero
 * le vaya restando 1 y multiplicando por el resultado. Debo separar un poco lo q esta dentro el ciclo, sino daria la impresion q siempre hago esto
 *      resultado = numero * numero - 1 * resultado y en verdad quiero
 *      resultado = resultado * numero -1
 *
 * Otra forma de hacerlo es comenzando a partir del numero 1. Este codigo lo escribi, pero lo razone en otro momento en una pagina
 *
 */