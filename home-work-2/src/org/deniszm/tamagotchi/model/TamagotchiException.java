package org.deniszm.tamagotchi.model;

/**
 * TamagotchiException
 * Created by Denis on 13.11.2016.
 */
public class TamagotchiException extends Exception {
    private String detail;

    TamagotchiException(String s) {
        detail = s;
    }

    public String toString() {
        return detail;
    }
}
