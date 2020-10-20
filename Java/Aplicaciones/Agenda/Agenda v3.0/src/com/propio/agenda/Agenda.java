package com.propio.agenda;

import java.util.Scanner;

public class Agenda {

    private static final Scanner scanner = new Scanner(System.in); // create once, use everywhere
    private Person[] contacts = new Person[50];
    private int numberOfPersons = 0; // cuidado con confundir el numero de personas y las posiciones del array. Si tengo 1 persona, la posicion del array es 0. Y 
                                     // las busquedas como en el search quizas es necesario restar el numero "1" a las operaciones, y puedo parecer confuso
                                     // Se podria decir que los elementos cargados son el numero de personas - 1 para no complicarse, pero hay que tenerlo en cuenta   

    public void addContact(String name, int phone) {
        Person person = new Person(name, phone);
        this.contacts[this.numberOfPersons] = person;
        this.numberOfPersons++;
        System.out.println(ColorsUtiliy.ANSI_GREEN + "========== Se agrego la persona " + name + "!!!!! =========" + ColorsUtiliy.ANSI_RESET);
    }

    public int getNumberOfPersons() {
        return this.numberOfPersons;
    }

    public void searchContact(String name) {
        // podria mostrar multiples contactos con el mismo nombre, pero excede al ejercicio por mucho
        int index = search(name);
        if (index != -1) {
            Person person = this.contacts[index];
            System.out.println(ColorsUtiliy.ANSI_GREEN + "========= Persona encontrada! =========");
            System.out.println(ColorsUtiliy.ANSI_GREEN + "========= Nombre: " + person.getName() + " telefono: " + person.getPhone() + " ========= " + ColorsUtiliy.ANSI_RESET);
        }
    }

    public void modifyContact(String name) {
        int index = search(name);
        if (index != -1) {
            Person person = this.contacts[index];
            System.out.println(ColorsUtiliy.ANSI_BLUE + "========= Para modificar la persona " + name + " escriba a continuacion el nuevo nombre. Para salir, presione enter =========" + ColorsUtiliy.ANSI_RESET);
            String newName = scanner.nextLine();
            if (!newName.equals("")) {
                // si es distinto de vacio, lo tomo
                person.setName(newName);
                System.out.println(ColorsUtiliy.ANSI_GREEN + "========= Se modifico el nombre anterior " + "'" + name + "' por " + "'" + newName + "'" + " =========" + ColorsUtiliy.ANSI_RESET);
            }
        }
    }

    public void removeContact(String name) {
        int index = search(name);
        if (index != -1) {
            for (int loopIndex = index; loopIndex < this.numberOfPersons; loopIndex++) {
                this.contacts[loopIndex] = this.contacts[loopIndex + 1];
            }
            this.numberOfPersons--;
            System.out.println(ColorsUtiliy.ANSI_GREEN + "========= Se removio a " + name + " =========" + ColorsUtiliy.ANSI_RESET);
        }
    }


    public void showContacts() {
        System.out.println(ColorsUtiliy.ANSI_BLUE + "Los contactos de la agenda son: " + this.getNumberOfPersons());
        for (int index = 0; index < this.numberOfPersons; index++) {
            System.out.println(ColorsUtiliy.ANSI_PURPLE  + "Nombre " + this.contacts[index].getName() + " telefono " + this.contacts[index].getPhone() + ColorsUtiliy.ANSI_RESET);
        }
    }

    public void sortContacts() {
        // una burbuja mejorada -> Fuck, no es con numeros. Es con string, voy a tener que usar un comparator
        // esto no es posible if (this.contacts[innerIndex].getName() > this.contacts[innerIndex + 1].getName())
        for (int outerIndex = 0; outerIndex < this.numberOfPersons; outerIndex++) {
            boolean isAlreadySorted = true;
            for (int innerIndex = 0; innerIndex < this.numberOfPersons - 1; innerIndex++) {
                if (this.contacts[innerIndex].getName().compareTo(this.contacts[innerIndex + 1].getName()) > 0) {
                    Person temp = this.contacts[innerIndex + 1];
                    this.contacts[innerIndex + 1] = this.contacts[innerIndex];
                    this.contacts[innerIndex] = temp;
                    isAlreadySorted = false;
                }
            }
            if (isAlreadySorted) {
                System.out.println("Salio en la pasada numero " + (outerIndex + 1));
                break;
            }
        }
    }

    private int search(String name) {
        int index = -1;
        boolean found = false;
        do {
            index++;
            if (name.equals(this.contacts[index].getName())) {
                found = true;
            }
        } while (index < this.numberOfPersons - 1 && !found); // importantisimo devolver el -1 en la busqueda. Sino se confunde el numero de personas (para informar al usuario cuantas hay) con el contador del array
        if (!found) {
            System.out.println(ColorsUtiliy.ANSI_RED + "========= No se encontro " + name + " en la agenda =========" + ColorsUtiliy.ANSI_RESET);
        }
        return found ? index : -1;
    }
}
