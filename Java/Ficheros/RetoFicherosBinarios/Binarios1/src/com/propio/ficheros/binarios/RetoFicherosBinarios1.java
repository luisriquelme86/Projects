package com.propio.ficheros.binarios;
import java.io.*;

/*
* - Objetivo:
* . Un programa que copie el contenido del archivo binario project.zip a otro fichero llamado project_copy.zip
* . Dicho de otra forma, copiar el archivo
* */


/*
* Nota: Lamentablemente por mas que lei y lei no puede replicar esto, es decir, hacer copia de un binario byte a byte. El proximo ejercicio es copiando un
*       el tamaño completo
*
* */

/*
* El ejercicio de aqui es muy simple: Dado un archivo, copio byte a byte ese archivo de origen en otro de destino
* */

public class RetoFicherosBinarios1 {

    public static void main(String[] args) {

        // project.zip binary file is created
        // project_copy.zip (it is not the same, is an another zip with this name)
        // InputStream es abstracta, asi que tengo que usar una subclase, como FileInputStream
        File file = new File("project.zip"); // 646 B
        File fileCopy = new File("project_copy.zip"); // 417 B
        // cuidado, tiene que estar creado en la carpeta del proyecto
        if(fileCopy.exists()) {
            fileCopy.delete();
            try {
                fileCopy.createNewFile();
            }
            catch (Exception e) {
                System.out.println("An error has ocurred: File project_copy.zip was not found or there is a security exception");
            }
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(fileCopy);
            // Primero lo mas facil. Leo de a un byte de datos
            try {
                int byteRead;
                System.out.println("Available is: " + fileInputStream.available());
                // si hago fileInputStream.read() != -1 en el while creo que ya perdi 1 byte porque no lo guarde en ninguna parte. No es como el scanner con el has next
                while((byteRead = fileInputStream.read()) != 1) {
                    fileOutputStream.write(byteRead);
                }
            }
            catch (IOException e) {
                System.out.println("An error I/O exception has ocurred during reading of project.zip");
            }
            fileInputStream.close();
            fileOutputStream.close();
        }
        catch (Exception e) {
            System.out.println("An error has ocurred: File project.zip was not found or there is a security exception");
        }

    }
}

/*
* Comentarios y pasos a seguir
* Comentarios
* Inicialmente no sabia muy como "crear" un archivo binario, si bien suponio que podia ser cualquier archivo (imagen, audio, video). Un ejemplo en internet me dio la idea
* de algo sencillo. Un zip que es un texto comprimido en verdad
*
* Teoria
* La parte de ficheros de texto resulto masomenos entendible. La cuestion son los binarios. A groso modo, se puede decir que para manipualr los archivos binarios, debo
* hacerlo no con caracteres (sueltos o en strings) sino en bytes (que al parecer pueden ser de a uno o como un array de un tamaño definido)
*
* Es claro que tengo que usar un reader y un writer de algun tipo, como con los archivos de texto que ya hice anteriormente
* La teoria basica, dice que los streams son "canales" de entrada y/o salida, son una asbtraccion. Permiten obtener datos de una fuente y/o llevar datos a un destino
* independientemente de muchas variables
*
* A groso modo, hay dos clases abstractas de manipulacion de streams que tengo que usar, InputStream y OutStream. Ambas se supone que trabajan con bytes. Si bien
* un .zip es un archivo, no puedo usar las clases llamadas "Reader" ya que al parecer siempre pasan de streams a caracteres. Lo mismo pasa con los "Writer". Si bien son
* FilesXXXReader/Writer son para pasar a caracteres. Yo en estos ejercicios necesito pasar de binarios a binarios. Es el principio y es un poco confuso
*
* */
