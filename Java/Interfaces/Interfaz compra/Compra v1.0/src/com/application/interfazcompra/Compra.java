package com.application.interfazcompra;

public class Compra {

    private String tipo;
    private double importe;

    public Compra(String tipo, double importe) {
        this.tipo = tipo;
        this.importe = importe;
    }

    public String getCompra() {
        return tipo;
    }

    public void setCompra(String tipo) {
        this.tipo = tipo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getImporteDescuento() {
        // se suponen siempre mayores a 0 los importes
        double descuento;
        if (this.tipo.equals("tienda")) {

            if (this.importe > 0 && this.importe < 100) {
                descuento = 10;
            }
            else {
                descuento = 20;
            }
        }
        else {

            if (this.importe > 0 && this.importe < 100) {
                descuento = 20;
            }
            else {
                descuento = 30;
            }
        }
        return importe - importe * descuento / 100;
    }
}
