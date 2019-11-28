package com.aprenderaprogramar;

import java.util.Vector;

public class Programa {

    public static void main(String[] args) {


        Vector vector = new Vector<Persona>();
        System.out.print("antes del while la capacidad del vector es " + vector.capacity() + "\n");

        int index = 0;
        while (index < 15) {
            vector.add(new Persona("Persona" + index, index, index));
            index++;
        }
        System.out.print("la capacidad del vector es " + vector.capacity() + "\n");
        vector.trimToSize();
        System.out.print("hago trim y la capacidad del vector es " + vector.capacity() + "\n");
        vector.ensureCapacity(50);
        System.out.print("aseguro la capacidad del vector a " + vector.capacity() + "\n");
    }
}
