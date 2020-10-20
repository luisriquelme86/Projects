package com.application.interfaztelefonos;

public class Android implements Validador {

    private String marca;
    private int codigo;
    private String patron;

    public Android(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    @Override
    public boolean validar(Persona persona) {
        // el default de los int es 0, no null. Null es solo para referencias y no para primitivos
        if (this.codigo != 0 && this.codigo == persona.getCodigo()) {
            return true;
        }
        else if (this.patron != null && this.patron.equals(persona.getCodigo())){
            return true;
        }
        return false;
    }
}
