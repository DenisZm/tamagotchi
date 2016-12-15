package org.deniszm.tamagotchi.app;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.deniszm.tamagotchi.model.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by denis on 15.12.16.
 */
public class JsonDAO implements PetDAO {
    private final File file;
    private Type petType = new TypeToken<List<Pet>>() {}.getType();

    public JsonDAO(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        this.file = file;
    }

    @Override
    public List<Pet> load() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            JsonReader reader = new JsonReader(new InputStreamReader(fileInputStream));
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Pet.class, new PetDeserializer())
                    .create();

            List<Pet> pets = gson.fromJson(reader, petType);

            return pets;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(List<Pet> pets) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(Pet.class, new PetSerializer())
                    .create();

            String json = gson.toJson(pets, petType);
            fileOutputStream.write(json.getBytes());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private class PetSerializer implements JsonSerializer<Pet> {
        @Override
        public JsonElement serialize(Pet src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject result = new JsonObject();

            result.addProperty("type", src.getClass().getSimpleName());
            result.addProperty("name", src.getName());
            result.addProperty("energy", src.getEnergy());

            return result;
        }
    }

    private class PetDeserializer implements JsonDeserializer<Pet> {

        @Override
        public Pet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject object = json.getAsJsonObject();
            Pet pet = null;
            switch (object.get("type").getAsString()) {
                case "Cat" :
                    pet = new Cat(object.get("name").getAsString(), object.get("energy").getAsInt());
                    break;
                case "Dog" :
                    pet = new Dog(object.get("name").getAsString(), object.get("energy").getAsInt());
                    break;
                case "Hedgehog" :
                    pet = new Cat(object.get("name").getAsString(), object.get("energy").getAsInt());
                    break;
            }
            return pet;
        }
    }
}
