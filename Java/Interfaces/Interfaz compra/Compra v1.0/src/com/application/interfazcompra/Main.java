package com.application.interfazcompra;

/*
 * Objetivo
 * Implementar un sistema de compra que permita indicar el tipo e importe de la misma, y que permita consultar por el
 * precio con descuento segun la situacion
 * Si la compra es en la tienda
 *      descuento del 10% si la compra es menor a 100
 *      descuento del 20% si la compra es mayor a 100
 * Si la compra es de otro tipo (se supondra "internet")
 *      descuento del 20% si la compra es menor a 100
 *      descuento del 30% si la compra es mayor a 100
 *
 * No hace falta en ningun momento crear un enum ni nada parecido con los tipos
 */

public class Main {

    public static void main(String[] args) {

        Compra compra = new Compra("tienda", 1000);
        System.out.println("Vamos a ver el importe con descuento de esta compra");
        System.out.println(compra.getImporteDescuento());
        System.out.println("");
    }
}
