package com.jenkov.tutorials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherExample {

    public static void main(String[] args) {
        String text = "Hello, my name is Luis! And yours?";
        // [,!?] un conjunto que puede contener cualquiera de esas
        Pattern pattern = Pattern.compile("[,!?]");

        Matcher matcher = pattern.matcher(text);
        int counter = 0;
        while (matcher.find()) {
            System.out.println("El " + counter +" match esta en la posicion " + matcher.start() + " y es " + text.substring(matcher.start(), matcher.end()));
            counter++;
        }
    }
}
