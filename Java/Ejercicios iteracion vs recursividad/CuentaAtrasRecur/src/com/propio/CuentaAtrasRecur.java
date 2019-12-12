package com.propio;

public class CuentaAtrasRecur {

    public static void main(String[] args) {

        System.out.println("Caso contar: ");
        int numero = 10;
        contar(10);
        System.out.println("Caso contar otra forma: ");
        contarOtraForma(10);

    }

    // primero funcion que pense, la mas basica. No corta ciclo aun... hasta que le puse un return
    public static void contar(int numero) {
        System.out.println(numero);
        // necesita return; Como para decir 'corto ?
        // tranquilamente puedo poner una condicion en la que esto no continue mas
        if (numero == 1) {
            return;
        }
        contar(numero - 1);
    }

    public static void contarOtraForma(int numero) {
        if (numero > 0) {
            System.out.println(numero);
            contarOtraForma(numero - 1);
        }
    }
}


/*
* A diferencia de la iteracion que repite un mismo numero de instrucciones, la recursividad llama al mismo bloque de instrucciones
* (exactamente el mismo) hasta que algo hace terminar esas llamadas encadenadas
*
*  la cuenta regresiva puede pensarse como
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
* */