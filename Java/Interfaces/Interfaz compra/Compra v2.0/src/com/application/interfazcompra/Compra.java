package com.application.interfazcompra;

public class Compra {

    // private String tipo;
    private double importe;
    Descuento descuento;

    // public Compra(String tipo, double importe) {
    public Compra(Descuento descuento, double importe) {
        // this.tipo = tipo;
        this.descuento = descuento;
        this.importe = importe;
    }

    /*
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    */

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getImporteDescuento(){
        // Compra no debe realizar ninguna operacion aqui, mas que devolver el resultado que procese otra clase a la que le paso el importe
        return this.descuento.getImporteDescuento(this.importe);
        // return 0.0;
    }
}

/*
* Se cae de maduro que el metodo getImporteDescuento podria recibir 1 parametro, y que dicho parametro sea una instancia de
* algo asi como compraTienda, compraInternet, compraEmpleado, y que cada uno llame a su metodo getImporteDescuento dentro de esta clase compra
* y se termino. Pero como distingo el tipo? Paso los objetos y luego pregunto por el class asi lo reconozco o sigo pasando el tipo
* (lo cual es ridiculo! Le paso un objeto compraTienda y encima le tengo que pasar el tipo indicado como string??). Preguntar por el class
* sigue ensuciando el codigo con tantos if como objetos, obligado a modificarlo siempre. Y lo ultimo es un horror. Como hago para que todos los
* objetos sean tratados igual en forma abstracta pero cada uno haga lo que deba? Con interfaces :)
* Y porque las clases que implementan interfaz reciben la compra? Bueno, no es obligatorio, solo necesitan el importe, pero se puede pasar el objeto completo
*
*/