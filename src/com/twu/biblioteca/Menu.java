package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    final String INVALID_OPTION = "Please select a valid option!";
    private final Map<Integer, String> options = new HashMap<>();

    public Menu() {
        options.put(2, "Returning a book");
        options.put(1, "List of books");
        options.put(0, "Quit");
    }

    public String getOption(int key) {
        return options.getOrDefault(key, INVALID_OPTION);
    }

    @Override
    public String toString() {
        String result = "Choose between those options:\n" +
                options.entrySet()
                        .stream()
                        .map(e -> e.getKey() + " - " + e.getValue() + ".\n")
                        .collect(Collectors.joining());

        return result;
    }
}
