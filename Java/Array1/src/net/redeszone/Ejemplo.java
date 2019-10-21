package net.redeszone;

public class Ejemplo {

    public static void main(String[] args) {

        int[] array = {45, 99, 100, 10, 21, 45, 99, 65, 81, 5, 66, 33, 25, 78, 90};

        System.out.print("Voy a buscar el menor y el mayor del array \n");
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.print("menor es " + min + " y el mayor es " + max);
    }
}
