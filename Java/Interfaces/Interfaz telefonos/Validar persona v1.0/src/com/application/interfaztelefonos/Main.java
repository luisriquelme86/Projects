package com.application.interfaztelefonos;

/*
 * Objetivo
 * Crear una aplicacion que valide una persona contra un telefono. Inicialmente el telefono puede validarse con un codigo numerico
 * o con un patron
 *
 * Pistas
 * La relacion entre las clases no tiene porque ser muy estrecha necesariamente. Basta con que una use la otra
* */

public class Main {

    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.setNombre("Luis");
        persona.setCodigo(12345);

        Persona otraPersona = new Persona();
        otraPersona.setNombre("Pedro");
        otraPersona.setPatron("patron1");

        Telefono telefono = new Telefono("Apple");
        telefono.setCodigo(12345);
        telefono.setPatron("patron");

        System.out.println("Valido a " + persona.getNombre() + " contra el telefono ");
        System.out.println("La validacion de " + persona.getNombre() + " es " + telefono.validar(persona));

        System.out.println("");

        System.out.println("Valido a " + otraPersona.getNombre() + " contra el telefono ");
        System.out.println("La validacion de " + otraPersona.getNombre() + " es " + telefono.validar(otraPersona));

        System.out.println("");
    }
}


/*
 * Lecciones aprendidas
 * El gran problema que tiene esto es la extensibilidad. El metodo validar puede crecer infinitamente, suponiendo
 * que una persona se pueda validar usando los ojos, la voz, el rostro, la huella, aumentando el metodo
 * validar del telefono cada vez mas y mas, haciendolo cada vez mas largo y dificil de entender
 *
 * El problema siempre es el mismo, dado un compartamiento este puede ir variando mas y mas, porque crece el negocio o cambian o se amplian las especificaciones
 *
 */
