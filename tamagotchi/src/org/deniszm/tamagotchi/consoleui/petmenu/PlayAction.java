package org.deniszm.tamagotchi.consoleui.petmenu;

import org.deniszm.tamagotchi.consoleui.PetMenuAction;
import org.deniszm.tamagotchi.model.Pet;

/**
 * Created by Denis on 10.12.2016.
 */
public class PlayAction extends PetMenuAction {
    public PlayAction() {
        super("Играть");
    }

    @Override
    public void doAction(Pet pet){
        System.out.printf("\n ~ %s %s ~\n", pet.getName(), pet.play());
    }
}
