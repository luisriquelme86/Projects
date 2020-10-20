package com.application.interfazcompra;

public class Main {

    public static void main(String[] args) {

        // Compra compraTienda = new Compra("tienda", 1000);
        // Compra compraInternet = new Compra("internet", 1000);
        // Compra compraEmpleado = new Compra("empleado", 1000);

        // Notar que son todos los mismos objetos "compra" y que solo el nombre es orientativo

        Compra compraTienda = new Compra(1000);
        Compra compraInternet = new Compra(1000);
        Compra compraEmpleado = new Compra(1000);
        
        System.out.println("Se van a mostrar los importes con descuento de las compras para los siguientes");
        System.out.println("Importe con descuento en la tienda");
        System.out.println(compraTienda.getImporteDescuento(new DescuentoTienda()));
        System.out.println("Importe con descuento en internet");
        System.out.println(compraInternet.getImporteDescuento(new DescuentoInternet()));
        System.out.println("Importe con descuento para el empleado");
        System.out.println(compraEmpleado.getImporteDescuento(new DescuentoEmpleado()));
        System.out.println("");
    }
}
