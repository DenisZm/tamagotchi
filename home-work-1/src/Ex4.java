import java.util.Scanner;

/**
 * Codaline Backend Course.
 * HomeWork 1. Exercise 4.
 * Get product price by code.
 *
 * Created by Denis on 05.11.2016.
 */
public class Ex4 {
    public static void main(String[] args) {
        System.out.print("Enter product code: ");
        int code = inputInt();
        double price = getPrice(code);
        if (price == -1) {
            System.out.println("Incorrect code");
        } else {
            System.out.print("Product price is: " + price + "\n");
        }
    }

    static int inputInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    static double getPrice(int code) {
        switch(code) {
            case 3456:  return 23.5;
            case 1234:  return 99.99;
            case 4321:  return 42;
            case 9876:  return 0.98;
            default:    return  -1;
        }
    }
}
