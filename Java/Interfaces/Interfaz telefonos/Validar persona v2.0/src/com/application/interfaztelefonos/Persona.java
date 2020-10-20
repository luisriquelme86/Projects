package com.application.interfaztelefonos;

public class Persona {

    private String nombre;
    private int codigo;
    private String patron;
    private String huella;
    private String rostro;

    public Persona(String nombre) {
        this.nombre = nombre;
        // para evitar los null pointer exception al validar
        this.codigo = 0;
        this.patron = "";
        this.huella = "";
        this.rostro = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    public String getHuella() {
        return huella;
    }

    public void setHuella(String huella) {
        this.huella = huella;
    }

    public String getRostro() {
        return rostro;
    }

    public void setRostro(String rostro) {
        this.rostro = rostro;
    }
}
