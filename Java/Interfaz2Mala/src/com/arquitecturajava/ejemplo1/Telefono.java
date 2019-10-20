package com.arquitecturajava.ejemplo1;

public class Telefono {
    private String marca;
    private int codigo;
    private String patron;

    public Telefono(String marca) {
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

    public boolean validar(Persona p) {

        if (p.getCodigo() != 0) {
            return p.getCodigo() == codigo;
        }
        if (p.getPatron() != null) {
            return p.getPatron().equals(patron);
        }
        return false;
    }
}
