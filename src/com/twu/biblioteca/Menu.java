package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    private final String INVALID_OPTION = "Please select a valid option!";
    private final String BOOK_SELECTION = "Enter the ID or the Name of the book:";
    private final Map<Integer, String> options = new HashMap<>();

    public Menu() {
        options.put(3, "Returning a book");
        options.put(2, "Checkout a book");
        options.put(1, "List of books");
        options.put(0, "Quit");
    }

    public final void start(Library mainLibrary) {
        Scanner scanner = new Scanner(System.in);
        String terminalInput = "";

        do {
            System.out.println(this);

            try {
                terminalInput = getOption(Integer.valueOf(scanner.nextLine()));

                switch (terminalInput) {
                    case "List of books":
                        System.out.println(mainLibrary.toString());
                        break;
                    case "Checkout a book":
                        System.out.println(BOOK_SELECTION);

                        terminalInput = scanner.nextLine();

                        if (terminalInput.matches("\\d+")) {
                            System.out.println(mainLibrary.checkoutBook(Integer.valueOf(terminalInput)) + "\n");
                        } else {
                            System.out.println(mainLibrary.checkoutBook(terminalInput) + "\n");
                        }
                        break;
                    case "Returning a book":
                        System.out.println(BOOK_SELECTION);

                        terminalInput = scanner.nextLine();

                        if (terminalInput.matches("\\d+")) {
                            System.out.println(mainLibrary.returnBook(Integer.valueOf(terminalInput)) + "\n");
                        } else {
                            System.out.println(mainLibrary.returnBook(terminalInput) + "\n");
                        }
                        break;
                    case "Quit":
                        break;
                    default:
                        System.out.println(terminalInput);
                }
            } catch (NumberFormatException e) {
                System.out.println(INVALID_OPTION + "\n");
            }
        } while (!terminalInput.equals("Quit"));
    }

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
