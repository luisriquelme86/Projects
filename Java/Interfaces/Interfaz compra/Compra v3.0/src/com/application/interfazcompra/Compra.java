package com.application.interfazcompra;

public class Compra {

    private double importe;

    public Compra(double importe) {
        this.importe = importe;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getImporteDescuento(Descuento descuento){
        // Compra no debe realizar ninguna operacion aqui, mas que devolver el resultado que procese otra clase a la que le paso el importe
        // Remuevo la referencia a descuento y paso dicha referencia como parametro a esta funcion
        return descuento.getImporteDescuento(this.importe);
    }
}
