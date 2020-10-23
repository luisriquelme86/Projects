package com.application.tiendavirtual;

public class Almacen {

    private final int MAX_ARTICULOS = 100;      // esto no me lo dieron al principio... con esto completo el constructor
    private Articulo[] articulos;
    private int[] cantidades;
    private int numArticulos;                   // tienen que ser privados, no puedo invocar la tienda y poner 0 a algunos de los 2

    public Almacen() {
        this.articulos = new Articulo[MAX_ARTICULOS];
        this.cantidades = new int[MAX_ARTICULOS];
    }

    public void llenar() {
        // Lleno el almacen a mano con 10 articulos
        this.articulos[0] = new Articulo(0, "Cero", 10.0);
        this.articulos[1] = new Articulo(1, "Uno", 20.0);
        this.articulos[2] = new Articulo(2, "Dos", 15.0);
        this.articulos[3] = new Articulo(3, "Tres", 180.0);
        this.articulos[4] = new Articulo(4, "Cuatro", 105.0);
        this.articulos[5] = new Articulo(5, "Cinco", 99.0);
        this.cantidades[0] = 12;
        this.cantidades[1] = 9;
        this.cantidades[2] = 10;
        this.cantidades[3] = 15;
        this.cantidades[4] = 4;
        this.cantidades[5] = 1;
        this.numArticulos = 6;
    }

    public Articulo[] getArticulos() {
        return articulos;
    }

    public int[] getCantidades() {
        return cantidades;
    }

    public int getNumArticulos() {
        return numArticulos;
    }
}
