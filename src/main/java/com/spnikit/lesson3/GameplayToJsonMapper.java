package com.spnikit.lesson3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

class GameplayToJsonMapper {
    ObjectMapper mapper;

    public GameplayToJsonMapper() {
        mapper = new ObjectMapper();
    }

    public void writeJSON(String filename, Gameplay gameplay) {
        try {
            mapper.writeValue(new File(Objects.requireNonNull(filename)), Objects.requireNonNull(gameplay));
        } catch (IOException e) {
            System.out.println("can't write JSON to file " + filename);
            e.printStackTrace();
        }
    }

    public Optional<Gameplay> readJSON(String filename) {
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
