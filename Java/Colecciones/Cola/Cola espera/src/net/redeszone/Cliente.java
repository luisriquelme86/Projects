package net.redeszone;

public class Cliente {

    private String nombre;
    private int numeroMovil;
    private long fechaLlegada;
    private long fechaAtencion;

    public Cliente(String nombre, int numeroMovil) {
        this.nombre = nombre;
        this.numeroMovil = numeroMovil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroMovil() {
        return numeroMovil;
    }

    public void setNumeroMovil(int numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    public long getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(long fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public long getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(long fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
}
