package com.agenda.v1;
import java.util.Scanner;
/*
- Objetivo:
        . Crear una primera version de una agenda. Una agenda basica

        . Una agenda basica, similar a una de la vida real, es sencilla. Numero y telefono
        . Para no complicar las cosas, los datos se pueden almacenar en un array fijo, por ejemplo de tamaño 100
        . Al principio tiene lo basico -> Añadir, mostrar todas las personas, buscar y salir. No hay mas

        Entonces
        . Agenda de 100 personas. Solo se guardar el nombre y el telefono
        . Añadir, buscar, mostrar todos y salir
        . Usar un array

*/

/*
* https://docs.oracle.com/javase/tutorial/java/ (Language Basics)
* https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
* */

public class Agenda {
    // Esto lo agrege al final. Es estatica para poder usarlo en metodo estaticos. Al pasarlo entre funciones su valor no cambia
    // porque java envia por valor, no por referencia. Asi que cree esto
    public static int personCounter = 0;
    public static void main(String[] args) {

        // Primero creo la clase persona, asi el array guarda elementos de tipo persona
        Person[] persons = new Person[100];

        // Mucho despues puse esto. Parte basica de la programacion. Hago a medida que voy necesitando. Sino, se cae en el error de aplicar algo porque si,
        // porque se supone que esta bien sin necesitarlo, lo cual lleva a codigo muerto o inservible o complejo sin necesidad. Si bien es bueno tener
        // una estrategia y una base y partir de ella, y no siempre es bueno agregar y agregar sobre lo anterior, si es bueno irse dando cuenta de las necesidades
        // del codigo. Si bien a veces es bueno darse cuenta e ir moviendo todo
        // tambien es bueno ver que funciona y se mueve. Se me ocurrio crear una clase agenda y una clase persona para manejar todo, pero quizas en la otra version.
        // La programacion te lleva sola a desarrollar nuevas soluciones segun las necesidades. Aqui se ve todo muy junto, sin separacion, lo cual no es malo
        // pero el codigo no se limita a una sola tarea, es todo junto
        // int numberOfPersons = 0;
        // A partir de aqui, comienza algo diferente. Tengo diferentes opciones para seleccionar
        // y se deben mostrar hasta que se seleccione salir
        Scanner scanner = new Scanner(System.in);
        int option;
        boolean validOption = false;
        do {
            /*
            System.out.println("==========================================");
            System.out.println("ACHTUNG! Este ejemplo no funciona");
            System.out.println("==========================================");
            */
            // supongo que se ingresan siempre numeros
            // System.out.println("El numero de personas es " + numberOfPersons);
            System.out.println("El numero de personas es " + personCounter);
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. Añadir una persona");
            System.out.println("2. Buscar una persona");
            System.out.println("3. Mostrar todas las personas");
            System.out.println("4. Salir de la agenda");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    addPerson(persons);
                    validOption = true;
                    break;
                case 2:
                    searchPerson(persons);
                    validOption = true;
                    break;
                case 3:
                    showPersons(persons);
                    validOption = true;
                    break;
                case 4:
                    System.out.println("Adios!");
                    validOption = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    validOption = true;
                    break;
            }
            // el default maneja todos los valores que no son explicitamente manejados por las secciones del case
            // aqui es mejor que un mayor y menor un true o false de condicion
        } while (validOption);
        // } while ((option >= 1) && (option < 4));
    }

    public static void addPerson(Person[] persons) {
        // sin validaciones, se supone que ingreso un string y un int, no es el objetivo del ejercicio validar, no perder foco
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la persona: ");
        String name = scanner.next();
        System.out.println("Ingrese el telefono de la persona: ");
        int phone = scanner.nextInt();
        Person person = new Person(name, phone);
        // no tengo otra forma que rellenar el array con el indice
        // numberOfPersons++;
        // System.out.println("El numero de personas es " + numberOfPersons);
        // System.out.println("El numero de personas es " + personCounter);
        // persons[numberOfPersons] = person;
        persons[personCounter] = person;
        personCounter++;
    }

    public static void searchPerson(Person[] persons) {
        // por ahora solo busca si al menos una persona existe
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la persona: ");
        String name = scanner.next();
        boolean founded = false;
        int index;
        for (index = 0; index < personCounter; index++) {
            if (persons[index].getName().equals(name)) {
                founded = true;
                break;
            }
        }
        if (founded) {
            System.out.println("Se encontro la persona. Sus datos son: ");
            System.out.println("Nombre: " + persons[index].getName());
            System.out.println("Telefono: " + persons[index].getPhone());
        }
        else {
            System.out.println("No se encontro la persona");
        }
    }

    public static void showPersons(Person[] persons) {
        if (personCounter == 0) {
            System.out.println("No hay personas en la agenda");
            return;
        }
        System.out.println("Las personas son: ");
        for (int index = 0; index < personCounter; index++) {
            System.out.println("Nombre: " + persons[index].getName() + " telefono: " + persons[index].getPhone());
            System.out.println("==========================================");
        }
    }
}

/*
* . Necesito almacenar los datos de una persona en un array, nombre y telefono, un string y un int. Si fuera solo un tipo de dato no necesito una clase
*   Pero al tener dos datos distintos la unica forma de almacenarlo, al menos en java, es con un objeto asi que tengo que crear una clase
* . La clase persona es basica y almacena los atributos de una persona
*
* . Este es un programa interactivo, o sea, que el usuario interactua con el programa. Se deberia mostrar un menu de opciones, ya que no es un programa donde solo se procesen
*   datos y sale una respuesta, es mas dinamico.
* . La mejor manera es con un ciclo que perdure hasta seleccionar una opcion leyendo lo que ingreso el usuario
*
* . Nota final: Este ejemplo no funciona, no se actualiza nunca el valor numberOfPersons y eso es porque java siempre pasa los parametros por valor
*   No queda otra que hacer lo sugerido de un principio, la mejora, donde hay una clase agenda
*
* . Y que tal si number es estatica y esta por fuera? Ahi si funciona
* */