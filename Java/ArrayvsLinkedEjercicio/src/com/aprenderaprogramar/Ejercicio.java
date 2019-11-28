package com.aprenderaprogramar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ejercicio {

    public static void main(String[] args) {

        List<Vehiculo> listaArray = new ArrayList<Vehiculo>();
        List<Vehiculo> listaLinked = new LinkedList<Vehiculo>();

        List<String> tiposVehiculo = new ArrayList<String>();
        tiposVehiculo.add("Coche");
        tiposVehiculo.add("Camion");
        tiposVehiculo.add("Furgoneta");
        tiposVehiculo.add("Moto");


        // introducir 5000 vehiculos en cada lista
        // el tipo de vehiculo es aleatorio
        for(int index = 0; index < 5000; index++) {
            listaArray.add(new Vehiculo(index, getRandomElement(tiposVehiculo)));
            listaLinked.add(new Vehiculo(index, getRandomElement(tiposVehiculo)));
        }

        // resumen de vehiculos de cada tipo
        System.out.print("Arraylist ");
        showSummaryVehicule(listaArray);
        // remover vehiculos que no son tipo coche
        System.out.print("Removiendo elementos del array list " + "\n");
        long antes = System.nanoTime();
        int removedElementsArrayList = removeFromList("Coche", listaArray);
        // agregar tantos coches como no coches se borraron
        for(int index = 0; index < removedElementsArrayList; index++) {
            listaArray.add(new Vehiculo(5000 + index, "Coche"));
        }
        long tiempoEmpleado = + System.nanoTime() - antes;
        System.out.print("Tiempo empleado entre la eliminacion y la insercion del array list " + tiempoEmpleado + "\n");
        System.out.print("Arraylist ");
        showSummaryVehicule(listaArray);


        // resumen de vehiculos de cada tipo
        System.out.print("LinkedList ");
        showSummaryVehicule(listaLinked);
        // remover vehiculos que no son tipo coche
        System.out.print("Removiendo elementos del linked list");
        antes = System.nanoTime();
        int removedElementsLinkedList = removeFromList("Coche", listaLinked);
        // agregar tantos coches como no coches se borraron
        for(int index = 0; index < removedElementsLinkedList; index++) {
            listaLinked.add(new Vehiculo(5000 + index, "Coche"));
        }
        tiempoEmpleado = + System.nanoTime() - antes;
        System.out.print("Tiempo empleado entre la eliminacion y la insercion del linked list " + tiempoEmpleado + "\n");
        System.out.print("LinkedList ");
        showSummaryVehicule(listaLinked);
    }

    public static String getRandomElement(List<String> list) {
        int random = (int) (Math.random() * list.size());
        return list.get(random);
    }

    // que sea una interface lo hace comodo al pasarle a la funcion
    public static void showSummaryVehicule(List<Vehiculo> vehiculos) {
        int coches = 0;
        int camiones = 0;
        int furgonetas = 0;
        int motos = 0;
        for (Vehiculo vehiculo: vehiculos) {
            if (vehiculo.getTipo().equals("Coche")) {
                coches++;
            }
            if (vehiculo.getTipo().equals("Camion")) {
                camiones++;
            }
            if (vehiculo.getTipo().equals("Furgoneta")) {
                furgonetas++;
            }
            if (vehiculo.getTipo().equals("Moto")) {
                motos++;
            }
        }
        System.out.print("En esta lista hay " +
                            coches + " coches, " + camiones + " camiones " + furgonetas +" furgonetas y " + motos  + "  motos " + "\n");
    }

    public static int removeFromList(String tipo, List<Vehiculo> vehiculos) {
        // foreach queda descartado?? y for?
        // for each loop no adecuado si qwuiero modificar el array
        // for loop falla, borro y el tamaño no es el mismo
        /* int removed = 0;
        for (int index = 0; index < vehiculos.size(); index++) {
            if (!vehiculos.get(index).getTipo().equals(tipo)) {
                vehiculos.remove(index);
                removed++;
            }
        }
        return removed; */
        // un iterador es un objeto, tiene el metodo remove, permite remover al tiempo que recorre, en los otros casos lanza excepcion
        int removed = 0;
        Iterator itr = vehiculos.iterator();
        while (itr.hasNext()) {
            Vehiculo vehiculo = (Vehiculo)itr.next();
            if (!vehiculo.getTipo().equals(tipo)) {
                removed++;
                itr.remove();
            }
        }
        return removed;
    }
}
