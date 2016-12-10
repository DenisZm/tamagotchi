package org.deniszm.tamagotchi.consoleui.petmenu;

import org.deniszm.tamagotchi.consoleui.PetMenuAction;
import org.deniszm.tamagotchi.exception.TamagotchiException;
import org.deniszm.tamagotchi.model.Pet;

/**
 * Created by Denis on 10.12.2016.
 */
public class EatAction extends PetMenuAction {
    public EatAction() {
        super("Есть");
    }

    public void doAction(Pet pet) {
        try {
            pet.eat();
            System.out.println("\n~ Ням-Ням ~");
        } catch (TamagotchiException e) {
            System.out.println(e);
        }
    }
}
