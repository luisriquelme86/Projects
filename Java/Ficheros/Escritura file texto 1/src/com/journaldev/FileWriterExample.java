package com.journaldev;
import java.io.FileWriter;

public class FileWriterExample {

    public static void main(String[] args) {

        // Se crean dos writer diferentes porque se pretende escribir en dos archivos diferentes
        // Cada writer esta asociado a un archivo
        FileWriter fileWriter1;
        FileWriter fileWriter2;
        try {
            // En este modo siempre lo crea y lo pisa si esta creado
            fileWriter1 = new FileWriter("file1.txt");
            fileWriter1.write("This is a FileWriter example");

            // Se escribira esto tantas veces como se escriba el archiva, porque hay un append que escriba al final
            fileWriter2 = new FileWriter("file2.txt", true);
            fileWriter2.write("Nuevo dato" + "\n");

            // El close es necesario. Sin close, no se graba nada. Antes del close se invoca primero al flush. El flush se encarga de escribir en el archivo destino.
            // El close flushea y cierre, porque sin cierre a veces se producen errores
            fileWriter1.close();
            fileWriter2.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}