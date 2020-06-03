package com.propio.projecto;

/*
* Objetivo: Mejorar el primer arbol binario que hice anteriormente. Ese no andaba porque no conocia bien como se pasan los datos a las funciones,
* si por valor o por referencia. Los valores en java a las funciones siempre se pasan por valor, incluso aunque se trata de objetos. A lo sumo
* se pasa una copia de la referencia
* */

public class ArbolBinario {

    public static void main(String[] args) {
        Nodo raiz = new Nodo(200);
        insertarNodo(raiz, 40);
        insertarNodo(raiz, 400);
        insertarNodo(raiz, 250);
        insertarNodo(raiz, 600);
        insertarNodo(raiz, 5);
        insertarNodo(raiz, 93);
        mostraRaizIzquierdaDerecha(raiz);
        System.out.println(buscar(raiz, 7)); // es false
        System.out.println(buscar(raiz, 700)); // es false
        System.out.println(buscar(raiz, 5)); // es true
        System.out.println(buscar(raiz, 250)); // es true
        // Quiero ver esto -> 200, 40, 93, 400, 2500, 600
    }

    public static boolean buscar(Nodo nodo, int valor) {
        if (nodo != null) {
            if (valor == nodo.valor) {
                return true;
            }
            if (valor < nodo.valor) {
                return buscar(nodo.izquierda, valor);
            }
            if (valor > nodo.valor) {
                return buscar(nodo.derecha, valor);
            }
        }
        return false;
    }
    /*Esta funcion esta comentada porque no sabia como hacer para que devuelva true o false. Lo logre arriba*/
    /* public static void busquedaDeValor(Nodo nodo, int valor) {
        if (nodo != null) {
            if (valor == nodo.valor) {
                System.out.println("Lo encontre al valor");
            }
            if (valor < nodo.valor) {
                busquedaDeValor(nodo.izquierda, valor);
            }
            if (valor > nodo.valor) {
                busquedaDeValor(nodo.derecha, valor);
            }
        }
        if (nodo == null) {
            System.out.println("No esta");
        }
    } */

    public static void insertarNodo(Nodo nodo, int valor) {
        if (nodo != null) {
            if (valor < nodo.valor) {
                insertarNodo(nodo.izquierda, valor);
                if (nodo.izquierda == null) {
                    nodo.izquierda = new Nodo(valor);
                }
            }
            else {
                insertarNodo(nodo.derecha, valor);
                if (nodo.derecha == null) {
                    nodo.derecha = new Nodo(valor);
                }
            }
        }
    }

    public static void mostraRaizIzquierdaDerecha (Nodo raiz) { // le llaman pre order y lo hice muy bien de una
        if (raiz != null) {
            System.out.println("El valor del nodo es " + raiz.valor);
            mostraRaizIzquierdaDerecha(raiz.izquierda);
            mostraRaizIzquierdaDerecha(raiz.derecha);
        }
    }

    public static class Nodo {
        private int valor;
        private Nodo izquierda;
        private Nodo derecha;

        public Nodo(int valor) {
            this.valor = valor;
            this.izquierda = null;
            this.derecha = null;
        }

    }
}

/*
  1) Que tuve en cuenta
  Que Java pasa los valores por valor incluso de lo que parece que se pasa por referencia, por ejemplo un Nodo. Por eso,
  creo un nodo al que le pongo un nombre raiz, con un valor, y como ya tiene un valor, ahi comienzo a insertar
  Esta idea la tome prestada. Pero lo hago de un forma simple, y no creo una clase arbol y una clase nodo juntas y opero
  (normalmente se hace un clase arbol binario y se declara la raiz). Es mas simple, una funcion que inicia, declara una raiz
   y comienza a insertar mas nodos a partir de una raiz
   La idea de hacer test es muy buena. Pareciera que necesito tener clases "limpias" de nodo y arbol para poder armar un buen test

  2) Mas a tener en cuenta
  En cada metodo de insercion yo me abstraigo. Paso el nodo "raiz"
  Es solo un nombre, pero la idea es que en cada "insertar" paso el mismo nodo, no estoy
  pasando el lado izquierdo o derecho y un valor, tiene que ser automatico. Es la idea de la programacion. Se sigue siempre
  la misma cantidad de pasos

  3) Como pense la insercion
  Inicialmente fracase. Es bueno recordar que la insercion en una arbol binario tambien es recursiva. Tuve problemas incluso recursivamente, siempre se quedaban
  los dos ultimos nodos izquierdo y derecho que ponia
  Despues pense en una insercion solo en el lado izquierdo
  Use un pseudocodigo como este

    -- Ciclo
    . Leo el nodo y el nuevo valor (o sea si son o no nulos)
    . Comparo el nuevo con el valor del nodo
	    Si el nuevo es menor
		    Comienzo otra vez, pero paso el nodo izquierdo del nodo actual
    -- Ciclo

    . Aca arriba fracase... No se como continuar, me falta algo que corte y algo que ademas ponga el nuevo nodo

. Fracase al principio y por medio de dibujos en la insercion los resolvi. Mi metodo no me convencio mucho, pero funciona. Fracase porque en parte
  olvide el concepto de recursividad. Por suerte, haciendo dibujos de un pila que se mueve a la izquierda (empece con valores menores) y una tablita
  de ayuda (previo un debug )pude razonar que mi metodo siempre dejaba valores nuevos como los ultimos
. Con respecto a lo anterior, con ayuda de dibujos se puede ver claramente como la recursividad vuelve al caso anterior o pila anterior y
  sigue ejecutandose. Con el ejemplo del "ciclo de arriba" no pude solo, me faltaban los cortes y los nuevos, pero reduciendo solo al caso
  del menor y con dibujos se pudo (y comprobacion de internet q lo mio no estaba tan mal)

* */