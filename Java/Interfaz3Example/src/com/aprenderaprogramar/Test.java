package com.aprenderaprogramar;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List <Edificio> edificios = new ArrayList <Edificio> ();
        edificios.add(new Polideportivo("poli1", 30.0, 1));
        edificios.add(new Polideportivo("poli2", 40.0, 2));
        edificios.add(new Polideportivo("poli3", 50.0, 3));
        edificios.add(new EdificioOficinas(5, 45.50));
        edificios.add(new EdificioOficinas(9, 200.56));
        for (Edificio edificio: edificios) {
            System.out.print(edificio.toString() + "\n");
        }
    }
}
