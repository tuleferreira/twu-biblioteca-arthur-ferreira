package com.twu.biblioteca.menus;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Menu {
    protected final String INVALID_OPTION = "Please select a valid option!";
    protected final Map<Integer, String> options = new HashMap<>();

    public String getOption(int key) {
        return options.getOrDefault(key, INVALID_OPTION);
    }

    @Override
    public String toString() {
        return "Choose between those options:\n" +
                options.entrySet()
                        .stream()
                        .map(e -> e.getKey() + " - " + e.getValue() + ".\n")
                        .collect(Collectors.joining());
    }
}
