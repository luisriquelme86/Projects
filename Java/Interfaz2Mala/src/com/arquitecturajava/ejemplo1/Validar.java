package com.arquitecturajava.ejemplo1;

public class Validar {

    public static void main(String[] args) {

        Persona p = new Persona();
        p.setNombre("Luis");
        p.setCodigo(12345);

        Telefono telefono = new Telefono("apple");
        telefono.setCodigo(12345);
        telefono.setPatron("patron");

        Persona p1 = new Persona();
        p1.setNombre("Luis");
        p1.setPatron("patron1");

        System.out.print(telefono.validar(p) + "\n");
        System.out.print(telefono.validar(p1));

        // El gran problema que tiene esto es la extensibilidad. El metodo validar puede crecer infinitamente, suponiendo
        // que una persona se pueda validar por los ojos, por la voz, por el rostro, por la huella, aumentando el metodo
        // validar del telefono cada vez mas y mas, mas largo y dificil de entender. Es un tema de extensibilidad
        // El problema siempre es el mismo, dado un compartamiento este puede ir variando mas y mas, porque crece el
        // negocio o cambian o se amplian las especificaciones

    }
}
