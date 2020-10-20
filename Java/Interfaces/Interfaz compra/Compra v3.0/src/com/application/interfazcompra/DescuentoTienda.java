package com.application.interfazcompra;

public class DescuentoTienda implements Descuento {

    @Override
    public double getImporteDescuento(double importe) {
        double descuento;
        if (importe > 0 && importe < 100) {
            descuento = 10;
        }
        else {
            descuento = 20;
        }
        return importe - importe * descuento / 100;
    }
}
