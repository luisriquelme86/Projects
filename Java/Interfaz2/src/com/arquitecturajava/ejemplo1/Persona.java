package com.arquitecturajava.ejemplo1;

public class Persona {
    private String nombre;
    // se supone que la persona tiene sus propios codigos
    private int codigo;
    private String patron;
    private String patronHuella;
    private String patronRostro;

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

    public String getPatronHuella() {
        return patronHuella;
    }

    public void setPatronHuella(String patronHuella) {
        this.patronHuella = patronHuella;
    }

    public String getPatronRostro() {
        return patronRostro;
    }

    public void setPatronRostro(String patronRostro) {
        this.patronRostro = patronRostro;
    }
}
