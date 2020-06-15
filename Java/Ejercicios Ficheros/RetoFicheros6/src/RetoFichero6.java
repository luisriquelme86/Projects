import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/*
* Objetivo:
* Un programa que pida al usuario una letra (por ejemplo, "a") y vuelque las líneas del fichero "nombres2.txt" que comienzan por esa letra a otro fichero llamado "nombres3.txt".
* */

public class RetoFichero6 {

    public static void main(String[] args) {


        // Open two files, nombres2.txt and nombres3.txt. They are supposed to be created
        File file1 = new File("nombres2.txt");
        File file2 = new File("nombres3.txt");
        if (file2.exists()) {
            file2.delete();
            try {
                file2.createNewFile();
            }
            catch (Exception e) {
                System.out.println("An exception has ocurred, nombres3.txt has a problem to open or something");
            }
        }
        Scanner scanner = new Scanner(System.in);

        // It is supposed to be a only letter, no more evaluations
        String searchTerm = scanner.next();

        // Writer for nombre3.txt -> file2
        try {
            FileWriter fileWriter = new FileWriter(file2);
            // Read file nombre2.txt -> file1
            try {
                Scanner file1Reader = new Scanner(file1);
                while(file1Reader.hasNextLine()) {
                    String line = file1Reader.nextLine();
                    if (wordStartsWithLetter(line, searchTerm)) {
                        fileWriter.write(line + "\n");
                    }
                }
                file1Reader.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("An exception has ocurred, nombres2.txt was not founded");
            }
            fileWriter.close();
        }
        catch (IOException e) {
            System.out.println("An exception has ocurred, nombres3.txt was not found");
        }

    }

    public static boolean wordStartsWithLetter(String word, String letter) {
        return word.substring(0, 1).equals(letter);
    }

}

/*
* Se suponen creados de antemano los archivos nombres2.txt y nombres3.txt
* Idea general
* La idea seria abrir los dos archivos nada mas comenzar, de uno se lee, al otro se escribe
*
*
*
*
* */