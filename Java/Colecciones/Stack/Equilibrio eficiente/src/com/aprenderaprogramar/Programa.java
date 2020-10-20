package com.aprenderaprogramar;

import java.util.Stack;

public class Programa {

    public static void main(String[] args) {
        String cadenano = "(Cadena no equilibrada en paréntesis(()()()))))";
        String cadenasi = "(Cadena equilibrada en parentesis())";
        System.out.println("Verificación equilibrado en paréntesis para cadenano: ");
        System.out.println(verificaParentesis(cadenano));
        System.out.println("Verificación equilibrado en paréntesis para cadenasi: ");
        System.out.println(verificaParentesis(cadenasi));
    }

    public static boolean verificaParentesis(String cadena) {
        int index = 0;
        Stack<String> pila = new Stack<>();
        while (index < cadena.length()) {
            if (cadena.charAt(index) == '(') {
                pila.push("(");
            }
            else if (cadena.charAt(index) == ')') {
                if (pila.empty()) {
                    pila.push(")");
                    // apilo y rompo el ciclo, asi que tiene un elemento dentro
                    // cuando rompo el ciclo, sale automaticamente del mismo, y al tener un elemento, pila.empty da false
                    break;
                }
                else {
                    pila.pop();
                }
            }
            index++;
        }
        if (pila.empty()) {
            return true;
        }
        else {
            return false;
        }
    }
}
