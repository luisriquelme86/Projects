package com.development.java;

/*
* - Objetivo:
* . Comprobar si el numero de caracteres de apertura y cierre coinciden
* */

import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<String> stack1 = new Stack();
        String goodString = "Esta cadena tiene todos los caracteres cerrados, asi ()(){}[][({})]";
        fillStack(stack1, goodString);
        openingAndClosingMarksMatch(stack1);

        // otra pila
        Stack<String> stack2 = new Stack();
        String badString = "En esta cadena los caracteres no cierran correctamente, asi ((){}[][)";
        fillStack(stack2, badString);
        openingAndClosingMarksMatch(stack2);

        // otra pila mas, que es falso que esta bien pero la app dice que si
        Stack<String> stack3 = new Stack();
        badString = "En esta cadena los caracteres no cierran correctamente, asi ()()[]}{()";
        fillStack(stack2, badString);
        openingAndClosingMarksMatch(stack2);
    }

    public static void fillStack(Stack<String> stack, String term) {
        boolean filledStack = false;
        int index = 0;
        while (!filledStack) {
            // mientras la pila no este llena de la cadena, rellenar la misma con todos sus caracteres
            // notar que los caracteres en la pila quedan en orden inverso al original
            stack.push(String.valueOf(term.charAt(index)));
            index++;
            if (stack.size() == term.length()) {
                filledStack = true;
            }
        }
    }

    public static void openingAndClosingMarksMatch(Stack<String> stack) {
        int openingParenthesis = 0;
        int closingParenthesis = 0;
        int openingBrackets = 0;
        int closingBrackets = 0;
        int openingCurlyBrackets = 0;
        int closingCurlyBrackets = 0;
        if (!stack.peek().equals("(") || !stack.peek().equals("[") || !stack.peek().equals("{")) {
            while (!stack.isEmpty()) {
                // El orden de pop es inverso al de entrada, asi que no puede pasar que lo ultimo de todo sea un caracter de abertura
                // En la punta esta lo ultimo, y si lo ultim o es un caracter de apertura ya arrancamos mal
                // Eso puede ser un if stack.pop().equals("(") && closingParenthesis > 0 o un peek
                String character = stack.pop();
                if (character.equals("(")) {
                    openingParenthesis++;
                }
                if (character.equals(")")) {
                    closingParenthesis++;
                }
                if (character.equals("[")) {
                    openingBrackets++;
                }
                if (character.equals("]")) {
                    closingBrackets++;
                }
                if (character.equals("{")) {
                    openingCurlyBrackets++;
                }
                if (character.equals("}")) {
                    closingCurlyBrackets++;
                }
            }
            if (openingParenthesis != closingParenthesis) {
                System.out.println("El numero de parentesis de apertura y cierre de la cadena no coincide");
            } else if (openingBrackets != closingBrackets) {
                System.out.println("El numero de corchetes de apertura y cierre de la cadena no coincide");
            } else if (openingCurlyBrackets != closingCurlyBrackets) {
                System.out.println("El numero de llaves de apertura y cierre de la cadena no coincide");
            } else {
                System.out.println("La cadena tiene todos sus caracteres de apertura y cierre en orden");
            }
        }
    }

}

/*
* Problemas de esta aplicacion:
* . No tiene en cuenta la eficiencia
* . Copia todo a una estructura en lugar de analizar o mover a otra estructura solo lo necesario
* . No tiene en cuenta el orden
* */