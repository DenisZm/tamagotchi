import java.util.Scanner;

/**
 * Codaline Backend Course.
 * HomeWork 1. Exercise 3.
 * Calculate n!
 *
 * Created by Denis on 05.11.2016.
 */
public class Ex3 {
    public static void main(String[] args) {
        int n = 0;
        boolean repeatFlag = true;

        while (repeatFlag) {
            System.out.print("Enter n: ");
            n = inputInt();
            if (n < 0) {
                System.out.println("n must be positive");
            } else {
                repeatFlag = false;
            }
        }

        System.out.println("n! = " + factorial(n));
    }

    static int inputInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    static long factorial(int n) {
        if (n == 0) {
            return 1;
        }

        long r = 1;
        for (int i = 2; i <= n; i++) {
            r *= i;
        }
        return r;
    }

//    public static int factorial(int n)
//    {
//        return (n > 0) ? n * factorial(n - 1): 1;
//    }
}
