import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {
    public static void main(String[] args)throws IOException {
        /*BufferedReader br;
        InputStreamReader isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        System.out.print("Enter a character: ");
        char i;
        i = (char) isr.read();
        System.out.print("You entered a character: " + i);

        // reading a string from the keyboard
        System.out.print("Enter a string: ");
        String st;
        st = br.readLine();
        System.out.print(st);*/

        /* The “System.in” represents the keyboard. To read data from keyboard it should be connected to “InputStreamReader”.
           From the “InputStreamReader” it reads data from the keyboard and sends the data to the “BufferedReader”.
           From the “BufferedReader” it reads data from InputStreamReader and stores data in buffer.
           It has got methods so that data can be easily accessed. */

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.print("Enter your age: ");
        Integer age = Integer.parseInt(br.readLine());
        System.out.print("Enter your name: ");
        String name = br.readLine();
        System.out.print("My name is " + name + " and I am " + age);
    }
}
