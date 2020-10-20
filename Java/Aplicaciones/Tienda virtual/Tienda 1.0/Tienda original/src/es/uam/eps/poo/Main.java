package es.uam.eps.poo;

/**
 *
 * @author nets
 */
public class Main {

    public static void main(String[] args) {

        // Creamos tienda, llenamos el almacen y mostramos el inventario:
        Tienda t = new Tienda();
        t.llenarAlmacen();
        t.mostrarInventario();        
    }
}
