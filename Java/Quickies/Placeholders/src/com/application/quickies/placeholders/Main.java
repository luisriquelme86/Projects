package com.application.quickies.placeholders;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String oldPlaceholderText = "<%Whatever%>";
        Map<String, String> newOldPlaceholdersList = new HashMap<>();
        newOldPlaceholdersList.put("<%Whatever%>", "<img class='standard-placeholder placeholder-image' data-placeholder-key='Whatever'/>");
        replacePlaceholders(oldPlaceholderText, newOldPlaceholdersList);
    }

    static String replacePlaceholders(String placeholderText, Map<String, String> placeholdersList) {
        String result = "Placeholder text not found";
        if (placeholdersList.containsKey(placeholderText)) {
            return placeholdersList.get(placeholderText);
        }
        return result;
    }

}
