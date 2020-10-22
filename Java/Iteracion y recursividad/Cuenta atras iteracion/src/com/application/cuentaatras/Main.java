package com.application.cuentaatras;

/*
 * Objetivo
 * Implementar una cuenta atras en forma iterativa, partiendo del numero 10 y mostrar esta cuenta atras por pantalla
 *
 */

public class Main {

    public static void main(String[] args) {
        countDown(10);
    }

    static int countDown(int num) {
        System.out.print(num + ", ");
        for (; num > 0;) {
            num--;
            System.out.print(num + ", ");
        }
        return num;
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