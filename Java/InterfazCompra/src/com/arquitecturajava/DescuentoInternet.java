package com.arquitecturajava;

public class DescuentoInternet implements TipoDescuento {

    @Override
    public double importeDescontar(Compra compra) {
        double descuento;
        if (compra.getImporte() > 0 && compra.getImporte() < 200) {
            descuento = 20;
        }
        else {
            descuento= 30;
        }
        return compra.getImporte() * (descuento /100);
    }
}
