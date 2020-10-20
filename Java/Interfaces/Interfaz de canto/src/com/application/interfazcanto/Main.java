package com.application.interfazcanto;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona();
        Canario canario = new Canario();
        // cantar(persona);
        System.out.println("");
        cantar(canario);
        System.out.println("");
    }

    public static void cantar(Cantante cantante) {
        cantante.cantar();
    }
}
