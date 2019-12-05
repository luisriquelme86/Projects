package com.blogspot.puntocomnoesunlenguaje;


// Llenar un array con números aleatorios.


public class Reto6 {

    public static void main(String[] args) {


        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {

            array[i] = (int) Math.round(Math.random() * i);
            System.out.print(array[i] + "\n");

        }

    }


}


/*
* . Primero que nada. Cuantos numeros? A falta de definicion, en mi caso, numeros aleatorios entre 0 y 100
. Como obtener un numero ENTERO aleatorio? El paso es inmediato? En la mayoria de los lenguajes se puede obtener un numero aleatorio entre 0 y 0.9 periodico sin llegar al 1
  No se pueden obtener enteros directamente. Hay que hacer una operacion

. Dice llenar un array, tranquilamente puede estar vacio y a medida que avance el indice, multiplicar ese indice por el creador de aleatorios para obtener un numero aleatorio
  Nota: el array tendra aleatorios pero no seran entre 0 y 100 realmente, ya que el contador avanza de a 1. Solo para tener en cuenta

. La forma de obtenerlo varia segun el lenguaje, pero en general es asi, entre (0,1]. Redondear y en caso de java castear, o sea, convertir un primitivo en otro primitivo
* */