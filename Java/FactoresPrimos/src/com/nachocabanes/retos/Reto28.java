package com.nachocabanes.retos;

import java.util.Scanner;

/* El usuario introducirá un primer número entero positivo (de no más de 6 cifras) que indicará la cantidad de casos de prueba.
   Después seguirán varias líneas, cada una con un número entero positivo (de no más de 15 cifras). Para cada uno de esos casos de prueba, tu
   programa debe mostrar el número, un espacio en blanco, un signo de igualdad, otro espacio en blanco y los factores primos de ese número (repetidos si es el caso),
   cada uno de ellos con un espacio en blanco a continuación.
 */

/*
. Tomo un N y lo divido por el primo mas basico que es 2
. Si el resto es 0 -> N es el dividendo y repito // aqui hay un ciclo
. Si el resto no es 0 -> El divisor es el proximo primo y repito // otro ciclo?
. Si N es ya no es mas divisible en otros factores -> fin
* */

public class Reto28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        // validar que tenga a lo sumo 6 cifras
        while (entrada.length() > 7) {
            entrada = scanner.nextLine();
        }
        int casos = Integer.parseInt(entrada);
        for (int indice = 0; indice < casos; indice++) {

            entrada = scanner.nextLine();
            // validar que tenga a lo sumo 15 cifras
            while (entrada.length() > 16) {
                entrada = scanner.nextLine();
            }
            int numero = Integer.parseInt(entrada);
            int numero_inicial = numero;
            String factores_primos = "";
            int divisor = 2;
            // si el numero es 1, ya no tiene sentido seguir dividiendo, solo seria divisible por 1
            while (numero >= 2) {
                if (numero % divisor == 0) {
                    numero = numero / divisor;
                    factores_primos = factores_primos.concat(Integer.toString(divisor)) + " ";
                }
                else {
                    divisor = divisor + 1;
                }
            }
            System.out.print(numero_inicial + " = " + factores_primos + "\n");
        }
    }
}
