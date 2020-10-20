package com.application.tiendavirtual;

public class Prueba {

    public static void main(String[] args) {

        // crea una tienda, lleno el almacen y luego muestro el inventario
        Tienda tienda = new Tienda();
        tienda.llenarAlmacen();
        tienda.mostrarInventario();

        // creamos el cliente, lo registramos en la tienda y mostramos su saldo
        Cliente cliente = new Cliente("Pedro", 1000);
        tienda.añadirCliente(cliente);
        cliente.mostrarSaldo();

        // esta parte no le encontraba mucha sentido, pero ahora si. El array de articulos lo traigo porque lo necesito "suelto" para
        // operar en el main, que esta "por fuera"
        Articulo[] articulos = tienda.obtenerArticulos();

        // Ejemplo de venta directa (imagino que es algo asi como "el mostrador", no virtual, o virtual pero no teniendo en cuenta los articulos cargados
        // sino cargando uno mismo por el cliente)
        tienda.vender(articulos[0], cliente);
        tienda.mostrarInventario();
        cliente.mostrarSaldo();
        cliente.mostrarHistorial();

        // ejemplo de venta mediante el carrito
        // En general, yo pensaria que lo mejor es que el cliente meta las cosas en su carrito el sol, pero el ejercicio de internet exige esta prueba
        // Al parecer, se debe poder hacer que la tienda cargue un carrito
        // No... la idea parece ser que ese metodo meta al carrito del cliente, sino deberia tener un carrito la tienda
        tienda.meterAlCarrito(articulos[1], cliente);
        tienda.meterAlCarrito(articulos[3], cliente);
        cliente.mostrarCarrito();
        tienda.venderCarrito(cliente);

        tienda.mostrarInventario();
        cliente.mostrarSaldo();
        cliente.mostrarHistorial();

        // cosas prohibidas
        // 1. Meter al carrito un articulo que no este en el inventario
        tienda.meterAlCarrito(new Articulo(99, "Articulo trampa", 0), cliente);

        // 2. Intentar vender un articulo que no existe en la tienda
        tienda.vender(new Articulo(99, "Articulo trampa", 0), cliente);

        // 3. Intentar vender un articulo a un cliente no registrado
        tienda.vender(articulos[0], new Cliente("Cliente no registrado", 0));
    }
}
