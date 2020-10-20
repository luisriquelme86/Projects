package com.propio.agendav2;

public class Agenda {
    private Person[] persons;
    private int numberOfPersons = 0;

    public Agenda() {
        this.persons = new Person[100]; // reservo lugar para 100 personas
    }

    public void addPerson(String name, int phone) {
        Person newPerson = new Person(name, phone);
        this.persons[numberOfPersons] = newPerson;
        this.numberOfPersons++;
    }

    public void searchPerson(String name) {
        // su unica tarea es mostrar las personas. Se podrian devolver, pero no tienen mucho sentido devolverlas para volver a recorrerlas y luego hacer un print
        // al menos en este ejercicio
        // los nombres no se guardan ordenados
        if (this.numberOfPersons == 0) {
            System.out.println("No hay personas en la agenda");
            return;
        }
        int index = 0;
        boolean foundPerson = false;
        while (index < this.numberOfPersons) {
            if (this.persons[index].getName().equals(name)) {
                System.out.println("Datos de la persona encontrada: ");
                System.out.println("Nombre: " + this.persons[index].getName() + " y telefono: " + this.persons[index].getPhone());
                foundPerson = true;
            }
            index++;
        }
        if (!foundPerson) {
            System.out.println("No se encontro ningun persona con el nombre de " + name);
        }
    }

    public void showPersons() {
        if (this.numberOfPersons == 0) {
            System.out.println("No hay personas en la agenda");
            return;
        }
        for (int index = 0; index < numberOfPersons; index++) {
            System.out.println("Nombre: " + this.persons[index].getName() + " telefono: " + this.persons[index].getPhone());
        }
    }
}

/*
* Este es el metodo original que pense para mostrar las personas de 1. Tiene el problema de que si quiero mostrar varias no puede
* No es dificil, pero inicialmente arranque por esto. Sin complicarse mucho, es mejor hacer un metodo que muestre con un mensaje y no que devuelva
* No es el objetivo de este ejercicio, sino separar en clases, guardar en un array y hacer cosas basicas de interaccion con el usuario
*
* public void searchPerson(String name) {
        // su unica tarea es devolver la persona
        // los nombres no se guardan ordenados
        // una mejora seria devolver todas las personas que tengan ese nombre
        int index = 0;
        boolean foundPerson = false;
        while (index < this.numberOfPersons && !foundPerson) {
            if (this.persons[index].getName().equals(name)) {
                foundPerson = true;
            }
        }
        if (foundPerson) {
            System.out.println("Datos de la persona : ");
            System.out.println("Nombre: " + this.persons[index] + " y telefono: " + this.persons[index].getPhone());
        }
        else {
            System.out.println("Persona no encontrada");
        }
    }
*
*
* */