package tamagotchi.app;

import tamagotchi.exception.TamagotchiException;
import tamagotchi.model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Game menu interface.
 * Created by Denis on 10.11.2016.
 */
class TamagotchiMenu {

    private PetsList pets;
    private Pet currentPet;

    public TamagotchiMenu(PetsList pets) {

        this.pets = pets;
    }

    void selectPet() throws TamagotchiException {
        if (pets.getSize() < 1) {
            throw new TamagotchiException("out of pets");
        }
        Pet[] list = this.pets.getList();

        System.out.println("Выберите питомца:");
        for (int i = 0; i < list.length; i++) {
            System.out.printf("%d: %s (энергия: %d%%)%n", i + 1,
                    list[i].getName(), list[i].getEnergy());
        }
        currentPet = this.pets.select(getUserInput(list.length) -1 );
        System.out.printf("\n~ Вы выбрали %sа ~\n", currentPet.getName());
    }

    void selectAction() throws TamagotchiException {
        if (currentPet.getEnergy() <= 0) {
            System.out.printf("%n%s  заболел и его увезла скорая.....%n", currentPet.getName());
            pets.delete(currentPet);
            System.out.println();
            selectPet();
        } else {

            System.out.printf("\nЧем займемся (энергия: %d%%):%n",
                    currentPet.getEnergy());
            System.out.println("1 - Играть");
            System.out.println("2 - Есть");
            System.out.println("3 - Спать");
            System.out.println("4 - Выбрать");

            switch (getUserInput(4)) {
                case 1:
                    System.out.printf("\n~ %s %s ~\n", currentPet.getName(), currentPet.play());
                    break;
                case 2:
                    try {
                        currentPet.eat();
                        System.out.println("\n~ Ням-Ням ~");
                    } catch (TamagotchiException e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try {
                        currentPet.sleep();
                        drawSleep();
                    } catch (TamagotchiException e) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println();
                    selectPet();
                    break;
            }
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
                +r);
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
