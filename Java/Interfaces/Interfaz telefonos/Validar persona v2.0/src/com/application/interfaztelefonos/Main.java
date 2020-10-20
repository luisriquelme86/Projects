package com.application.interfaztelefonos;

/*
 * Objetivos
 * Siguiendo la anterior version de la validacion del telefono, crear una aplicacion que valide una persona contra un telefono. Con la diferencia que ahora validara por codigo,
 * patron, huella y rostro. Armar la aplicacion de modo que sea extensible a mas validaciones
 *
 * */

public class Main {

    public static void main(String[] args) {

        // Nota: En un proximo refactor considera la herencia de los telefonos, puede ser muy util. Algo asi como todos los telefonos de
        // la 3 generacion, son de la 2, son de la 1, y asi, y hacer super

        // Primera persona
        Persona persona1 = new Persona("Luis");
        persona1.setCodigo(12345);

        // Segunda persona
        Persona persona2 = new Persona("Micaela");
        persona2.setPatron("PatronMicaela");

        // Tercera persona
        Persona persona3 = new Persona("Belen");
        persona3.setHuella("HuellaBelen");

        // Cuarta persona
        Persona persona4 = new Persona("Alberto");
        persona4.setHuella("RostroAlberto");

        // Telefono con codigo
        Android s3 = new Android("S3");
        s3.setCodigo(12345);

        // Telefono con patron
        Android s5 = new Android("S5");
        s5.setPatron("PatronMicaela");

        // Telefono con huella
        IPhone8 iPhone8 = new IPhone8("IPhone8");
        iPhone8.setHuella("HuellaBelen");

        // Telefono con rostro
        IPhone10 iPhone10 = new IPhone10("IPhone10");
        iPhone10.setRostro("RostroAlberto");

        // Comienzan las pruebas
        System.out.println("La persona " + persona1.getNombre() + " y su validacion fue " + s3.validar(persona1));
        System.out.println("La persona " + persona2.getNombre() + " y su validacion fue " + s5.validar(persona2));
        System.out.println("La persona " + persona3.getNombre() + " y su validacion fue " + iPhone8.validar(persona3));
        System.out.println("La persona " + persona4.getNombre() + " y su validacion fue " + iPhone10.validar(persona4));


        // Cambio los datos
        System.out.println("Cambio los datos... ");
        persona1.setCodigo(1);
        persona2.setPatron("Patron");
        persona3.setHuella("Huella");
        persona4.setHuella("Rostro");

        // Ahora las pruebas negativas
        System.out.println("La persona " + persona1.getNombre() + " y su validacion fue " + s3.validar(persona1));
        System.out.println("La persona " + persona2.getNombre() + " y su validacion fue " + s5.validar(persona2));
        System.out.println("La persona " + persona3.getNombre() + " y su validacion fue " + iPhone8.validar(persona3));
        System.out.println("La persona " + persona4.getNombre() + " y su validacion fue " + iPhone10.validar(persona4));
    }
}
