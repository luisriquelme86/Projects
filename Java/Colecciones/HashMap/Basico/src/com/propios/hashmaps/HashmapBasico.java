package com.propios.hashmaps;

/*
* - Objetivo
* . Implementar un map con hashmap basico. Guardar los datos de una unica persona (nombre, telefono y direccion, sin interactivdad)
* . Notar que no hace falta que el telefono sea necesariamente un Integer
* . Mostrar el contenido de las dos formas basicas
*
* */

import java.util.HashMap;

public class HashmapBasico {

    public static void main(String[] args) {

        // Implementacion de mapa con HashMap
        HashMap<String, String> person = new HashMap<>();
        person.put("Nombre", "Luis");
        person.put("Direccion", "Calle Falsa 123");
        person.put("Telefono", "123456");

        System.out.println("Vamos a mostrar el contenido de la persona almacenado en el mapa, forma 1");
        System.out.println("Persona es \n" + person.toString().replace(",", "\n"));

        System.out.println("Vamos a mostrar el contenido de la persona almacenado en el mapa, forma 2, con un for each");
        for (HashMap.Entry<String, String> entry : person.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + " -> Valor: " + entry.getValue());
        }
    }

}

/*
* Lecciones aprendidas:
* El Hashmap realmente no GARANTIZA el orden, como se ve aqui, el orden de las claves puede ser cualquiera
* Los "entry" de un mapa se guardan en un Set llamado EntrySet. Los mapas no son "iterables" pero se puede hacer algo asi
* usando un for each (no forEach) sobre el entry set del map
* Para mostrar los entry de un mapa tambien se puede hacer un toString sobre el mismo
*
* */