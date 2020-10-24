package com.application.apareomaterias;
import java.io.*;

/*
 * Objetivo:
 * Dados dos archivos llamados fisica.csv y analisis.csv que contienen el numero de legajo, nombre y nota obtenida en el examen de la materia en cuestion de cada alumno,
 * volcar en el archivo nuevo.csv los legajos ordenados de menor a mayor y una de las siguientes leyendas "Rindio Fisica", "Rindio Analisis" o
 * "Rindio Fisica y Analisis"
 */

public class Main {

    private static final String FILE1_LEGEND = "Rindio Fisica";
    private static final String FILE2_LEGEND = "Rindio Analisis";
    private static final String BOTHS_LEGEND = "Rindio Fisica y Analisis";
    private static final String RESULT_HEADER = "Numero de legajo, Leyenda";

    public static void main(String[] args) {

        FileReader fileReader1;
        FileReader fileReader2;
        BufferedReader file1;
        BufferedReader file2;
        FileWriter fileResult;

        try {
            // los separo para que si no existen, salgan por la excepcion
            fileReader1 = new FileReader("fisica.csv");
            fileReader2 = new FileReader("analisis.csv");
            fileResult = new FileWriter("nuevo.csv");

            file1 = new BufferedReader(fileReader1);
            file2 = new BufferedReader(fileReader2);
            // avanzo una linea en los 2 archivos, para omitir los titulos del cvs se presuponen creados y con datos, no hago otras validaciones
            file1.readLine();
            file2.readLine();

            String lineFile1 = file1.readLine();
            String lineFile2 = file2.readLine();

            // en el archivo de resultados escribo la cabecera del archivos -> Numero de legajo, Leyenda
            fileResult.write(RESULT_HEADER + "\n");

            String resultLine;
            int idFile1 = 0;
            int idFile2 = 0;

            // mientras alguno de los dos no haya terminado
            while(lineFile1 != null || lineFile2 != null) {

                if (lineFile1 != null) {
                    idFile1 = getStudentID(lineFile1);
                }
                if (lineFile2 != null) {
                    idFile2 = getStudentID(lineFile2);
                }

                if (lineFile1 == null || idFile2 < idFile1) {
                    resultLine = idFile2 + ", " + FILE2_LEGEND + "\n";
                    lineFile2 = file2.readLine();
                }
                else if (lineFile2 == null || idFile2 > idFile1) {
                    resultLine = idFile1 + ", " + FILE1_LEGEND + "\n";
                    lineFile1 = file1.readLine();
                }
                else {
                    resultLine = idFile2 + ", " + BOTHS_LEGEND + "\n";
                    lineFile1 = file1.readLine();
                    lineFile2 = file2.readLine();
                }
                fileResult.write(resultLine);
            }

            file1.close();
            file2.close();
            fileResult.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found exception: " + e.getStackTrace());
        }
        catch (IOException e) {
            System.out.println("IO exception: " + e.getStackTrace());
        }
    }

    public static int getStudentID(String line) {
        // el parseo consiste en esto. Analizar e intentar transformar un dato de un tipo en otro
        return Integer.parseInt(line.split(",")[0]);
    }
}
