package com.application.tiendavirtual;

public class Prueba {

    public static void main(String[] args) {

        Tienda tienda = new Tienda();
        tienda.llenarAlmacen();
        tienda.mostrarInventario();

        Cliente cliente = new Cliente("Pedro", 1000);
        tienda.añadirCliente(cliente);
        cliente.mostrarSaldo();

        Articulo[] articulos = tienda.obtenerArticulos();

        tienda.vender(articulos[0], cliente);
        tienda.mostrarInventario();
        cliente.mostrarSaldo();
        cliente.mostrarHistorial();

        tienda.meterAlCarrito(articulos[1], cliente);
        tienda.meterAlCarrito(articulos[3], cliente);
        cliente.mostrarCarrito();
        tienda.venderCarrito(cliente);

        tienda.mostrarInventario();
        cliente.mostrarSaldo();
        cliente.mostrarHistorial();

        tienda.meterAlCarrito(new Articulo(99, "Articulo trampa", 0), cliente);
        tienda.vender(new Articulo(99, "Articulo trampa", 0), cliente);
        tienda.vender(articulos[0], new Cliente("Cliente no registrado", 0));
    }
}
