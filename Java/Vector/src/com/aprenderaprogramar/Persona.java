package com.aprenderaprogramar;

public class Persona {

    private String nombre;
    private int idPersona;
    private int altura;

    public Persona(String nombre, int idPersona, int altura) {
        this.nombre = nombre;
        this.idPersona = idPersona;
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
