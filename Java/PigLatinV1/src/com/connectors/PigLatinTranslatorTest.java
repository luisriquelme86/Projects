package com.connectors;

import org.junit.Assert;

class PigLatinTranslatorTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        PigLatinTranslator.setMode("1");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void translateSingleTerm() {

        String term = "hello";
        String result = PigLatinTranslator.translate(term);
        Assert.assertEquals("ellohay", result);
    }

    @org.junit.jupiter.api.Test
    void translateSingleTermBasic() {

        String term = "steve";
        String result = PigLatinTranslator.translate(term);
        Assert.assertEquals("tevesay", result);
    }

    @org.junit.jupiter.api.Test
    void translateCompoundTerm() {

        String term = "hello world";
        String result = PigLatinTranslator.translate(term);
        Assert.assertEquals("ellohay orldway", result);
    }

    @org.junit.jupiter.api.Test
    void translateCompoundTermWithCases() {

        String term = "hello world";
        String result = PigLatinTranslator.translate(term);
        Assert.assertEquals("ellohay orldway", result);

        String anotherTerm = "Hello World";
        String anotherResult = PigLatinTranslator.translate(anotherTerm);
        Assert.assertEquals("Ellohay Orldway", anotherResult);
    }

    @org.junit.jupiter.api.Test
    void translateCompoundTermPunctuationSigns() {

        String term = "Hello, world!";
        String result = PigLatinTranslator.translate(term);
        Assert.assertEquals("Ellohay, orldway!", result);
    }

    @org.junit.jupiter.api.Test
    void translateNewTerm() {

        String term = "eat apples";
        PigLatinTranslator.setMode("0");
        String result = PigLatinTranslator.translate(term);
        Assert.assertEquals("eatay applesay", result);
    }

    @org.junit.jupiter.api.Test
    void translateDragon() {

        String term = "dragons strike quickly";
        PigLatinTranslator.setMode("2");
        String result = PigLatinTranslator.translate(term);
        Assert.assertEquals("agonsdray ikestray icklyquay", result);
    }
}