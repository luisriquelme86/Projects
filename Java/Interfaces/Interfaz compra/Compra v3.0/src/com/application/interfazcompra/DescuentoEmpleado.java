package com.application.interfazcompra;

public class DescuentoEmpleado implements Descuento {
    @Override
    public double getImporteDescuento(double importe) {
        double descuento;
        if (importe > 0 && importe < 100) {
            descuento = 30;
        }
        else {
            descuento = 40;
        }
        return importe - importe * descuento / 100;
    }
}
