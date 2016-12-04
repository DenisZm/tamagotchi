package tamagotchi.app;

import tamagotchi.model.Pet;

import java.util.ArrayList;
import java.util.Collections;

/**
 * List of available pets.
 * Created by denis on 01.12.16.
 */
public class PetsList {
    private ArrayList<Pet> pets = new ArrayList<>();

    public PetsList(Pet[] pets) {
        Collections.addAll(this.pets, pets);
    }

    public Pet[] getList() {
        Pet[] p = new Pet[this.pets.size()];
        p = this.pets.toArray(p);
        return p;
    }

    public Pet select(int index) {
        return this.pets.get(index);
    }

    public void delete(Pet pet) {
        this.pets.remove(pet);
    }

    public int getSize() {
        return pets.size();
    }

}


