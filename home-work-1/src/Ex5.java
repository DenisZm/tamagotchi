import java.util.Scanner;

/**
 * Codaline Backend Course.
 * HomeWork 1. Exercise 5.
 * Define Odd or Even.
 *
 * Created by Denis on 05.11.2016.
 */
public class Ex5 {
    public static void main(String[] args) {
        int n;
        System.out.print("Enter n: ");
        n = inputInt();
        evenOrOdd(n);
    }

    static int inputInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    static void evenOrOdd(int n) {
        if ((n % 2) == 0) {
            System.out.println(n + " is even");
        } else {
            System.out.println(n + " is odd");
        }
    }
}
