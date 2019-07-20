package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    private final Map<Integer, String> options = new HashMap<>();

    public Menu() {
        options.put(1, "List of books.");
    }

    public String getOption(int key) {
        return options.getOrDefault(key, "Please select a valid option!");
    }

    @Override
    public String toString() {
        String result = "Choose between those options:\n" +
                options.entrySet()
                        .stream()
                        .map(e -> e.getKey() + " - " + e.getValue() + "\n")
                        .collect(Collectors.joining());

        return result;
    }
}
