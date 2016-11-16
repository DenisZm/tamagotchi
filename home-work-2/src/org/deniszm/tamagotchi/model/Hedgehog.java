package org.deniszm.tamagotchi.model;

/**
 * Hedgehog with specific play abilities.
 * Created by Denis on 10.11.2016.
 */
public class Hedgehog extends Pet {

    public Hedgehog(String n) {
        super(n);
    }

    public String play() {
        System.out.print(getName() + " ");
        int selector = (int) (Math.random() * 3);
        switch (selector) {
            case 0:
                decreaseEnergy(20, 30);
                return "бегает с яблоком на спине";
            case 1:
                decreaseEnergy(20, 30);
                return "ходит в тумане";
            case 2:
                decreaseEnergy(5, 10);
                return "смешно сопит носом";
        }
        return null;
    }
}
