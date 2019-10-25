package com.connectors;

import java.util.ArrayList;

public class PigLatinTranslator {
    static String patternWord = "ay";

    static String translate(String term) {
        if (term.equals("")) {
            return "";
        }
        String[] temporal = term.split(" ");
        ArrayList<String> list = new ArrayList<String>();
        for (int index = 0; index < temporal.length; index++) {
            list.add(buildString(temporal[index]));
        }
        return String.join(" ", list);
    }

    static String checkLetterCase(String term1, String term2) {
        boolean term1hasUpperCase = term1.equals(term1.toUpperCase());
        System.out.print("term1hasUpperCase" + term1hasUpperCase);
        System.out.print("term1" + term1);
        System.out.print("term2" + term2);
        System.out.print("term2 upper " + term2.substring(0, 1).toUpperCase());
        return term1hasUpperCase ? (term2.substring(0, 1).toUpperCase()).concat(term2.substring(1)).concat(term1.toLowerCase()) :
               term2.concat(term1);
    }

    static String buildString(String term) {
        String result = checkLetterCase(term.substring(0, 1), term.substring(1));
        return result.concat(patternWord);
    }
}
