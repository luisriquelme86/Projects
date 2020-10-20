package com.application.interfazedificios;

public class Polideportivo implements Edificio, InstalacionDeportiva {

    String nombre;
    double superficie;

    public Polideportivo(String nombre, double superficie) {
        this.nombre = nombre;
        this.superficie = superficie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    @Override
    public double getSuperficieEdificio() {
        return this.superficie;
    }

    @Override
    public int getTipoDeInstalacion() {
        return 5;
    }

    @Override
    public String toString() {
        return "Polideportivo con nombre " + this.nombre + " y superficie " + this.superficie;
    }
}
