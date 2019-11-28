package com.connectors;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatinTranslator {
    static String patternWord = "ay";
    private static String mode = "1";

    static void setMode(String newMode) {
        mode = newMode;
    }

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

    // muy rebuscado, si me fijo bien es lo del ultimo. un termino concatenado al otro... debe haber otra forma, la diferencia
    // es que concatena el primero que puede o no ser mayuscula, lo otro queda igual, y el primero es un solo caracter
    // quizas ese substring(0, index) no es tan amistoso para este caso...

    /* static String reorderTerm(String term) {
        int index = Integer.parseInt(mode);
        String beginTerm = term.substring(0, index);
        String endTerm = term.substring(index);
        boolean beginTermHasUpperCase = beginTerm.equals(beginTerm.toUpperCase());
        return beginTermHasUpperCase ?
                endTerm.substring(0, index).toUpperCase()
                .concat(endTerm.substring(index))
                .concat(beginTerm.toLowerCase()) :
                endTerm.concat(beginTerm);
    } */

    //

    static String reorderTerm(String term) {
        int index = Integer.parseInt(mode);
        String beginTerm = term.substring(0, index); // si es begin y end 0 podria ser empty
        String endTerm = term.substring(index);
        String firstChar = !beginTerm.isEmpty() && beginTerm.equals(beginTerm.toUpperCase()) ? endTerm.substring(0, 1).toUpperCase() : endTerm.substring(0, 1).toLowerCase();
        return firstChar.concat(endTerm.substring(1)).concat(beginTerm.toLowerCase());
    }

    static String extractSymbol(String term) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(term);
        if (matcher.find()) {
            return term.substring(matcher.start(), matcher.end());
        }
        return "";
    }

    static String buildString(String term) {
        String symbol = extractSymbol(term);
        // podemos pensar que es un solo simbolo especial a la vez
        String noSymbolTerm = symbol.isEmpty() ? term : term.replace(symbol, "");
        String defaultExtension = patternWord.concat(symbol);
        // es basicamente un reordenamiento de poner algo en lugar del otro, como un swap
        String resultTerm = reorderTerm(noSymbolTerm);
        return resultTerm.concat(defaultExtension);
    }
}
