package com.application.interfazedificios;

public class EdificioOficinas implements Edificio {

    int numeroOficinas;
    double superficie;

    public EdificioOficinas(int numeroOficinas, double superficie) {
        this.numeroOficinas = numeroOficinas;
        this.superficie = superficie;
    }

    public int getNumeroOficinas() {
        return numeroOficinas;
    }

    public void setNumeroOficinas(int numeroOficinas) {
        this.numeroOficinas = numeroOficinas;
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
    public String toString() {
        return "Edificio de oficinas con numero de oficinas " + this.numeroOficinas + " y superficie " + this.superficie;
    }
}
