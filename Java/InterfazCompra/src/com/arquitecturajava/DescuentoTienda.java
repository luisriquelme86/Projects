package com.arquitecturajava;

public class DescuentoTienda implements TipoDescuento {
    @Override
    public double importeDescontar(Compra compra) {
        double descuento;
        if (compra.getImporte() > 0 && compra.getImporte() < 100) {
            descuento = 10;
        }
        else {
            descuento= 20;
        }
        return compra.getImporte() * (descuento /100);
    }
}
