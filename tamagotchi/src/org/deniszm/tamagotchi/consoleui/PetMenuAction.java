package org.deniszm.tamagotchi.consoleui;

import org.deniszm.tamagotchi.exception.TamagotchiException;
import org.deniszm.tamagotchi.model.Pet;

/**
 * Created by Denis on 10.12.2016.
 */
public abstract class PetMenuAction implements MenuAction<Pet> {
    private String title;

    public PetMenuAction(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void doAction(Pet pet) throws TamagotchiException;
}
