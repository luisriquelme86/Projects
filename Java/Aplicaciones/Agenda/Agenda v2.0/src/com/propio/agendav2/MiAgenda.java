package com.propio.agendav2;
import java.util.Scanner;

/*
* - Objetivo:
* . Mejorar la version 1.0 de la agenda a la version 2.0
* . La mejora viene de mejorar el codigo de la aplicacion de agenda
*
* - Explicacion y objetivos
*
* 1) La agenda y el array de personas
* . El array de personas estaba la clase main y se pasaba entre funciones. Incluso si se usa como variable estatica y no se pasa entre funciones
*   no es lo mejor. El codigo del main solo deberia servir para instanciar los objetos necesarios, no para hacer todas las operaciones ahi
* . La agenda tiene un array de personas. Lisa y llanamente
*
* 2) La agenda y las operaciones
* . Las operaciones hay que moverlas desde el main a la agenda, al menos aquellas especificas de la agenda (como añadir, buscar, mostrar, etc)
*
* */

public class MiAgenda {

    // podria declarar agenda y scanner como variables static en lugar de pasar la agenda y volver a crear variables
    // para scanner. Seria mas comodo. Primero lo mas sencillo. Las variables de scanner no tiene sentido pasarlas a las funciones
    // si las creo en las funciones, las mismas variables se destruyen al salir de la funcion
    // agenda en lugar de una variable podria ser una propiedad static, pero no parece desde el punto de vista de la programacion adecuado, si bien se puede
    // La agenda se podria declarar como static, pero solo seria para poder acceder a ella desde los metodos static, forzando las cosas.
    // No se declara static porque realmente sea adecuado, sino por necesidad para que algo funcione (como algo mal programado). Una variable asi se inicializa una sola vez cuando
    // se carga la clase en memoria y se puede acceder a ella sin necesidad del objeto. No es algo deseable ni requerido en este ejercicio
    // Si bien miembro estatico se puede considerar una variable global no es lo que quiero, porque la haria accesible desde afuera del codigo (lo cual es ridiculo) que es
    // la llamada por consola (esto es un main, la llamada principal de java)

    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        Scanner optionScanner = new Scanner(System.in);
        boolean exit = false;
        do {
            // Muestro un menu de seleccion
            showMenu();
            int option = optionScanner.nextInt();
            switch (option) {
                case 1: addPerson(agenda);
                        break;
                case 2: searchPerson(agenda);
                        break;
                case 3: showPersons(agenda);
                        break;                          // cuidado con los break
                case 4: exit = true;
                        break;
                default: System.out.println("Opcion incorrecta");
                         break;
            }
        } while (!exit); // no es un repeat until
        // si no se ponen los break, pasa de largo. Por eso pasaba que el exit true se ejecutaba siempre, incluido los default
        // los break deben estar. Y el default no es un finally que se ejecuta siempre, sino para cuando los otros casos no estan incluidos

    }

    public static void showMenu() {
        System.out.println("Elija una de las siguientes: ");
        System.out.println("1. Añadir una persona");
        System.out.println("2. Buscar una persona");
        System.out.println("3: Mostrar personas");
        System.out.println("4. Salir");
    }

    public static void addPerson(Agenda agenda) {
        // solo toma el nombre y no se pueden usar espacios, leer mas abajo de todo
        Scanner personScanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre: ");
        String name = personScanner.next();
        System.out.println("Ingrese el telefono: ");
        int phone = personScanner.nextInt();
        agenda.addPerson(name, phone);
    }

    public static void searchPerson(Agenda agenda) {
        Scanner personScanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la persona a buscar: ");
        String name = personScanner.next();
        agenda.searchPerson(name);
    }

    public static void showPersons(Agenda agenda) {
        agenda.showPersons();
    }

}

/*
* - Teoria
* 1) Clase persona y agenda
* . Se podria pensar inicialmente que una persona posee una agenda, y esa agenda esta compuesta de mas personas. Lo que llevaria a pensar en cierta estructura
*  interesante de analizar. Una persona "usa" una agenda (se asocia) y esa agenda tiene otras personas. Pero no es el punto del ejercicio
* . Siguiendo con la teoria, hasta tendria sentido. Se pueden tener 10 mil personas, cada una con 10 mil agendas, que tengas mas personas. Pero una vez mas
*  no es el objetivo de este ejercicio en particular y requiere mas conocimientos, tiempo y consideraciones (problemas circulares de referencias quizas?)
*
* 2) La agenda como clase de utilidad
* . Se podria pensar que la agenda no deberia ser instanciable, pero no tiene mucho sentido. No se dedica solo a procesar datos y mostrar resultados, sino que
*   realizar operaciones y "guarda" datos por asi decirlo. No es como un parseador de datos que devuelve el mismo dato cambiado y no toca el original, la agenda
*   crea personas, por ejemplo, y si hubiera una base las guardaria en ella
*
* */

/*
* La agenda actual no acepta nombre con espacios como "luis alberto", podria, pero escapa a los objetivos del ejercicio que era hacer una agenda muy basica
* que se pueda ingresar nombre y telefono y se guarden y se puedan buscar y mostrar, ademas de usar clases.
* Pensar que aunque se puedan ingresar cosas como "luis alberto", "luis fernando" ya hay que entrar en otras cuestiones mas, como separar ese
* nombre pudiendo diferenciar si el espacio es nombre, nombre nombre o nombre apellido, si la clase persona deberia contemplar nombres compuestos y apellidos
* Es para pensar y por ahora escapa al objetivo. Se deberian hacer otros planteos mas con busquedas de patterns complicando y extendiendo mas las cosas
* cuando no es el objetivo primordial, sino que era aprender otros conceptos
*
* Tampoco se hicieron validaciones de numeros y letras porque escapan al ejercicio
*
* */