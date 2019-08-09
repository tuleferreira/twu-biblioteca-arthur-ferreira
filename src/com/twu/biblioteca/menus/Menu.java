package com.twu.biblioteca.menus;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Menu {
    public final String INVALID_OPTION = "Please select a valid option!";
    final Map<Integer, MenuOption> options = new HashMap<>();

    public static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String toString() {
        return "Choose between those options:\n" +
                options.entrySet()
                        .stream()
                        .map(e -> e.getKey() + " - " + e.getValue().title + ".\n")
                        .collect(Collectors.joining());
    }
}
