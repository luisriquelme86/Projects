package com.utilidades.colores;

public class ColorPrints {

    public static void main(String[] args) {

        // System es parte de java.lang y por default java.lang y sus metodos y clases ya se cargan al iniciar java, no hace falta un import

        System.out.println("Vamos a probar la consola con colores");
        System.out.println(ColorsUtiliy.ANSI_BLACK  + "Este texto esta en NEGRO");
        System.out.println(ColorsUtiliy.ANSI_RED  + "Este texto esta en ROJO");
        System.out.println(ColorsUtiliy.ANSI_GREEN  + "Este texto esta en VERDE");
        System.out.println(ColorsUtiliy.ANSI_YELLOW  + "Este texto esta en AMARILLO");
        System.out.println(ColorsUtiliy.ANSI_BLUE  + "Este texto esta en AZUL");
        System.out.println(ColorsUtiliy.ANSI_PURPLE  + "Este texto esta en PURPURA");
        System.out.println(ColorsUtiliy.ANSI_CYAN  + "Este texto esta en CYAN");
        System.out.println(ColorsUtiliy.ANSI_WHITE  + "Este texto esta en BLANCO");

    }


}
