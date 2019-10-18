package com.arquitecturajava.ejemplo1;
// si no es abstracta deberia implementar el metodo validar de la interfaz validar
public abstract class Telefono implements Activar {
    String marca;
    Persona persona;

    public Telefono(String marca, Persona persona) {
        this.marca = marca;
        this.persona = persona;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void on() {
        System.out.println("telefono encendido");
    }

    @Override
    public void off() {
        System.out.println("telefono apagado");
    }
}
