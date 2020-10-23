package com.application.tiendavirtual;

public class Carrito {
    private final int MAX_ARTICULOS = 100;
    private Articulo[] articulos;
    private int tamanioCarrito;

    public Carrito() {
        this.articulos = new Articulo[MAX_ARTICULOS];
        this.tamanioCarrito = 0;
    }

    public void agregar(Articulo articulo) {
        this.articulos[this.tamanioCarrito] = articulo;
        this.tamanioCarrito++;
    }

    public void quitarUltimoArticuloDelCarrito() {
        this.tamanioCarrito--;
    }

    public Articulo[] getArticulos() {
        return articulos;
    }

    public int getTamanioCarrito() {
        return tamanioCarrito;
    }
}
