package com.aprenderaprogramar;

import java.util.Vector;

public class Programa {

    public static void main(String[] args) {


        Vector vector = new Vector<Persona>();
        int initialCapacity = vector.capacity();
        System.out.println("Al crear un vector si no si indica la capacidad, la misma es de " + initialCapacity);
        int index = 0;
        System.out.println("Vamos a ingresar 15 personas ");
        while (index < 15) {
            // nombre, idPersona, altura
            vector.add(new Persona("Persona" + index, index, index));
            index++;
        }
        int currentCapacity = vector.capacity();
        System.out.println("La capacidad anterior es " + initialCapacity + " y ahora es de " + currentCapacity);
        System.out.println("Vamos a cortar lo que sobra del array");
        vector.trimToSize();
        System.out.println("Luego de cortar la capacidad es " + vector.capacity());
        vector.ensureCapacity(50);
        System.out.println("Aseguro la capacidad del vector a " + vector.capacity());
    }
}

/*
* Informacion sobre vector
* . Es una implementacion de List, asi que es una coleccion. A diferencia del ArrayList esta estructura si es sincronizada
* . Es muy parecido a un array unidimensional
* . La principal diferencia con el array es que el primero tiene un tamaño fijo que no se puede modificar una vez creado, en cambio el vector
*   puede cambiar su tamaño dinamicamente en tiempo de ejecucion sin necesidad de instrucciones adicionales (en general el tamaño se duplica a menos que se indique lo contrario)
* . Los metodos mas conocidos son metodos para asegurar una capacidad y para cortar los restantes
* . Muchas veces se conocen de antemano los elementos que va a tener un array, pero a veces no. En este caso la clase Vector proporciona un camino para resolver
*   este problema
* . Como muchas colecciones, solo acepta Objetos, no primitivos, asi que en el caso de los int voy a tener que usar su wrapper
* */
