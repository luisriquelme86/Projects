package com.application.tiendavirtual;

import java.util.Date;

public class Cliente {
    private final int MAX_ARTICULOS = 100;      // esto no me lo dieron al principio... con esto completo el constructor
    private String nombre;
    private double saldo;
    private Articulo[] carrito;
    private Tienda tienda;                      // porque el cliente tiene referencia a su/la tienda?

    // estos son del ejercicio no se porque los puso pero podria ser una opcion
    private Articulo[] historialArticulos;
    private Date[] historialFechas;
    // para mi estos son al pedo. Sirven... pero esta bien que sean publicos y no privados..?
    private int tamanioCarrito;
    private int tamanioHistorial;

    // tiene sentido que el cliente arranque con un nombre y un saldo
    public Cliente(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.carrito = new Articulo[MAX_ARTICULOS];
        this.tamanioCarrito = 0;
        this.historialArticulos = new Articulo[MAX_ARTICULOS];
        this.historialFechas = new Date[100];
        this.tamanioHistorial = 0;
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
        this.carrito[this.tamanioCarrito] = articulo;
        this.tamanioCarrito++;
    }

    // se supone que siempre quita el ultimo
    public void quitarUltimoArticuloDelCarrito() {
        this.tamanioCarrito--;
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

    // agregados por el ejercicio que estoy haciendo. Son los getter con otro nombre
    public Articulo[] getCarrito() {
        return this.carrito;
    }

    public Articulo[] getHistorialArticulos() {
        return this.historialArticulos;
    }

    public Date[] getHistorialFechas() {
        return this.historialFechas;
    }

    // este tiene mucho sentido para mi. Aun asi, serian los getter con otro nombre
    public void mostrarCarrito() {
        System.out.println("Contenido del carrito de " + this.nombre);
        System.out.println("-------------------------------------");
        for (int index = 0; index < this.tamanioCarrito; index++) {
            System.out.println("-- " + this.carrito[index].toString());
        }
        System.out.println("-------------------------------------");
    }

    public int getTamanioCarrito() {
        return this.tamanioCarrito;
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
