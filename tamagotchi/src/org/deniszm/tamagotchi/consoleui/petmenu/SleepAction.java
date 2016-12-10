package org.deniszm.tamagotchi.consoleui.petmenu;

import org.deniszm.tamagotchi.consoleui.PetMenuAction;
import org.deniszm.tamagotchi.exception.TamagotchiException;
import org.deniszm.tamagotchi.model.Pet;

import java.util.concurrent.TimeUnit;

/**
 * Created by Denis on 10.12.2016.
 */
public class SleepAction extends PetMenuAction {

    public SleepAction() {
        super("Спать");
    }

    public void doAction(Pet pet) {
        try {
            pet.sleep();
            drawSleep();
        } catch (TamagotchiException e) {
            System.out.println(e);
        }
    }

    private void drawSleep() {

        System.out.println();
        try {
            for (int i = 1; i <= 3; i++, TimeUnit.SECONDS.sleep(1)) {
                System.out.print("zZ... ");
            }
            System.out.println();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
