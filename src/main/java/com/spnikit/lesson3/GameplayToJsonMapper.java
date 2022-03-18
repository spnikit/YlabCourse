package com.spnikit.lesson3;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

class GameplayToJsonMapper implements GameplayToFileMapper<Gameplay> {
    ObjectMapper mapper;

    public GameplayToJsonMapper() {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
    }

    public void writeToFile(String filename, Gameplay gameplay) {
        try {
            mapper.writeValue(new File(Objects.requireNonNull(filename)), Objects.requireNonNull(gameplay));
        } catch (IOException e) {
            System.out.println("can't write JSON to file " + filename);
            e.printStackTrace();
        }
    }

    public Optional<Gameplay> readFromFile(String filename) {
        Optional<Gameplay> gameplay;
        try {
            gameplay = Optional.of(mapper.readValue(new File(Objects.requireNonNull(filename)), Gameplay.class));
        } catch (IOException e) {
            System.out.println("can't read file " + filename);
            gameplay = Optional.empty();
            e.printStackTrace();
        }
        return gameplay;
    }
}
