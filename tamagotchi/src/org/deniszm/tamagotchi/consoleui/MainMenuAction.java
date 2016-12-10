package org.deniszm.tamagotchi.consoleui;

import org.deniszm.tamagotchi.app.PetsList;

/**
 * Created by Denis on 10.12.2016.
 */
public abstract class MainMenuAction implements MenuAction<PetsList>{
    private String title;

    public MainMenuAction(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void doAction(PetsList list);

}
