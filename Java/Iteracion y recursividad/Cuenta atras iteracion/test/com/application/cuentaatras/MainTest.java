package com.application.cuentaatras;

import static org.junit.Assert.*;

public class MainTest {

    @org.junit.Test
    public void countDown() {
        int result = Main.countDown(10);
        assertEquals(0, result);
    }
}