package org.deniszm.tamagotchi.consoleui.mainmenu;

import org.deniszm.tamagotchi.app.PetsList;
import org.deniszm.tamagotchi.consoleui.MainMenuAction;

/**
 * Created by Denis on 10.12.2016.
 */
public class SaveGameAction extends MainMenuAction {
    public SaveGameAction() {
        super("Сохранить");
    }

    @Override
    public void doAction(PetsList list) {
        list.save();
    }
}
