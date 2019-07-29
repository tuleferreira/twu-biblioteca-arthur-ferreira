package com.twu.biblioteca.menus;

import com.twu.biblioteca.sections.Section;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SubMenu implements Menu {
    private final Map<Integer, String> options;
    private final Section section;

    public SubMenu(Section section) {
        this.section = section;

        options = new HashMap<>();

        String productName = section.getProductName().toLowerCase();
        options.put(0, "Go back");
        options.put(1, "List all " + productName + "s");
        options.put(2, "Checkout " + productName);
        options.put(3, "Returning " + productName);
    }

    @Override
    public final void start(Scanner scanner) {
        String terminalInput = "";

        do {
            System.out.println(this);

            try {
                terminalInput = getOption(Integer.valueOf(scanner.nextLine()));

                if (terminalInput.equals(getOption(0))) {
                    break;
                } else if (terminalInput.contains("Invalid")) {
                    System.out.println(terminalInput);
                } else if (terminalInput.contains("List")) {
                    System.out.println(section);
                } else {
                    System.out.println(PRODUCT_SELECTION_MESSAGE);

                    if (terminalInput.contains("Checkout")) {
                        terminalInput = scanner.nextLine();

                        if (terminalInput.matches("\\d+")) {
                            System.out.println(section.checkoutProduct(Integer.valueOf(terminalInput)) + "\n");
                        } else {
                            System.out.println(section.checkoutProduct(terminalInput) + "\n");
                        }
                    } else if (terminalInput.contains("Returning")) {
                        terminalInput = scanner.nextLine();

                        if (terminalInput.matches("\\d+")) {
                            System.out.println(section.returnProduct(Integer.valueOf(terminalInput)) + "\n");
                        } else {
                            System.out.println(section.returnProduct(terminalInput) + "\n");
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(INVALID_OPTION + "\n");
            }
        } while (!terminalInput.equals(getOption(0)));
    }

    @Override
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
