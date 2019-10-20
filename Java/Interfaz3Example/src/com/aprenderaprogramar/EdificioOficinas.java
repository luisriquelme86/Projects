package com.aprenderaprogramar;

public class EdificioOficinas implements Edificio{

    int numeroOficinas;
    double superficie;

    public EdificioOficinas(int numeroOficinas, double superficie) {
        this.numeroOficinas = numeroOficinas;
        this.superficie = superficie;
    }

    public EdificioOficinas(int numeroOficinas) {
        this.numeroOficinas = numeroOficinas;
    }

    public int getNumeroOficinas() {
        return numeroOficinas;
    }

    public void setNumeroOficinas(int numeroOficinas) {
        this.numeroOficinas = numeroOficinas;
    }

    @Override
    public double getSuperficieEdificio() {
        return 0;
    }

    @Override
    public String toString() {
        return "numeroOficinas: " + numeroOficinas +
               " superficie: " + superficie;
    }
}
