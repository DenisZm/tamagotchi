package org.deniszm.tamagotchi.consoleui;

import org.deniszm.tamagotchi.app.PetsList;
import org.deniszm.tamagotchi.consoleui.mainmenu.*;
import org.deniszm.tamagotchi.consoleui.petmenu.*;
import org.deniszm.tamagotchi.exception.TamagotchiException;
import org.deniszm.tamagotchi.model.Pet;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Denis on 10.12.2016.
 */
public class ConsoleMenu {
    private PetsList list;
    private Pet current;

    private MenuAction[] startActions = {
            new NewGameAction(),
            new LoadGameAction(),
    };

    private MenuAction[] petActions = {
            new PlayAction(),
            new EatAction(),
            new SleepAction(),
    };

    private MenuAction[] mainActions = {
            new SelectPetAction(),
            new LoadGameAction(),
            new SaveGameAction(),
            new SaveExitGameAction()
    };

    public ConsoleMenu(PetsList list) {
        this.list = list;
    }

    public void startMenu() throws TamagotchiException {
        System.out.println("~ Тамагочи v2 ~\n" +
                           "===============");
        drawMenu(startActions);
        System.out.printf("[1 - %d]: ", startActions.length);
        int option = getUserInput(1, startActions.length);
        startActions[option - 1].doAction(list);
    }

    public void mainMenu() throws TamagotchiException {
        System.out.println("\nГлавное меню:");
        drawMenu(mainActions);
        System.out.println(mainActions.length + 1 + " - Вернутся");
        System.out.printf("[1 - %d]: ", mainActions.length + 1);
        int option = getUserInput(1, mainActions.length + 1);
        if (option == mainActions.length + 1) {
            return;
        } else {
            mainActions[option - 1].doAction(list);
        }
    }

    public void petMenu() throws TamagotchiException {
        if (current.getEnergy() < 0 ) {
            System.out.printf("\n%s заболел и его увезла скорая.....\n", current.getName());
            list.delete(current);
            selectMenu();
        }
        System.out.printf("\nЧем займемся (%s - энергия: %d%%):%n",
                current.getName(),
                current.getEnergy());
        drawMenu(petActions);
        System.out.println(petActions.length + 1 + " - Главное меню");
        System.out.printf("[1 - %d]: ", petActions.length + 1);
        int option = getUserInput(1, petActions.length + 1);
        if (option <= petActions.length) {
            petActions[option - 1].doAction(current);
        } else {
            mainMenu();
        }
    }

    public void selectMenu() throws TamagotchiException {
        MenuAction action = new SelectPetAction();
        action.doAction(list);
    }

    private void drawMenu(MenuAction[] actions) {
        for (int i = 0; i < actions.length; i++) {
            MenuAction action = actions[i];
            System.out.printf("%d - %s%n", i + 1, action.getTitle());
        }
    }

    private int getUserInput(int from, int to) {
        int n;
        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                n = in.nextInt();
                if (n < from || n > to) {
                    sayOutOfRangeError(from, to);
                } else {
                    return n;
                }
            } catch (InputMismatchException ex) {
                sayOutOfRangeError(from, to);
            }
        }
    }

    private void sayOutOfRangeError(int from, int to) {
        System.out.printf("Пожалуйста введите число от %s до %s\n",
                from, to);
    }

    private class SelectPetAction extends MainMenuAction {
        public SelectPetAction() {
            super("Выбрать питомца");
        }

        public void doAction(PetsList list) {
            if (list.getSize() < 1) {
                System.out.println("\n... Больше не с кем играть ... :(");
                System.out.println("Игра окончена");
                System.exit(0);
            }
            System.out.println("\nВыберите питомца:");
            for (int i = 0; i < list.getSize(); i++) {
                System.out.printf("%d - %s (энергия: %d%%)%n", i + 1,
                        list.get(i).getName(), list.get(i).getEnergy());
            }
            if (list.getSize() > 1) {
                System.out.printf("[1 - %d]: ", list.getSize());
            } else {
                System.out.printf("[1]: ");
            }
            current = list.get(getUserInput(1, list.getSize()) - 1);
            System.out.printf("\n~ Вы выбрали %sа ~\n", current.getName());
        }
    }
}
