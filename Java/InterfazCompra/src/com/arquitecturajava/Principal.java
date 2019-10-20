package com.arquitecturajava;

public class Principal {

    public static void main(String[] args) {

        // Compra compra = new Compra(1000, "tienda");
        // System.out.print(compra.descuento());
        // TODO: el problema que tiene esto es que si agrego mas tipos aparte de tienda u online, tengo que modificar ese metodo descuento
        // eso no esta bien, lo mejor es meter ese comportamiento en una interface y que cada clase implememente su propia forma, que sirva como
        // punto de extensibilidad. que el descuento se delegue en una interfaz
        // al igual que con el ejemplo del telefono, lo mejor es que mas que un valor aparte reciba un objeto para obtener los datos y de ahi en mas
        // implementar el comportamiento (el descuento a partir de la compra)

        // si las especificiaciones cambian y se añaden mas tipos de descuento puede haber problemas

        Compra compra = new Compra(1000);
        System.out.print(compra.descuento(new DescuentoInternet()) + "\n");
        System.out.print(compra.descuento(new DescuentoTienda()));

        // Excelente mini tutorial amigo es realmente buenisimo, pero solo me queda una pequeña duda, el graciosillo este del que hablamos ahora tiene la opcion
        // de escribir en consola o imprimir, y para hacer esto, de todas formas se necesita un IF o un CASE verdad? Para saber que clase llamar cierto?

        // Efectivamente, hace falta el if o case en algún sitio, pero la "gracia" es que ese if está ahora totalmente fuera de nuestro código. Esto
        // permite que nuestro código esté compilado en forma de librería y que podamos usarlo para escribir en pantalla, para imprimir e incluso
        // para escribir en cualquier sitio que se nos ocurra en un futuro ... ¡sin necesidad de recompilar siquiera nuestro código con el algoritmo!.

        // basicamente los if fuera de nuestra clase compra
    }
}
