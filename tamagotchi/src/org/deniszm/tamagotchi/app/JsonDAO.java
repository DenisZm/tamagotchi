package org.deniszm.tamagotchi.app;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.deniszm.tamagotchi.model.*;

import java.io.*;
import java.lang.reflect.Constructor;
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
        public JsonElement serialize(Pet src, Type typeOfSrc,
                                     JsonSerializationContext context) {
            JsonObject result = new JsonObject();

            result.addProperty("type", src.getClass().getName());
            result.addProperty("name", src.getName());
            result.addProperty("energy", src.getEnergy());

            return result;
        }
    }

    private class PetDeserializer implements JsonDeserializer<Pet> {

        @Override
        public Pet deserialize(JsonElement json, Type typeOfT,
                               JsonDeserializationContext context)
                throws JsonParseException {

            JsonObject petJson = json.getAsJsonObject();
            Pet pet = null;

            try {
                Class petClass = Class.forName(petJson.get("type").getAsString());

                Object[] petProperty = new Object[]{petJson.get("name").getAsString(),
                        petJson.get("energy").getAsInt()};

                Constructor[] petConstructor = petClass.getDeclaredConstructors();

                pet = (Pet) petConstructor[0].newInstance(petProperty);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return pet;
        }
    }
}
