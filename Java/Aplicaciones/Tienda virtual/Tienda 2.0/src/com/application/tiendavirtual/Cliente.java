package com.application.tiendavirtual;

import java.util.Date;

public class Cliente {
    private final int MAX_ARTICULOS = 100;
    private String nombre;
    private double saldo;
    private Carrito carrito;

    private Articulo[] historialArticulos;
    private Date[] historialFechas;
    private int tamanioHistorial;

    public Cliente(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.historialArticulos = new Articulo[MAX_ARTICULOS];
        this.historialFechas = new Date[100];
        this.tamanioHistorial = 0;
        this.carrito = new Carrito();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void agregarAlCarrito(Articulo articulo) {
        this.carrito.agregar(articulo);
    }

    public void quitarUltimoArticuloDelCarrito() {
        this.carrito.quitarUltimoArticuloDelCarrito();
    }

    public void añadirAlHistorial(Articulo articulo, Date fecha){
        this.historialArticulos[this.tamanioHistorial] = articulo;
        this.historialFechas[tamanioHistorial] = fecha;
        this.tamanioHistorial++;
    }

    public void aumentarSaldo() {
    }

    public void disminuirSaldo(double saldo){
        this.saldo = this.saldo - saldo;
    }


    public Carrito getCarrito() {
        return this.carrito;
    }

    public Articulo[] getHistorialArticulos() {
        return this.historialArticulos;
    }

    public Date[] getHistorialFechas() {
        return this.historialFechas;
    }


    public void mostrarCarrito() {
        System.out.println("Contenido del carrito de " + this.nombre);
        System.out.println("-------------------------------------");
        for (int index = 0; index < this.carrito.getTamanioCarrito(); index++) {
            System.out.println("-- " + this.carrito.getArticulos()[index].toString());
        }
        System.out.println("-------------------------------------");
    }

    public int getTamanioCarrito() {
        return this.carrito.getTamanioCarrito();
    }

    public void mostrarHistorial() {
        System.out.println("Historial de compras de " + this.nombre + " :");
        for (int indice = 0; indice < this.tamanioHistorial - 1; indice++) {
            System.out.println(this.historialArticulos[indice] + " en " + this.historialFechas[indice]);
        }
        System.out.println("-------------------------------------");
    }

    public void mostrarSaldo() {
        System.out.println("Saldo actual de " + this.saldo);
    }
}
