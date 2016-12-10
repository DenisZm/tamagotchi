package org.deniszm.tamagotchi.consoleui;

import org.deniszm.tamagotchi.exception.TamagotchiException;

/**
 * Created by Denis on 10.12.2016.
 */
interface MenuAction<T> {
    String getTitle();
    void doAction(T o) throws TamagotchiException;
}
