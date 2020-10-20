package com.propio.arrays;

/*
*
* - Objetivo:
* . Suponiendo un array de 50 posiciones con nombres, añadir un nombre, pero ni al principio ni al final, y desplazar los restantes a la derecha
* . Esta es una prueba para la agenda, donde se debe mantener el array de nombres "siempre" ordenado. La idea es que al agregar un nuevo nombre, el array de nombres quede ordenado
*   como lo estaba previament
* - Pistas
* . Rellenar un array de 50 posiciones con 10 nombres (automatico, no interactivo) en orden alfabetico
*
* */

public class EjercicioArray {
    // TODO: mejorar en una subsiguiente version con una clase por esto de los privimitivos del numbers of persons
    public static void main(String[] args) {
        // cuidado este personNumber se pasa a la funciones como valor, no como referencia. Nunca va a cambiar su valor dentro de las funciones
        // de add que ponga. O lo hago a mano o creo una clase que se encargue de esto, pasando el numero. Es la unica solucion, una clase que maneje todo
        // o tambien poner como static
        int personsNumber = 10;
        // se supone ya ordenado para el ejercicio de añadir siempre ordenando

        String[] persons = new String[50];
        persons[0] = "ana";
        persons[1] = "beto";
        persons[2] = "casimiro";
        persons[3] = "dario";
        persons[4] = "pablo";
        persons[5] = "pedro";
        persons[6] = "susana";
        persons[7] = "tadeo";
        persons[8] = "ximena";
        persons[9] = "xuxa";
        System.out.println("El array inicial es: ");
        for (int index = 0; index < personsNumber; index++) {
            System.out.print(persons[index] + ", ");
        }
        System.out.println(" ");
        System.out.println("El numero de personas antes del add es: " + personsNumber);
        // si agrego person, deberia pasar un "person" y no un name para mayor claridad en el loop de add person, no es como agenda
        addPerson(persons, personsNumber, "luis");
        personsNumber = 11;
        System.out.println("El numero de personas antes del add es: " + personsNumber);
        // addPerson(persons, personsNumber, "luis");
        addPerson(persons, personsNumber, "luisa");
        // que pasa si agrego una persona que solo puede ser la ultima (como Zacarias)? Se rompe?
        personsNumber = 12;
        System.out.println("El numero de personas antes del add es: " + personsNumber);
        addPerson(persons, personsNumber, "zacarias");
    }

    // el compare es sencillo, solo no hay que confundir la condicion de corte con la de continuacion

    public static void addPerson(String[] persons, int personsNumber, String name) {
        // primero busco en que posicion voy a ingresar el nuevo nombre
        // la posicion debe corresponder a la posicion del nuevo nombre en orden alfabetico respecto a todos los demas
        // comienzo al final por la tactica de que cada vez "veo" menos cosas en el sentido que el array a analizar es cada vez chico
        // Como se supone un array ordenado, podria ser que si tengo un array de 100 posicion, simplemente pongo lo ultimo al final si es mayor a todos
        // sino deberia recorrer todo el array. Si arranco del principio, y el nombre ya es mayor tengo que recorrer todo igualmente.
        //
        // boolean isAlreadySorted = true;
        // si el nombre que ingreso es mayor o igual al ultimo de la lista, simplemente agrego
        boolean isAlreadySorted = name.compareTo(persons[personsNumber - 1]) >= 0;
        if (isAlreadySorted) {
            System.out.println("Ya esta ordenado, asi que solo añadi al final");
            persons[personsNumber] = name;
            personsNumber++;
        }
        else {
            int index;
            for (index = personsNumber - 1; index > 0; index--) {
                // no quiero que salga si "xuxa" es mayor a "luis", quiero que continue
                // la condicion es que salga solo si el actual es menor a "luis"
                // no confundir que corta cuando se cumple que continua
            /* if (persons[index].compareTo(name) < 0) {
                break;
            } */
                // yo quiero comprobar que el nombre que ingreso es mayor que el indice, y ahi salgo, sino continua el ciclo (o sea, no hacer nada)
                if (name.compareTo(persons[index]) > 0) {
                    break;
                }

            }
            //
            // System.out.println("El index es " + index);
            // el index es la posicion + 1;
            // que pasa si nunca entro al if. Y si es igual? Nada, solo uno se pone antes que el otro, en este ejercicio tan simple no marca la diferencia
            // en otros donde importa la fecha de ingreso y eso quizas si
            // para mayor claridad cuando hice el razonamiento con pseudocodigo, a name lo llamo new name para representar lo que pongo la primera vez
            // mejor que replaced el nombre new
            // en realidad necesito dos temporales, pero uso la de name del principio
            index++;
            System.out.println("Arranco en index " + index);
            String newName = name;
            for (; index < personsNumber + 1; index++) {
                String temp = persons[index];
                persons[index] = newName;
                newName = temp;
            }
            // la posicion del personsNumber aumenta en 1 por el añadido
            personsNumber++;
        }
        System.out.println("El numero de personas es: " + personsNumber);
        System.out.println("El array ordenado es: ");
        for (int personsIndex = 0; personsIndex < personsNumber; personsIndex++) {
            System.out.print(persons[personsIndex] + ", ");
        }
        System.out.println(" ");
    }
}
