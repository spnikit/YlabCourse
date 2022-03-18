package com.spnikit.lesson3;

import java.util.Optional;

public interface GameplayToFileMapper<T> {

    void writeToFile(String filename, T t);

    Optional<T> readFromFile(String filename);
}
