package com.application.notas;

/*
 * Objetivo
 * Dados dos archivos llamados alumnos.csv (padron, apellido, nombre, carrera) y notas.csv (padron, materia, nota) se pide mostrar por pantalla y volcar en un archivo llamado
 * nuevo.csv todas las notas que corresponden a cada uno de los alumnos
 * Todos los archivos estan ordenados por numeros de legajo de menor a mayor
 *
 */

import java.io.*;

public class Main {

    private static String NEW_FILE_HEADER = "padron, materia, nota";

    public static void main(String[] args) {

        try {
            FileReader fr1 = new FileReader("alumnos.csv");
            FileReader fr2 = new FileReader("notas.csv");
            FileWriter newFile = new FileWriter("nuevo.csv");

            BufferedReader masterFile = new BufferedReader(fr1);
            BufferedReader slaveFile = new BufferedReader(fr2);

            // salto las cabeceras de los archivos
            masterFile.readLine();
            slaveFile.readLine();

            // escribo en el nuevo archivo las cabeceras
            System.out.println(NEW_FILE_HEADER);
            newFile.write(NEW_FILE_HEADER + "\n");

            // leo las primeras lineas
            String masterLine = masterFile.readLine();
            String slaveLine = slaveFile.readLine();

            // declaro variables del ciclo
            String masterResult;
            String slaveResult;
            String[] masterData;
            String[] slaveData;
            int masterID;
            int slaveID;

            while (masterLine != null) {

                masterData = getArrayData(masterLine);
                slaveData = getArrayData(slaveLine);

                masterID = Integer.parseInt(masterData[0]);
                slaveID = Integer.parseInt(slaveData[0]);
                masterResult = masterID + ", " + masterData[1] + ", " + masterData[2];

                // write in result file master data
                System.out.println(masterResult);
                newFile.write(masterResult + "\n");

                while (slaveLine != null && masterID == slaveID) {
                    slaveResult = slaveData[1] + ", " + slaveData[2];
                    System.out.println(slaveResult);
                    newFile.write(slaveResult + "\n");
                    slaveLine = slaveFile.readLine();
                    if (slaveLine != null) {
                        slaveData = getArrayData(slaveLine);
                        slaveID = Integer.parseInt(slaveData[0]);
                    }
                }
                masterLine = masterFile.readLine();
            }
            masterFile.close();
            slaveFile.close();
            newFile.close();
            fr1.close();
            fr2.close();
            newFile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found exception: " + e.getStackTrace());
        }
        catch (IOException e) {
            System.out.println("IOException: " + e.getStackTrace());
        }

    }

    public static String[] getArrayData(String line) {
        return line.split(", ");
    }
}
