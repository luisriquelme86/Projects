package com.development.java;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {


        String exampleTerm1 = "(())))"; // 2 opening marks, 4 closing marks
        String exampleTerm2 = "(()"; // 2 opening marks, 1 closing marks
        String exampleTerm3 = "((()))"; // 3 opening marks, 3 closing marks
        String exampleTerm4 = "(())))"; // 2 opening marks, 4 closing marks
        String exampleTerm5 = "(Cadena no equilibrada en paréntesis(()()()))))";
        matchMarks(exampleTerm1);
        matchMarks(exampleTerm2);
        matchMarks(exampleTerm3);
        matchMarks(exampleTerm4);
        matchMarks(exampleTerm5);
    }

    public static void matchMarks(String term) {
        Stack stack = new Stack<String>();
        int openingMark = 0;
        boolean marksMismatched = false;
        for (int index = 0; index < term.length(); index++) {

            String character = String.valueOf(term.charAt(index));

            if (stack.isEmpty() && character.equals(")")) {
                marksMismatched = true;
                break;
            }
            if (character.equals("(")) {
                openingMark++;
                stack.push(term);
            }
            if (character.equals(")") && openingMark > 0) {
                stack.pop();
            }
        }
        if (marksMismatched || !stack.isEmpty()) {
            System.out.println("Los tags de apertura y cierre no coinciden ya sea en numero o en orden");
        }
        else {
            System.out.println("Los tags de apertura y cierre coinciden!!!");
        }
    }
}

/*
* Lecciones aprendidas:
* . Para saber si los tags de apertura y cierre importa su numero y su orden
* . No es necesario pasar el termino completo a evaluar a la pila, basta con meter en la pila lo necesario
* . El razonamiento para resolver el problema eficientemente es excelente. No hace falta meter todo en el pila, ni siquiera todos los tags para comprobar si todos cierran. La estructura
*   de la pila permite resolver un ejercicio como este de una manera "elegante"
* . Si la pila esta vacia, los tags no coinciden ni en orden ni en numero
* . No hay que meter todos los tags en la pila, solo los necesarios, se mete de a poco
* . La solucion en si es muy elegante. La idea basica es meter solo los tags de apertura, no los de cierre. A medida que los de cierre van apareciendo se van quitando
*   los de apertura de la pila. O sea, resumidamente, se meten y sacan solo tags de apertura, y la condicion para sacar esta dada por los tags de cierre
* . No hace falta en ningun momento meter los tags de cierre
* . Si queda algun elemento en la pila es que esta sobrando un tag de apertura o sea que falta el de cierre. Si la pila esta vacia y aparece un tag de cierre ya esta mal
*   (porque no habria ningun tag de apertura)
* */
