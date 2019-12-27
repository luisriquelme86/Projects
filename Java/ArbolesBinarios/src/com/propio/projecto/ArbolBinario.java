package com.propio.projecto;

public class ArbolBinario {

    public static void main(String[] args) {
        // Arbol binario de busqueda ABB
        // inserto los siguientes 7 numeros -> 5 3 7 2 4 8 9
        Nodo nodo = null;
        insertar(nodo, 5);
        insertar(nodo, 3);
        insertar(nodo, 7);
        insertar(nodo, 2);
        insertar(nodo, 4);
        insertar(nodo, 8);
        insertar(nodo, 9);
        recorrerPreorden(nodo);
    }

    public static void insertar(Nodo n, int valor) {
        if (n == null) {
            n = new Nodo();
            n.valor = valor;
            System.out.println("valor nodo es " + n.valor);
            n.nodoIzquierdo = null;
            n.nodoDerecho = null;
        }
        else {
            if (valor < n.valor) {
                insertar(n.nodoIzquierdo, valor);
            }
            else if (valor > n.valor) {
                insertar(n.nodoDerecho, valor);
            }
        }
    }

    public static void recorrerPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.println("preorden " + nodo.valor);
            recorrerPreorden(nodo.nodoIzquierdo);
            recorrerPreorden(nodo.nodoDerecho);
        }
    }

    public static void borrarArbol(Nodo nodo) {
        if (nodo != null) {
            borrarArbol(nodo.nodoIzquierdo);
            nodo.nodoIzquierdo = null;
            borrarArbol(nodo.nodoDerecho);
            nodo.nodoDerecho = null;
        }
    }
}

class Nodo {
    public int valor;
    public Nodo nodoIzquierdo = null;
    public Nodo nodoDerecho = null;

    public Nodo() {
    }
}

/*
 * Este es el primer intento de crear un arbol binario usando la logica de pseudocodigo. Lamentablemente, esto asi como esta no funciona por como se pasan las referencias
 * en java.
 * // TODO: JAVA PASAJE POR VALOR Y POR REFERENCIA: En java no existe el pasaje por referencia, solo por valor, incluso con los objetos. Es por eso que esto no funciona, si bien la logica es impecable
 * Es recomendable hacer los dibujos del stack para comprender todo correctamente y entender porque no funciona este ejemplo (aqui lo q sucede es q jamas se actualiza el nodo, no guarda informacion)
 *
 *
 *  if (nodo != null) {
 *      borrarArbol(nodo.nodoIzquierdo);
 *      Nodo temporal = nodo.nodoDerecho;
 *      nodo = null;
 *      borrarArbol(temporal);
 *  }
 *
 *  o asi
 *
 *  if (nodo != null) {
 *      borrarArbol(nodo.nodoIzquierdo);
 *      borrarArbol(nodo.nodoDerecho);
 *      nodo = null;
 *  }
 *
 * */


/*
*       |-----------|               |-----------|
*       | nodo      |  ---------->  | new Nodo()|
*       |           |               |           |
*       |-----------|               |-----------|
* Cuando hago new Nodo(), lo que hago es reservar un espacio en la memoria y asignarselo a una variable llamada nodo, que tambien esta en memoria
* En el caso de asignarle null, dicha variable no tendra asignada o apuntara a nada
* Ahora bien, si le paso ese nodo a una funcion, le paso UNA COPIA de la direccion de memoria, no el puntero o direccion en si de la variable
* Entonces, dentro del ambito de la funcion, esa copia de la direccion de variable apunta a el espacio que reserve con new dentro de la funcion insertar.
* Cuando salgo de la funcion, la direccion fisica real, de Nodo, esta inmutable. Sigue valiendo null. Yo asigne una direccion de memoria en la funcion a una copia
* y esa copia ya no existe mas asi que la referencia se perdio
*
*
*
*
*
*        |-----------|               |-----------|
 *       | nodo      |  ---------->  | new Nodo()|
 *       |           |               |           |
 *       |-----------|               |-----------|
 *          |
 *          |
 *          |                                         function insertar(Nodo n, int valor)
 *          v
 *       |-----------|               |-----------|
 *       | n         |  ---------->  | new Nodo()|
 *       |           |               |           |
 *       |-----------|               |-----------|
*
*        Donde 'n' es una copia de la direccion de nodo. Si la variable 'nodo' le asigno una direccion de memoria y dentro de una funcion le asigno otra, el cambio
*        no se produce.
*        Aun no se como solucionar este caso especifico, pero se me ocurre como hacerlo para el caso del arbol
*
* */

/*
*   Con respecto a la funcion de borrar arbol, originalmente la hice mal. Me falta comprender mejor recursividad. La verdadera version seria la siguiente
* */