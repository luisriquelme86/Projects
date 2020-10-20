package com.application.interfazcanto;

public class Canario implements Cantante {

    @Override
    public void cantar() {
        System.out.println("El canario canta");
        System.out.println("Pio Pio Pio!");
    }
}
