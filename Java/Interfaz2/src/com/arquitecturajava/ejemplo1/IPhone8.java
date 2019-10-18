package com.arquitecturajava.ejemplo1;

public class IPhone8 extends Telefono implements Validar {
    private int codigo;
    private String huella;

    public IPhone8(String marca, Persona persona) {
        super(marca, persona);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getHuella() {
        return huella;
    }

    public void setHuella(String huella) {
        this.huella = huella;
    }

    @Override
    public boolean validar(Persona persona) {
        if (persona.getPatronHuella() != null) {
            return persona.getPatronHuella().equals(huella);
        }
        if (persona.getCodigo() != 0) {
            return persona.getCodigo() == codigo;
        }
        return false;
    }
}
