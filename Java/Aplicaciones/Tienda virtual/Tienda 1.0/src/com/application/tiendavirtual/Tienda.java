package com.application.tiendavirtual;

import java.util.Date;

public class Tienda {
    private final int MAX_ARTICULOS = 100;      // esto no me lo dieron al principio... con esto completo el constructor
    private final int MAX_CLIENTES = 100;       // esto no me lo dieron al principio... con esto completo el constructor
    private Articulo[] articulos;
    private int[] cantidades;
    private Cliente[] clientes;

    // me parecen al pedo, se pueden obtener del size del array cuando es necesario, pero boe... imagino que son public para acceder a ellos en cualquier
    // momento y se actualizan
    private int numArticulos;           // tienen que ser privados, no puedo invocar la tienda y poner 0 a algunos de los 2
    private int numClientes;
    // ahi recorde, es como en agenda, creas de antemano un monton de espacio en el array para los articulos (100) y como agregas solo
    // una cantidad el array va hasta ahi (seria como el size). Esto no es una lista dinamica o que se puede hacer push como en javascript

    public Tienda() {
        this.articulos = new Articulo[MAX_ARTICULOS];
        this.cantidades = new int[MAX_ARTICULOS];
        this.clientes = new Cliente[MAX_CLIENTES];
        this.numClientes = 0;
    }

    // ejercicio: muy buena esta idea
    public void llenarAlmacen() {
        // Lleno el almacen a mano con 10 articulos
        this.articulos[0] = new Articulo(0, "Cero", 10.0);
        this.articulos[1] = new Articulo(1, "Uno", 20.0);
        this.articulos[2] = new Articulo(2, "Dos", 15.0);
        this.articulos[3] = new Articulo(3, "Tres", 180.0);
        this.articulos[4] = new Articulo(4, "Cuatro", 105.0);
        this.articulos[5] = new Articulo(5, "Cinco", 99.0);
        this.cantidades[0] = 12;
        this.cantidades[1] = 9;
        this.cantidades[2] = 10;
        this.cantidades[3] = 15;
        this.cantidades[4] = 4;
        this.cantidades[5] = 1;
        this.numArticulos = 6;
    }

    // ejercicio
    // la palabra ref. es abreviatura de referencia para los inventarios, se usa mucho, lo mas comun es que sea el id de algo
    // originalmente escribir aqui la salida del print de cada articulo pero es mejor usar el to string de la clase articulo
    public void mostrarInventario() {
        System.out.println("Mostrando inventario de la tienda: ");
        for (int index = 0; index < this.numArticulos ; index++) {
            System.out.println("-------------------------------------");
            System.out.println("[" + index +"] " + "Articulo: " + this.articulos[index].toString());
            System.out.println("Cantidad en stock: " + this.cantidades[index]);
        }
        System.out.println("-------------------------------------");
    }

    // public Articulo[] getArticulos() {   // traducen el get y le ponen obtener... es al pedo. Ejercicio
    public Articulo[] obtenerArticulos() {
        return this.articulos;
    }

    public void añadirCliente(Cliente cliente) {
        this.clientes[this.numClientes] = cliente;
        this.numClientes++;
    }

    // del ejercicio: tiene logica
    public void meterAlCarrito(Articulo articulo, Cliente cliente) {
        // de todas formas teng que verificar que tiene  stock
        if (this.tieneStock(articulo) && this.validarCliente(cliente)) {
            cliente.agregarAlCarrito(articulo);
        }
    }

    // del ejercicio
    public void venderCarrito(Cliente cliente) {
        // es mejor para mi quitar los articulos en orden inverso, es decir, del ultimo al primero
        // incluso quizas si lo pensas es mejor que en lugar de array sea una pila (filo, primero entrar-ultimo salir) pero eso ya es otro tema
        // no olvidar el -1, es re importante. El tamaño del carrito - 1 son las posiciones de los articulos. No confundirse
        for (int index = cliente.getTamanioCarrito() - 1; index >= 0; index--) {
            if (this.vender(cliente.getCarrito()[index], cliente)) {
                cliente.quitarUltimoArticuloDelCarrito();
            }
            // no me complico borrando articulos del array ni nada parecido, simplemente cada vez que vendo redusco el size del carrito en 1, pero no
            // saco elementos ni nada. Quedan ahi
        }
    }

    public boolean vender(Articulo articulo, Cliente cliente) {
        if (this.tieneStock(articulo) && this.validarCliente(cliente)) {
            // primero que nada al cliente le descuento el cash
            // tiene dinero?
            // y la validacion del stock. Que pasa si quiero vender algo que no tengo mas?
            if (cliente.getSaldo() >= articulo.getPrecio() ) {
                System.out.println("Vendiendo articulo " + articulo.getNombre() + " a cliente " + cliente.getNombre());
                // resto saldo al cliente y lo pongo en su historial de compras
                cliente.disminuirSaldo(articulo.getPrecio());
                cliente.añadirAlHistorial(articulo, new Date());
                // redusco el stock del producto
                int index = 0;
                for (; index < this.numArticulos; index++) {
                    // leccion, iguales no es lo mismo. Aqui pregunto si es el mismo
                    if (this.articulos[index].equals(articulo)) {
                        this.cantidades[index]--; // si encuentro el articulo redusco su stock y salgo
                        break;
                    }
                }
                return true;
            }
            else {
                System.out.println("Saldo insuficiente");
                return false;
            }
        }
        else {
            return false;
        }
    }

    public boolean tieneStock(Articulo articulo) {
        boolean encontrado = false;
        int indice = 0;
        while(!encontrado && indice <= numArticulos - 1) {
            if (this.articulos[indice].equals(articulo)) {
                encontrado = true;
            }
            indice++;
        }
        indice--;
        if (encontrado) {
            return this.cantidades[indice] > 0;
        }
        else {
            System.out.println("-- Error: Articulo " + articulo.getNombre() + " no existe en la tienda");
            return false;
        }
    }

    public boolean validarCliente(Cliente cliente) {
        boolean encontrado = false;
        int indice = 0;
        while(!encontrado && indice <= numClientes - 1) {
            if (this.clientes[indice].equals(cliente)) {
                encontrado = true;
            }
            indice++;
        }
        indice--;
        if (!encontrado) {
            System.out.println("-- Error: Cliente no registrado en la tienda");
        }
        return encontrado;
    }
}
