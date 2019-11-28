package com.aprenderaprogramar;

public class Vehiculo {

    private int idVehiculo;
    private String tipo;

    public Vehiculo(int idVehiculo, String tipo) {
        this.idVehiculo = idVehiculo;
        this.tipo = tipo;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
