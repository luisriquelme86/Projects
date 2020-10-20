package com.ficheros.retosficherosbinarios;
import java.io.*;

/*
* - Objetivo:
. Un programa que copie el contenido del archivo binario project.zip a otro fichero llamado project_copy.zip usando buffers
. Dicho de otra forma, copiar el archivo
* */


public class FicherosConBuffer {
    private static int DEFAULT_BUFFER_SIZE = 8192;

    public static void main(String[] args) {


        File fileOrigin = new File("project.zip");
        File fileDestination = new File("project_copy.zip");
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        try {
            bin = new BufferedInputStream(new FileInputStream(fileOrigin));
            bout = new BufferedOutputStream(new FileOutputStream(fileDestination));
            // BufferedInputStream hereda de FilterInputStream
            // DEFAULT_BUFFER_SIZE es privado
            // BufferedInputStream.DEFAULT_BUFFER_SIZE;

            // Importantisima la logica de abajo: Dice que read lee (o sea, lee y almacena) en la variable la cantidad de bytes indicados por el lenght de esa variable
            // y lo guarda en la variable
            /*
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int bytesRead;
            while((bytesRead = bin.read(buffer)) != -1) {
                bout.write(buffer);
            }*/

            // Lo de arriba no sirve. Porque? Hay que leer la documentacion de BufferedInputStream
            // A BufferedInputStream adds functionality to another input stream-namely, the ability to buffer the input and to support the mark and reset methods.
            // When the BufferedInputStream is created, an internal buffer array is created. As bytes from the stream are read or skipped, the internal
            // buffer is refilled as necessary from the contained input stream, many bytes at a time.
            // Entonces, debo usar read y no hacer eso de arriba
            int bytesRead;
            // cuidado, poner -1 y no 1
            while((bytesRead = bin.read()) != -1) {
                bout.write(bytesRead);
            }

            // tengo que ver en la consola el mensaje de
            // "Process finished with exit" para saber que no es un loop infinito

            // Vale la pena leer esto
            // https://www.informit.com/articles/article.aspx?p=26067

        }
        catch (FileNotFoundException e) {
        }
        catch(IOException e) {
        }
        finally {
            // si no hago los close, el archivo copiado queda en 0
            // Dos cosas importantes. Es importantisimo cerrar (con close) los streams
            // Lo mejor es cerrar el stream wrapper (en este caso el wrapper es la capa superior o sea el buffer)
            // Al llamar a close se llama a flush tambien
            // El no hacerlo, puede traer problemas como a mi. Y ademas es una buena practica porque sino son muy comunes los
            // "resource leak" y con esto se previene
            if (bin != null) {
                try {
                    bin.close();
                }
                catch (IOException e) {

                }
            }
            if (bout != null) {
                try {
                    bout.close();
                }
                catch (IOException e) {

                }
            }
        }
    }
}

/*
* Primero, algunas cuentas -> 1024 Bytes -> 1 KiloByte
* Como conocer el tamaño del buffer que se maneja? A veces en la documentacion de la api no aparece. Sin embargo, se puede consultar en el mismo IDE presionando y entrando
* Dice  private static int DEFAULT_BUFFER_SIZE = 8192;
* O sea 1024*8 = 8192, o sea, copia de a 8KB y rellena el buffer de lo mismo
* */