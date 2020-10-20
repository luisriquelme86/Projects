package com.application.tiendavirtual;

public class Articulo {
    private int idArticulo;
    private String nombre;
    private double precio;

    public Articulo(int idArticulo, String nombre, double precio) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return this.nombre +
                " (ref. " + this.idArticulo + "), " +
                this.precio + " euros + iva";
    }
}
