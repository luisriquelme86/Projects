package com.propio.retoficheros;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
/*
* - Objetivo:
. Un programa que pida al usuario una letra (por ejemplo, "a") y muestre en las líneas del fichero "nombres2.txt" que comienzan por esa letra.

* */

public class RetoFichero5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scannerFile;
        // Try with letter 'p'
        if (scanner.hasNext()) {
            String letter = scanner.next();
            System.out.println("Letter is " + letter);
            File file = new File("nombres2.txt");
            try {
                scannerFile = new Scanner(file);
                while(scannerFile.hasNextLine()) {
                    String currentWord = scannerFile.nextLine();
                    if (stringStartsWithLetter(currentWord, letter)) {
                        System.out.println(currentWord);
                    }
                }
                scannerFile.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("An exception was ocurred: File not found");
            }
        }
        scanner.close();
    }

    public static boolean stringStartsWithLetter(String word, String letter) {
        return word.substring(0,1).equals(letter);
    }
}


/*
* Pasos
* Necesito que dado 1 conjunto de palabras (digamos, 5) saber si comienzan con una letra X
* Mas alla de un pseudocogido, necesito saber como trata Java los strings, caracteres, y la mejor forma de trabajarlos
* Paso todo a String y opero con substring, una funcion muy comun en cualquier lenguaje
* */