package com.twu.biblioteca.menus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Menu {
    public static final Scanner SCANNER;
    static final String INVALID_OPTION;

    static {
        SCANNER = new Scanner(System.in);
        INVALID_OPTION = "Please select a valid option!";
    }

    final Map<Integer, MenuOption> options = new HashMap<>();

    abstract void start();

    @Override
    public String toString() {
        return "Choose between those options:" +
                options.entrySet()
                        .stream()
                        .map(e -> String.format("\n%s - %s.", e.getKey(), e.getValue().title))
                        .collect(Collectors.joining());
    }
}
