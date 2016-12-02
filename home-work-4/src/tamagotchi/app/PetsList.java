package tamagotchi.app;

import tamagotchi.model.Cat;
import tamagotchi.model.Dog;
import tamagotchi.model.Hedgehog;
import tamagotchi.model.Pet;

import java.util.ArrayList;

/**
 * List of available pets.
 * Created by denis on 01.12.16.
 */
public class PetsList {
    private ArrayList<Pet> pets = new ArrayList<>();

    public PetsList() {
        this.pets.add(new Cat("Котик"));
        this.pets.add(new Dog("Песик"));
        this.pets.add(new Hedgehog("Ежик"));
    }

    public Pet[] getList() {
        Pet[] p = new Pet[this.pets.size()];
        p = this.pets.toArray(p);
        return p;
    }

    public Pet select(int index) {
        return this.pets.get(index - 1);
    }

    public void delete(Pet pet) {
        this.pets.remove(pet);
    }

    public int getSize() {
        return pets.size();
    }

}


