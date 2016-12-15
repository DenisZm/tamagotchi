package org.deniszm.tamagotchi.app;

import org.deniszm.tamagotchi.consoleui.ConsoleMenu;
import org.deniszm.tamagotchi.exception.TamagotchiException;

import java.io.File;
import java.io.IOException;

/**
 * Play game.
 * Created by Denis on 10.11.2016.
 */
public class PlayGame {
    public static void main(String[] args) throws IOException, TamagotchiException {

        File savefile = new File("tamagotchi.save");
//        PetDAO dao = new FileDAO(savefile);
        PetDAO dao = new JsonDAO(savefile);
        PetsList pets = new PetsList(dao);
        ConsoleMenu menu = new ConsoleMenu(pets);

        menu.startMenu();
        menu.selectMenu();

        while (true) {
            menu.petMenu();
        }
    }
}
