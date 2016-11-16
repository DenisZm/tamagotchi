/**
 * Codaline Backend Course.
 * HomeWork 1. Exercise 2.
 * Calculate arithmetic mean of array.
 * Generate random array.
 *
 * Created by Denis on 05.11.2016.
 */
public class Ex2 {
    private static int ARRAY_LENGTH = 20;
    private static int START_RAND = 0;
    private static int END_RAND = 100;

    public static void main(String[] args) {
        int[] array = createRandomArray(ARRAY_LENGTH, START_RAND, END_RAND);
        System.out.print("Array: ");
        printArray(array);

        System.out.println("Array average: " + calculateArrayAverage(array));
    }

    static int[] createRandomArray(int size, int start, int end) {
        int range = end - start;
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * range) + start;
        }
        return arr;
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }

    static double calculateArrayAverage(int[] arr) {
        double sum = 0;

        for (int anArr : arr) {
            sum += anArr;
        }
        return sum / arr.length;
    }
}
