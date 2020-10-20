import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.joining;

public class Solution {



    // Complete the oddNumbers function below.
    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = l; i <= r; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            if (isOdd(list.get(i))) {
                result.add(i);
            }
        }
        return result;
    }

    static boolean isOdd(int number) {
        int counter = 2;
        boolean odd = true;
        while ((odd) && (counter != number)){
            if (number % counter == 0) {
                odd = false;
                counter++;
            }
        }
        return odd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> res = oddNumbers(l, r);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
