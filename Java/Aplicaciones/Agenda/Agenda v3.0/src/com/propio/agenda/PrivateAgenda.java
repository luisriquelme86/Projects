package com.propio.agenda;
import java.util.Scanner;

/*
* - Objetivo
* En la parte de abajo
* */

public class PrivateAgenda {

    private static final Scanner scanner = new Scanner(System.in); // create once, use everywhere

    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        boolean done = false;
        do {
            showMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1: addContact(agenda);
                        break;
                case 2: searchContact(agenda);
                    break;
                case 3: removeContact(agenda);
                    break;
                case 4: modifyContact(agenda);
                    break;
                case 5: showContacts(agenda);
                    break;
                case 6: sortContacts(agenda);
                    break;
                case 0: System.out.println("Saliendo...");
                        done = true;
                    break;
                default: System.out.println("Opcion incorrecta");
                        break;
            }
        } while (!done);
    }

    public static void showMenu(){
        System.out.println("Seleccione una opcion del menu: ");
        System.out.println("1. Añadir un contacto");
        System.out.println("2. Buscar un contacto");
        System.out.println("3. Borrar un contacto");
        System.out.println("4. Modificar un contacto");
        System.out.println("5. Mostrar los contactos");
        System.out.println("6. Ordenar alfabeticamente los contactos");
        System.out.println("0. Salir");
    }

    public static void addContact(Agenda agenda) {
        System.out.println(ColorsUtiliy.ANSI_BLUE + "Ingrese los siguientes datos para añadir un nuevo contacto");
        System.out.println("Ingrese un nombre: ");
        String name = scanner.next();
        System.out.println("Ingrese un telefono: " + ColorsUtiliy.ANSI_RESET);
        int phone = scanner.nextInt();
        agenda.addContact(name, phone);
    }

    public static void searchContact(Agenda agenda) {
        if (agenda.getNumberOfPersons() == 0) {
            System.out.println(ColorsUtiliy.ANSI_RED  + "La agenda aun no tiene contactos" + ColorsUtiliy.ANSI_RESET);
            return;
        }
        System.out.println(ColorsUtiliy.ANSI_BLUE + "Ingrese el nombre del contacto a buscar: " + ColorsUtiliy.ANSI_RESET);
        String name = scanner.next();
        agenda.searchContact(name);
    }

    public static void removeContact(Agenda agenda) {
        if (agenda.getNumberOfPersons() == 0) {
            System.out.println(ColorsUtiliy.ANSI_RED + "La agenda aun no tiene contactos" + ColorsUtiliy.ANSI_RESET);
            return;
        }
        System.out.println(ColorsUtiliy.ANSI_BLUE + "Ingrese el nombre del contacto a remover: " + ColorsUtiliy.ANSI_RESET);
        String name = scanner.next();
        agenda.removeContact(name);
    }

    public static void modifyContact(Agenda agenda) {
        if (agenda.getNumberOfPersons() == 0) {
            System.out.println(ColorsUtiliy.ANSI_RED + "La agenda aun no tiene contactos");
            return;
        }
        System.out.println(ColorsUtiliy.ANSI_BLUE + "Ingrese el nombre del contacto a modificar: " + ColorsUtiliy.ANSI_RESET);
        String name = scanner.next();
        agenda.modifyContact(name);
    }

    public static void showContacts(Agenda agenda) {
        if (agenda.getNumberOfPersons() == 0) {
            System.out.println(ColorsUtiliy.ANSI_RED + "La agenda aun no tiene contactos" + ColorsUtiliy.ANSI_RESET);
            return;
        }
        agenda.showContacts();
    }

    public static void sortContacts(Agenda agenda) {
        if (agenda.getNumberOfPersons() == 0) {
            System.out.println(ColorsUtiliy.ANSI_RED + "La agenda aun no tiene contactos" + ColorsUtiliy.ANSI_RESET);
            return;
        }
        agenda.sortContacts();
    }

}

/*
- Objetivo:
. Mejorar la version 2.0 de la agenda a la version 3.0
. La mejora viene de mejorar el codigo de la aplicacion de agenda

- Mejoras
. Permitir ordenar la agenda alfabeticamente. Luego guardar los cambios
. Permitir modificar un contacto. Se debe modificar amigablemente, de la siguiente manera
  Se muestra el valor anterior, se modifica si se teclea algo y no se modifica si se presiona intro, se guardan los cambios despues
. Borrado de datos. Se borra del array un dato, se desplazan los siguientes a la izquierda y se guardan los cambios

- Resultado
. En total son 7 opciones
    añadir un contacto
    borrar un contacto
    modificar un contacto
    buscar un contacto
    mostrar los contactos
    ordenar alfabeticamente los contactos
    salir

- Hints o consejos
. Don't close a Scanner that's tied to System.in (no cerrar un scanner que esta bindeado a un System.in, este lo levanta la JVM, una
  vez cerrado no se puede volver a abrir)
. No cerrar el objeto scanner si el mismo levanto el System.im
. Para lograr "detectar" la tecla enter hay que recurrir a un workaround, ya que estamos trabajando con una aplicacion de consola y no
  una aplicacion GUI. Usando el scanner, se puede pasar a la siguiente linea y detectar si la linea anterior es de largo 0 o vacia. No puede
  ser nunca null, asi que es la unica opcion
. Es una buena idea declarar el scanner como privado, estatico y final si se va a usar la entrada de teclado, al fin y al cabo se va a utilizar siempre
  de la misma manera pero llamando a diferentes metodos

- Lecciones importantes que dejo este ejercicio
. El println para la suma de int
. El numberOfPersons como afecta al search
. El porque de la creacion de clases de log, que se manda un string y lo imprimi con colores diferentes y demas. Es mucho laburo sino como se demuestra en mi programa. Tengo que hacer
  muchos system.out.println configurados a mano con colores, poner un reset, me olvido de los espacios, etc, se solucionaria ampliando dicha utilidad de colores a una utilidad de log,
  que no instancia nada, solo recibe datos y los procesa, pero no los guarda (quiero decir, no guarda el estado, no es que se manda un valor, el mismo se almacena y luego se puede
  pedir el mismo, solo es de paso, input->output y la utilidad no tiene "memoria" de nada lo que entra o sale)
 */