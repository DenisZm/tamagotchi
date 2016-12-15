package org.deniszm.tamagotchi.app;

import org.deniszm.tamagotchi.model.Pet;

import java.util.List;

/**
 * Created by denis on 15.12.16.
 */
public interface PetDAO {
    List<Pet> load();

    void save(List<Pet> pets);
}
