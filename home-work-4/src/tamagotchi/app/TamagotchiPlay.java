package tamagotchi.app;

import tamagotchi.exception.TamagotchiException;

/**
 * Play game.
 * Created by Denis on 10.11.2016.
 */
public class TamagotchiPlay {
    public static void main(String[] args) {
        PetsList pets = new PetsList();
        TamagotchiMenu menu = new TamagotchiMenu(pets);

        try {
            menu.selectPet();
        } catch (TamagotchiException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                menu.selectAction();
            } catch (TamagotchiException e) {
                System.out.println("Больше не с кем играть... :(");
                System.out.println("~ GAME OVER ~");
                break;
            }
        }
    }
}
