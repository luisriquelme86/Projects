package com.application.quickies.placeholders;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void replacePlaceholders() {
        String placeholderText = "<%NoExistentPlaceholderText%>";
        Map<String, String> newOldPlaceholdersList = new HashMap<>();
        newOldPlaceholdersList.put("<%Whatever%>", "<img class='standard-placeholder placeholder-image' data-placeholder-key='Whatever'/>");
        String result = Main.replacePlaceholders(placeholderText, newOldPlaceholdersList);
        assertEquals("Placeholder text not found", result);
    }
}