package com.twu.biblioteca.menus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Menu {
    public static final Scanner SCANNER = new Scanner(System.in);
    protected final String INVALID_OPTION = "Please select a valid option!";
    protected Map<Integer, MenuOption> options = new HashMap<>();

    abstract void start();

    public String getInvalidOption() {
        return INVALID_OPTION;
    }

    public Map<Integer, MenuOption> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "Choose between those options:\n" +
                options.entrySet()
                        .stream()
                        .map(e -> e.getKey() + " - " + e.getValue().title + ".\n")
                        .collect(Collectors.joining());
    }
}
