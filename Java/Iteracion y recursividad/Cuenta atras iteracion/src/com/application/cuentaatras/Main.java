package com.application.cuentaatras;

/*
 * Objetivo
 * Implementar una cuenta atras en forma iterativa, partiendo del numero 10 y mostrar esta cuenta atras por pantalla
 *
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Mostrando la cuenta atras, partiendo del numero 10: ");
        for (int counter = 10; counter > 0; counter--) {
            System.out.print(counter + ", ");
        }
        System.out.println("");
    }
}


/*
 * Cuenta atras con iteracion
 *
 * Basicamente algo del estilo
 *
 *  Leer numero
 *  Mostrar numero
 *  Restar 1 al numero
 *  Mostrar numero
 *  Restar 1 al numero
 *  .
 *  .
 *  .
 *  hasta que numero sea 0
 *
 *  Leer numero
 *  -
 *       Mostrar numero
 *       Restar 1 al numero
 *  Repetir hasta que numero sea 0
 *
 */