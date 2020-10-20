package com.aprenderaprogramar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Programa {

    public static void main(String[] args) {

        // TODO: IMPORT ES ALT + SHIFT + ENTER
        List<Persona> listaarray = new ArrayList<Persona>();
        List<Persona> listalinked = new LinkedList<Persona>();
        long antes;
        for (int index = 0; index < 50000; index++) {

            listaarray.add(new Persona(index, "Persona" + index, index));
            listalinked.add(new Persona(index, "Persona" + index, index));

        }

        System.out.print("Tiempo invertido en insertar una persona al inicio en un arraylist en nanosegundos: ");
        antes = System.nanoTime();
        listaarray.add(0, new Persona(50001, "Persona" + 50001, 50001));
        System.out.print(System.nanoTime() - antes + "\n");

        System.out.print("Tiempo invertido en insertar una persona al inicio en un linkedlist en nanosegundos: ");
        antes = System.nanoTime();
        listalinked.add(0, new Persona(50001, "Persona" + 50001, 50001));
        System.out.print(System.nanoTime() - antes + "\n");

        // la flecha sale del activo, del que utiliza

        System.out.print("Tiempo invertido en insertar una persona al medio en un arraylist en nanosegundos: ");
        antes = System.nanoTime();
        listaarray.add(5000, new Persona(50001, "Persona" + 10001, 50001));
        System.out.print(System.nanoTime() - antes + "\n");

        System.out.print("Tiempo invertido en insertar una persona al medio en un linkedlist en nanosegundos: ");
        antes = System.nanoTime();
        listalinked.add(5000, new Persona(50001, "Persona" + 50001, 50001));
        System.out.print(System.nanoTime() - antes + "\n");

        System.out.print("Tiempo invertido en insertar una persona al final en un arraylist en nanosegundos: ");
        antes = System.nanoTime();
        listaarray.add(new Persona(50001, "Persona" + 50001, 50001));
        System.out.print(System.nanoTime() - antes + "\n");

        System.out.print("Tiempo invertido en insertar una persona al final en un linkedlist en nanosegundos: ");
        antes = System.nanoTime();
        listalinked.add(new Persona(50001, "Persona" + 50001, 50001));
        System.out.print(System.nanoTime() - antes + "\n");

        // TODO: COROLARIO, en el arraylist hay que insertar y desplazar, en cambio en linked list solo tenes que enlazar con el primero
        // array list tiene acceso posicional y linked list no
        // lo mismo pasa para el borrado

    }
}
