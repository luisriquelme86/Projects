package com.application.interfazedificios;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Edificio> edificios = new ArrayList<>();
        edificios.add(new Polideportivo("polideportivo 1", 100));
        edificios.add(new Polideportivo("polideportivo 2", 200));
        edificios.add(new Polideportivo("polideportivo 3", 300));
        edificios.add(new EdificioOficinas(50, 7000));
        edificios.add(new EdificioOficinas(10, 2000));

        for (Edificio edificio: edificios) {
            System.out.println(edificio.toString());
        }
        System.out.println("");
    }
}
