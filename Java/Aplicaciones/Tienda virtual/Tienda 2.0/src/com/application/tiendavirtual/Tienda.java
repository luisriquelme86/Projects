package com.application.tiendavirtual;

import java.util.Date;

public class Tienda {
    private final int MAX_CLIENTES = 100;
    private Cliente[] clientes;
    private Almacen almacen;

    private int numClientes;

    public Tienda() {
        this.clientes = new Cliente[MAX_CLIENTES];
        this.numClientes = 0;
        this.almacen = new Almacen();
    }

    public void llenarAlmacen() {
        this.almacen.llenar();
    }

    public void mostrarInventario() {
        System.out.println("Mostrando inventario de la tienda: ");
        for (int index = 0; index < this.almacen.getNumArticulos() ; index++) {
            System.out.println("-------------------------------------");
            System.out.println("[" + index +"] " + "Articulo: " + this.almacen.getArticulos()[index].toString());
            System.out.println("Cantidad en stock: " + this.almacen.getCantidades()[index]);
        }
        System.out.println("-------------------------------------");
    }

    public Articulo[] obtenerArticulos() {
        return this.almacen.getArticulos();
    }

    public void añadirCliente(Cliente cliente) {
        this.clientes[this.numClientes] = cliente;
        this.numClientes++;
    }

    public void meterAlCarrito(Articulo articulo, Cliente cliente) {
        if (this.tieneStock(articulo) && this.validarCliente(cliente)) {
            cliente.agregarAlCarrito(articulo);
        }
    }

    public void venderCarrito(Cliente cliente) {
        for (int index = cliente.getTamanioCarrito() - 1; index >= 0; index--) {
            if (this.vender(cliente.getCarrito().getArticulos()[index], cliente)) {
                cliente.quitarUltimoArticuloDelCarrito();
            }
        }
    }

    public boolean vender(Articulo articulo, Cliente cliente) {
        if (this.tieneStock(articulo) && this.validarCliente(cliente)) {
            if (cliente.getSaldo() >= articulo.getPrecio() ) {
                System.out.println("Vendiendo articulo " + articulo.getNombre() + " a cliente " + cliente.getNombre());
                cliente.disminuirSaldo(articulo.getPrecio());
                cliente.añadirAlHistorial(articulo, new Date());
                int index = 0;
                for (; index < this.almacen.getNumArticulos(); index++) {
                    if (this.almacen.getArticulos()[index].equals(articulo)) {
                        this.almacen.getCantidades()[index]--;
                        break;
                    }
                }
                return true;
            }
            else {
                System.out.println("Saldo insuficiente");
                return false;
            }
        }
        else {
            return false;
        }
    }

    public boolean tieneStock(Articulo articulo) {
        boolean encontrado = false;
        int indice = 0;
        while(!encontrado && indice <= this.almacen.getNumArticulos() - 1) {
            if (this.almacen.getArticulos()[indice].equals(articulo)) {
                encontrado = true;
            }
            indice++;
        }
        indice--;
        if (encontrado) {
            return this.almacen.getCantidades()[indice] > 0;
        }
        else {
            System.out.println("-- Error: Articulo " + articulo.getNombre() + " no existe en la tienda");
            return false;
        }
    }

    public boolean validarCliente(Cliente cliente) {
        boolean encontrado = false;
        int indice = 0;
        while(!encontrado && indice <= numClientes - 1) {
            if (this.clientes[indice].equals(cliente)) {
                encontrado = true;
            }
            indice++;
        }
        indice--;
        if (!encontrado) {
            System.out.println("-- Error: Cliente no registrado en la tienda");
        }
        return encontrado;
    }
}
