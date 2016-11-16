package org.deniszm.tamagotchi.model;

/**
 * Common Pet abilities.
 * Created by Denis on 10.11.2016.
 */
public abstract class Pet {
    private int energy; //decease while playing, increase while sleep or eat
    private String name;

    Pet(String n) {
        this.energy = 100;
        this.name = n;
    }

    public int getEnergy() {
        return energy;
    }

    public String getName() {
        return name;
    }


    protected void decreaseEnergy(int min, int max) {
        int range = max - min;
        this.energy -= (int) (Math.random() * range) + min;
    }

    protected void increaseEnergy(int min, int max) {
        int range = max - min;
        this.energy += (int) (Math.random() * range) + min;
    }

    public void sleep () throws TamagotchiException {
        if (getEnergy() == 100) {
            throw new TamagotchiException("-Не хочу спать-");
        }
        increaseEnergy(20, 80);
        if (energy > 100) {
            energy -= energy % 100;
        }
    }

    public void eat() throws TamagotchiException {
        if (getEnergy() == 100) {
            throw new TamagotchiException("-Не хочу есть-");
        }
        increaseEnergy(5, 30);
        if (energy > 100) {
            energy -= energy % 100;
        }
    }

    public abstract String play();
}
