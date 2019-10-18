package com.arquitecturajava.ejemplo1;

public class Principal {
    public static void main(String[] args) {

        Persona p1 = new Persona();
        p1.setNombre("Juan");
        p1.setPatronHuella("huella1");

        IPhone8 telefono = new IPhone8("apple", p1);
        telefono.setHuella("huella1");
        System.out.println(telefono.validar(p1));

        Persona p2 = new Persona();
        p2.setNombre("Gema");
        p2.setPatronHuella("huella2");
        System.out.println(telefono.validar(p2));
    }
}
