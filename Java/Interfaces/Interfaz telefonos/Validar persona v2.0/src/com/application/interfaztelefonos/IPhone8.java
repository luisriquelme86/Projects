package com.application.interfaztelefonos;

public class IPhone8 implements Validador {

    private String marca;
    private int codigo;
    private String patron;
    private String huella;

    public IPhone8(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
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

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getHuella() {
        return huella;
    }

    public void setHuella(String huella) {
        this.huella = huella;
    }

    @Override
    public boolean validar(Persona persona) {
        if (this.codigo != 0 && this.codigo == persona.getCodigo()) {
            return true;
        }
        else if (this.patron != null && this.patron.equals(persona.getCodigo())){
            return true;
        }
        else if (this.huella != null && this.huella.equals(persona.getHuella())) {
            return true;
        }
        return false;
    }
}
