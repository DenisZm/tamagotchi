package org.deniszm.tamagotchi.app;

import org.deniszm.tamagotchi.model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Denis on 09.12.2016.
 */
public class FileDAO implements PetDAO {
    private final File file;

    public FileDAO(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        this.file = file;
    }

    @Override
    public List<Pet> load() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(fileInputStream);

            List<Pet> pets = new ArrayList();
            while (scanner.hasNextLine()) {
                String petString = scanner.nextLine();
                String[] petValue = petString.split("\\|");

                String petClass = petValue[0];
                String petName = petValue[1];
                int petEnergy = Integer.parseInt(petValue[2]);

                switch (petClass) {
                    case "Cat":
                        pets.add(new Cat(petName, petEnergy));
                        break;
                    case "Dog":
                        pets.add(new Dog(petName, petEnergy));
                        break;
                    case "Hedgehog":
                        pets.add(new Hedgehog(petName, petEnergy));
                }
            }
            return pets;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(List<Pet> pets) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            for (int i = 0; i < pets.size(); i++) {
                String petsString = petsSerializedString(pets.get(i)) + "\r\n";
                fileOutputStream.write(petsString.getBytes());
            }
            fileOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String petsSerializedString(Pet pet) {
        return pet.getClass().getSimpleName() + "|" + pet.getName() + "|" + pet.getEnergy();
    }
}
