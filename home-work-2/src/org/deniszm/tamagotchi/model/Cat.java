package org.deniszm.tamagotchi.model;

/**
 * Cat with specific play abilities.
 * Created by Denis on 10.11.2016.
 */
public class Cat extends Pet {

    public Cat(String n) {
        super(n);
    }

    public String play() {
        //System.out.print(getName() + " ");
        int selector = (int) (Math.random() * 4);
        switch (selector) {
            case 0:
                decreaseEnergy(20, 30);
                return "гоняется за мышкой";
            case 1:
                decreaseEnergy(10, 30);
                return "висит на шторе";
            case 2:
                decreaseEnergy(10, 30);
                return "прыгает со шкафа на комод";
            case 3:
                decreaseEnergy(5, 10);
                return "топчется лапами (мур-мур...)";
        }
        return null;
    }
}
