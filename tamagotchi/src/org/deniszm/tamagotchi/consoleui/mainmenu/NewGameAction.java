package org.deniszm.tamagotchi.consoleui.mainmenu;

import org.deniszm.tamagotchi.app.PetsList;
import org.deniszm.tamagotchi.consoleui.MainMenuAction;
import org.deniszm.tamagotchi.model.Cat;
import org.deniszm.tamagotchi.model.Dog;
import org.deniszm.tamagotchi.model.Hedgehog;

/**
 * Created by Denis on 10.12.2016.
 */
public class NewGameAction extends MainMenuAction {

    public NewGameAction() {
        super("Новая Игра");
    }

    public void doAction(PetsList list) {
        list.add(new Cat("Котик", 100));
        list.add(new Dog("Песик", 100));
        list.add(new Hedgehog("Ежик", 100));
        list.save();
    }
}
