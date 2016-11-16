package org.deniszm.tamagotchi.app;

import org.deniszm.tamagotchi.model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Game menu interface.
 * Created by Denis on 10.11.2016.
 */
class TamagotchiMenu {

    Pet selectPet() {
        System.out.println("Выберите питомца:");
        System.out.println("1 - Котик");
        System.out.println("2 - Песик");
        System.out.println("3 - Ежик");

        switch (getUserInput(3)) {
            case 1:
                return new Cat("Котик");
            case 2:
                return new Dog("Песик");
            case 3:
                return new Hedgehog("Ежик");
        }
        return null;
    }

    void selectAction(Pet myPet) {
        System.out.printf("\nЧем займемся? (Сил осталось: %s%%)\n",
                myPet.getEnergy());
        System.out.println("1 - Играть");
        System.out.println("2 - Есть");
        System.out.println("3 - Спать");

        switch (getUserInput(3)) {
            case 1:
                System.out.printf("\n~ %s %s ~\n", myPet.getName(),  myPet.play());
                break;
            case 2:
                try {
                    myPet.eat();
                    System.out.println("\n~ Ням-Ням ~");
                } catch (TamagotchiException e) {
                    System.out.println(e);
                }
                break;
            case 3:
                try {
                    myPet.sleep();
                    drawSleep();
                } catch (TamagotchiException e) {
                    System.out.println(e);
                }
                break;
        }
    }

    private int getUserInput(int amount) {
        int n;
        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                n = in.nextInt();
                if (n <= 0 || n > amount) {
                    sayOutOfRangeError(amount);
                } else {
                    return n;
                }
            } catch (InputMismatchException ex) {
                sayOutOfRangeError(amount);
            }
        }
    }

    private void sayOutOfRangeError(int r) {
        System.out.printf("Пожалуйста введите число от 1 до %s\n",
                + r);
    }

    private void drawSleep() {
        try {
            System.out.println();
            for (int i = 1; i <= 3; i++, Thread.sleep(1000)) {
                System.out.print("zZ... ");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }
}
