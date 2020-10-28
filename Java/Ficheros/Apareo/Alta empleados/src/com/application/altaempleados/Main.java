package com.application.altaempleados;

/*
 * Objetivo
 * Dado dos archivos, maestro.csv y novedades.csv, con los siguientes registros, ordenados por empleado
 * seccion, empleado, nombre y apellido, cargo, sueldo basico
 *
 * Se pide actualizar el archivo maestro.csv con el de novedades, generando un nuevo archivo maestro igual al original. Al final del proceso el archivo original
 * debera ser eliminado. El archivo de novedades es un archivo de altas
 *
 * Hacer un apareo entre los dos archivos, incorporando las altas. Contar e imprimir "ALTA ERRONEA" cuando el registro de alta ya existe en el archivo
 * Informar por pantalla con el mismo formato de "seccion, empleado, nombre y apellido, cargo, sueldo basico" el alta erronea. Tambien las altas realizadas
 * y las erroneas con el siguiente formato
 * Total de altas realizadas: XXXX Erroneas: XXX
 *
 * Para el ejercicio en cuestion, y para replicarlo correctamente, no borrar el maestro original, sino llamarlo viejo_maestro.csv para replicar el mismo ejercicios las veces que sea
 * necesario, pero si hacer lo necesario para hacer los renombres y borrados correctos
 *
 */


import java.io.*;

public class Main {

    private static final String COMMON_FILE_HEADER = "seccion, empleado, nombre y apellido, cargo, sueldo basico";
    private static final String UPDATE_ERROR_MESSAGE = "ALTA ERRONEA";
    private static final String TOTAL_UPDATES_LEGEND = "Total de altas realizadas";
    private static final String TOTAL_ERRORS_LEGEND = "Erroneas";

    public static void main(String[] args) {

        try {

            FileReader fr1 = new FileReader("maestro.csv");
            FileReader fr2 = new FileReader("novedades.csv");
            FileWriter newMasterFile = new FileWriter("nuevo_maestro.csv");
            BufferedReader masterFile = new BufferedReader(fr1);
            BufferedReader newsFile = new BufferedReader(fr2);

            newMasterFile.write(COMMON_FILE_HEADER + "\n");
            masterFile.readLine();
            newsFile.readLine();

            String masterRow = masterFile.readLine();
            String newsRow = newsFile.readLine();

            String[] masterData;
            String[] newsData;
            int updateErrors = 0;
            int updatesAdded = 0;

            while(newsRow != null) {
                newsData = getRowData(newsRow);
                while(masterRow != null) {
                    masterData = getRowData(masterRow);
                    if (Integer.parseInt(newsData[1].trim()) == Integer.parseInt(masterData[1].trim())) {
                        // si son iguales genero reporte
                        System.out.println(UPDATE_ERROR_MESSAGE);
                        System.out.println(COMMON_FILE_HEADER);
                        System.out.println(newsData[0] + "," + newsData[1] + "," + newsData[2] + ","+ newsData[3] + "," + newsData[4]);
                        updateErrors++;
                        // y avanzo una posicion en novedades
                        newsRow = newsFile.readLine();
                        newsData = getRowData(newsRow);
                    }
                    // y escribo en el nuevo maestro lo del viejo maestro, y avanzo
                    newMasterFile.write(masterData[0] + "," + masterData[1] + "," + masterData[2] + "," + masterData[3] + "," + masterData[4] + "\n");
                    masterRow = masterFile.readLine();
                }
                // si termino de recorrer el maestro, como los archivos estan ordenados por clave copio el resto de novedades en el nuevo maestro
                newMasterFile.write(newsData[0] + "," + newsData[1] + "," + newsData[2] + "," + newsData[3] + "," + newsData[4] + "\n");
                newsRow = newsFile.readLine();
                updatesAdded++;
            }
            System.out.println(TOTAL_UPDATES_LEGEND + ": " + updatesAdded);
            System.out.println(TOTAL_ERRORS_LEGEND + ": " + updateErrors);

            // cierro para evitar problemas de escritura
            masterFile.close();
            newsFile.close();
            fr1.close();
            fr2.close();
            newMasterFile.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace());
        }
        catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static String[] getRowData(String row) {
        return row.split(",");
    }
}