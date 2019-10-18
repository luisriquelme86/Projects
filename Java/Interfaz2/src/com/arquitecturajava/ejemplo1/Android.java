package com.arquitecturajava.ejemplo1;

public class Android extends Telefono implements Validar {
    private String patron;

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

    public Android(String marca, Persona persona) {
        super(marca, persona);
    }

    @Override
    public boolean validar(Persona persona) {
        return persona.getPatron().equals(patron);
    }
}
