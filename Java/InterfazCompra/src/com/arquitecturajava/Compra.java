package com.arquitecturajava;

public class Compra {
    // TODO: encapsulamiento: acceso a los datos, asi un dato no podra ser modificado incorrectamente
    private double importe; // parte entera parte decimal
    private String tipo;

    public Compra(double importe, String tipo) {
        this.importe = importe;
        this.tipo = tipo;
    }

    public Compra(double importe) {
        this.importe = importe;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /*
    public double descuento() {
        double descuento;
        if (tipo.equals("tienda")) {
            if (importe > 0 && importe < 100) {
                descuento = 10;
            }
            else {
                descuento = 20;
            }
        }
        else { // se supone que si la compra es online entra por aca, el descuento es si la compra es online o por tienda
            if (importe > 0 && importe < 100) {
                descuento = 20;
            }
            else {
                descuento = 30;
            }
        }
        return importe - (importe * descuento / 100);
        TipoDescuento descuento = new DescuentoTienda();
        if (tipo.equals("tienda")) {
             descuento = new DescuentoTienda();
        }
        if (tipo.equals("online")) {
             descuento = new DescuentoTienda();
        }
        return importe - descuento.importeDescontar(this);
    } */


    public double descuento(TipoDescuento tipoDescuento) {
        // si tengo que estar poniendo un if aca estaria mal, esto ya es delegacion completa, se lo deberia pasar de afuera
        // si el if esta afuera, bueno, pero esta clase no deberia crecer cada vez mas
        return importe - tipoDescuento.importeDescontar(this);
    }
}
