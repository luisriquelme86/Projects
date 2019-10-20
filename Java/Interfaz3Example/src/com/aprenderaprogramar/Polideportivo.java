package com.aprenderaprogramar;

public class Polideportivo implements InstalacionDeportiva, Edificio {

    String nombre;
    double superficie;
    int tipo;

    public Polideportivo(String nombre) {
        this.nombre = nombre;
    }

    public Polideportivo(String nombre, double superficie, int tipo) {
        this.nombre = nombre;
        this.superficie = superficie;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public double getSuperficieEdificio() {
        return superficie;
    }

    @Override
    public int getTipoDeInstalacion() {
        return tipo;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre +
               " superficie: " + superficie +
               " tipo: " + tipo;
    }
}
