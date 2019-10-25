package com.connectors;

import java.util.Scanner;

public class PigLatin {

    public static void main(String[] args) {
        String word;
        do {

            System.out.print("Enter a word in order to translate to Pig Latin language: " + "\n");
            Scanner sc = new Scanner(System.in);
            word = sc.nextLine();
            String result = PigLatinTranslator.translate(word);
            System.out.print("Your word translated to Pig Latin is: " + result + "\n");

        } while (!word.equals("quit"));

        // TODO: As a user I can enter the phrase "Hello, world!" and see it translated to Pig Latin "Ellohay, orldway!"
        // TODO: As a user I can enter the phrase "eat apples" and see it translated to Pig Latin "eatay applesay"
        // TODO: As a user I can enter the phrase "dragons strike quickly" and see it translated to Pig latin
        // "agonsdray ikestray icklyquay"

    }
}
