package com.ejercicios.vector;


/*
*
* - Objetivo:
* . La idea es crear una contenedor de paquetes. Por ejemplo, un paquete tiene un codigo o id de paquete y un peso estimado (entre 80 y 150 kilos). Ese paquete tiene
*   se puede llevar a un contenedor de paquetes que ira creciendo a medida que se le envien cosas. Inicialmente puede contener 5 paquetes y a lo sumo 500 kilos
*   (100 kilos por cada 'lugarcito' del contenedor)
* . A medida que el tonelaje se incremente por falta de aguantar el peso, el contenedor debera extenderse mas
*
* . Introducir 50 paquetes a la vez con cargas aleatorias y
* 	Mostrar la carga maxima del contenedor, la capacidad, la cantidad de paquetes y el peso total
*		Si por alguna razon el peso total de los paquetes supera al peso maximo que puede cargar el contenedor, hay que aumentar la capacidad del mismo en
*		tantos elementos como fuera necesario para ese peso total, ya que el peso maximo que puede cargar el contenedor es limitado
*
* - Pistas
* . La linea de montaje tiene una cargaMaxima dada por 100 kilos * capacidad y debera ir mutando en el tiempo este numero
*
* */

import java.util.Vector;

public class Principal {


    public static void main(String[] args) {
        final int AVERAGE_WEIGHT = 100;
        // tengo una cadena de montaje inicial
        // Tiene una capacidad para 5 paquetes y se la cantidad de paquetes se incrementa en 1 segun la necesidad
        Vector<CompanyPackage> packagesContainer = new Vector<>(5, 1);

        // el maximo peso del contenedor es la capacidad por un peso promedio
        // int maximumContainerWeight = packagesContainer.capacity() * AVERAGE_WEIGHT;
        int packageTotalWeight = 0;

        // ingreso 50 paquetes con id consecutivo pero con peso aleatorio
        // Aun asi, pensar en los casos mas basicos, si meto 4 contenedores que tienen 150 kilos cada uno ya automaticamente tengo que meter
        // mas maximumContainerWeight porque son 600 kilos y el contenedor solo aguanta 500
        // Deberia de alguna forma asegurarme de aumentar la capacidad cuando este numero se esta por quebrar
        int maximumContainerWeight = 0;
        int newNumberOfPackages = 50;

        for (int index = 0; index < newNumberOfPackages; index++) {
            int packageWeight = randomPackageWeightGenerator();

            System.out.println("El paquete va a pesar " + packageWeight);

            // antes de agregar un paquete tengo nuevo al contenedor me tengo que fijar que pueda aguantar el peso con la capacidad que tengo
            maximumContainerWeight = packagesContainer.capacity() * AVERAGE_WEIGHT;
            if (packageTotalWeight + packageWeight > maximumContainerWeight) {
                System.out.println("La capacidad futura es " + (packageTotalWeight + packageWeight) + " y no hay espacio, necesito asegurar mas espacio");
                int newCapacity = Math.round((packageTotalWeight + packageWeight) / AVERAGE_WEIGHT) + 1;
                System.out.println("Necesito asegurarme al menos " + newCapacity);
                packagesContainer.ensureCapacity(newCapacity);
                System.out.println("La nueva capacidad es " + packagesContainer.capacity());
            }
            // sumo para obtener el peso total
            packageTotalWeight += packageWeight;
            packagesContainer.add(new CompanyPackage(index, packageWeight));
        }
        System.out.println("\n");
        System.out.println("Ciclo terminado " + packagesContainer.capacity());
        System.out.println("\n");
        // recalculo la nueva capacidad
        System.out.println("La capacidad o el numero de posiciones del vector es " + packagesContainer.capacity());
        maximumContainerWeight = packagesContainer.capacity() * AVERAGE_WEIGHT;
        System.out.println("\n");
        System.out.println("Vamos a mostrar el contenedor de paquetes con los siguientes datos");
        System.out.println("Capacidad maxima del contenedor " + maximumContainerWeight + " kilos");
        System.out.println("Tiene capacidad para " + packagesContainer.capacity());
        System.out.println("Peso total de los paquetes " + packageTotalWeight);
    }

    public static int randomPackageWeightGenerator() {
        // Los pesos de los paquetes van de los 80 a las 150 y no hay otra que sean con coma por cuestiones de la vida real
        // pero por el random tambien? Le pongo int y fue
        return (int)(Math.ceil(Math.random() * 70) + 80);
    }
}

/*
* Sobre este ejercicio
* . Primero que nada, segun la pagina lo hice mal, debo cargar 50 y mostrar lo solicitado. Solo si realmente no cumple tengo que añadir
*   Podria quedar pendiente para otro ejercicio, por leer mal. Sin embargo este ejemplo es muy bueno tambien, ya que si por alguna razon el peso es superado no se pone
*   hasta el momento de tener mas espacio
*
* . Lecciones:
*   La division entre int da un float, como se ve antes del Math.round
*   Si la capacidad es de 100 * capacidad, la unica forma de que si se pasa en kilos, es ver el total que tendre y dividirlo por esos 100 kilos y me
*   da cuantas "capacidades" necesito que es justamente el new capacity. Originalmente lo pense mal. Aun asi, este es un excelente ejercicio mas
*   alla de no cumplir lo pedido estrictamente. Tranquilamente son dos tipos de ejercicios con vector. De todas formas, la leccion es leer mejor
*   
*
* */