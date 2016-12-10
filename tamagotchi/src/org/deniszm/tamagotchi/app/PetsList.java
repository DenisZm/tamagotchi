package org.deniszm.tamagotchi.app;
import org.deniszm.tamagotchi.model.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * List of available pets.
 * Created by denis on 01.12.16.
 */
public class PetsList {
    private List<Pet> pets = new ArrayList<>();
    private FileDAO dao;

    public PetsList(FileDAO dao) {
        this.dao = dao;
    }

    public void add(Pet pet) {
        this.pets.add(pet);
    }

    public Pet[] getList() {
        Pet[] p = new Pet[this.pets.size()];
        p = this.pets.toArray(p);
        return p;
    }

    public Pet get(int index) {
        return this.pets.get(index);
    }

    public void delete(Pet pet) {
        this.pets.remove(pet);
    }

    public int getSize() {
        return pets.size();
    }

    public void save() {
        dao.save(pets);
    }

    public void load() {
        this.pets = dao.load();
    }

}


