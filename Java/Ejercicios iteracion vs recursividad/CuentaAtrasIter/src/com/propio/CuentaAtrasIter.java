package com.propio;

public class CuentaAtrasIter {

    public static void main(String[] args) {

        int numero = 10;
        for (int contador = numero; contador > 0; contador--) {

            System.out.println(contador);

        }


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
 * */