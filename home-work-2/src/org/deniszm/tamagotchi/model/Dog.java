package org.deniszm.tamagotchi.model;

/**
 * Dos with specific play abilities.
 * Created by Denis on 10.11.2016.
 */
public class Dog extends Pet {

    public Dog(String n) {
        super(n);
    }

    public String play() {
        System.out.print(getName() + " ");
        int selector = (int) (Math.random() * 4);
        switch (selector) {
            case 0:
                decreaseEnergy(20, 30);
                return "ловит мячик";
            case 1:
                decreaseEnergy(10, 30);
                return "гоняется за своим хвостом";
            case 2:
                decreaseEnergy(5, 10);
                return "приносит тапочки";
            case 3:
                decreaseEnergy(5, 10);
                return "танцует на задних лапах";
            case 4:
                decreaseEnergy(5, 10);
                return "трется мордой";
        }
        return null;
    }
}
