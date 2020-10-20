package com.application.cuentaatras;

/*
 * Objetivo
 * Implementar una cuenta atras en forma recursiva, partiendo del numero 10 y mostrar esta cuenta atras por pantalla
 *
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Cuenta atras caso 1: ");
        countDownCase1(10);
        System.out.println("");
        System.out.println("Cuenta atras caso 2: ");
        countDownCase2(10);
        System.out.println("");
    }

    // primero funcion que pense, la mas basica. No corta ciclo aun... hasta que le puse un return
    public static void countDownCase1(int numero) {
        System.out.print(numero + ", ");
        // necesita return; Como para decir 'corto'?
        // tranquilamente puedo poner una condicion en la que esto no continue mas
        if (numero == 0) {
            return;
        }
        countDownCase1(numero - 1);
    }

    public static void countDownCase2(int numero) {
        if (numero >= 0) {
            System.out.print(numero + ", ");
            countDownCase2(numero - 1);
        }
    }
}


/*
 * A diferencia de la iteracion que repite un mismo numero de instrucciones, la recursividad llama al mismo bloque de instrucciones
 * (exactamente el mismo) hasta que algo hace terminar esas llamadas encadenadas
 *
 *  La cuenta regresiva puede pensarse como
 *
 *  Cuenta regresiva recibe n (es el proceso que esta basado en su propia definicion)
 *       Mostrar n
 *       Resta 1 a n
 *       Si n == 0 return (vuelve al punto donde fue llamado)
 *       Llamar a cuenta regresiva
 *
 * El return no es necesario, no hace falta que 'vuelva al punto donde se quedo' necesariamente. Es un mal aprendizaje derivado de aprender
 * solo recursividad con factorial. Podria no retornar nada, como el caso de otraforma, donde con un if > 0 basta y sobra
 *
 */