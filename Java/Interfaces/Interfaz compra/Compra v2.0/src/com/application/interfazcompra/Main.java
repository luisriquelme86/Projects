package com.application.interfazcompra;

/*
* Objetivo
* Seguiendo la linea con la aplicacion de compras de la primera version, se pide lo mismo pero de forma un poco diferente. Es decir, la idea es crear una aplicacion que, dada una compra
* calcule el importe de dicha compra con un descuento aplicado segun el tipo de compra realizada. Suponiendo que en este caso que pueden ser compras hechas en la tienda, online o
* si es un empleado
* Sin embargo, el calculo del importe con descuento debe ser refactorizado y hacerse de otra manera para que sea extensible en un futuro y evitar estar agregando cada vez mas cosas
* a un metodo "getImporteDescuento" de una compra. El metodo debe estar lo mas limpio posible
*
* Ayudas y pistas
* Recurrir al principio o concepto de "delegacion" entre dos clases para poder refactorizar correctamente. La delegacion se da cuando un objeto termina usando a
* otro objeto tal como esta sin cambiarlo
* Usar interfaces cuando sea necesario
* Notar que hay varios tipos de entidades queriendo hacer lo mismo, pero de diferente forma
*
*/

public class Main {

    public static void main(String[] args) {

        // Compra compraTienda = new Compra("tienda", 1000);
        // Compra compraInternet = new Compra("internet", 1000);
        // Compra compraEmpleado = new Compra("empleado", 1000);
        Compra compraTienda = new Compra(new DescuentoTienda(), 1000);
        Compra compraInternet = new Compra(new DescuentoInternet(), 1000);
        Compra compraEmpleado = new Compra(new DescuentoEmpleado(), 1000);
        System.out.println("Se van a mostrar los importes con descuento de las compras para los siguientes");
        System.out.println("Importe con descuento en la tienda");
        System.out.println(compraTienda.getImporteDescuento());
        System.out.println("Importe con descuento en internet");
        System.out.println(compraInternet.getImporteDescuento());
        System.out.println("Importe con descuento para el empleado");
        System.out.println(compraEmpleado.getImporteDescuento());
        System.out.println("");
    }
}
