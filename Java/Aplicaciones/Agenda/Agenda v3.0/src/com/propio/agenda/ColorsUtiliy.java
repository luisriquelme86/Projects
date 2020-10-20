package com.propio.agenda;

public class ColorsUtiliy {
    // En lugar de una clase tambien podria ser un enum o llamarse clase Log
    // Son todas constantes
    // Son estaticas asi que no hace falta instanciar la clase
    // Son publicas, porque quiero poder accederlas desde fuera de clase (lo que no quiere decir que se pueda hacer get y set, solo obtenerlas)
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE= "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
}
