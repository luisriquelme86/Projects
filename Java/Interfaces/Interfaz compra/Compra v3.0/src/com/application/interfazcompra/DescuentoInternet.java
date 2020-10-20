package com.application.interfazcompra;

public class DescuentoInternet implements Descuento {

    @Override
    public double getImporteDescuento(double importe) {
        double descuento;
        if (importe > 0 && importe < 100) {
            descuento = 20;
        }
        else {
            descuento = 30;
        }
        return importe - importe * descuento / 100;
    }
}
