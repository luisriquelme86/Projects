package com.connectors;

import org.junit.Assert;

class PigLatinTranslatorTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
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
        String anotherResult = PigLatinTranslator.translate(term);
        Assert.assertEquals("Ellohay Orldway", anotherResult);
    }
}