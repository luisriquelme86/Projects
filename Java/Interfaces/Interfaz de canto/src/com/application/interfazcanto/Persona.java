package com.application.interfazcanto;

/*
 * Objetivo
 * Suponiendo los siguientes como parte del proyecto: Persona, Canario, y Cantante, buscar la forma de relacionarlos,
 * que de alguna manera esten interconectados. Instanciar las clases que sean necesarias y que puedan realizar la accion de "cantar"
 *
 * La accion de cantar es simplemente imprimir un mensaje por pantalla
 */

public class Persona implements Cantante {

    @Override
    public void cantar() {
        System.out.println("Soy una persona y estoy cantando");
        System.out.println("La laa la raa laaa!");
    }
}
