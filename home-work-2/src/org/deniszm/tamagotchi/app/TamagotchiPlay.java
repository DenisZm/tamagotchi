package org.deniszm.tamagotchi.app;

import org.deniszm.tamagotchi.model.*;

/**
 * Play game.
 * Created by Denis on 10.11.2016.
 */
public class TamagotchiPlay {
    public static void main(String[] args) {
        TamagotchiMenu menu = new TamagotchiMenu();
        Pet myPet = menu.selectPet();
        System.out.printf("\n~ У вас появился %s ~\n", myPet.getName());

        while (myPet.getEnergy() > 0) {
            menu.selectAction(myPet);
        }

        System.out.printf("\n...%s заболел, и его увезла скорая...\n",
                myPet.getName());
    }
}
