package com.arquitecturajava.ejemplo1;

public class IPhoneX extends IPhone8 implements Validar {
    private String patronRostro;

    public IPhoneX(String marca, Persona persona) {
        super(marca, persona);
    }

    public String getPatronRostro() {
        return patronRostro;
    }

    public void setPatronRostro(String patronRostro) {
        this.patronRostro = patronRostro;
    }

    @Override
    public boolean validar(Persona persona) {
        if (persona.getPatronRostro() != null) {
            return persona.getPatronRostro().equals(patronRostro);
        }
        return super.validar(persona);
    }
}
