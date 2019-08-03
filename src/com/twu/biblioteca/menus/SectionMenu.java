package com.twu.biblioteca.menus;

import com.twu.biblioteca.sections.Section;
import com.twu.biblioteca.users.User;

import java.util.Scanner;

public class SectionMenu extends Menu {
    private final String PRODUCT_SELECTION_MESSAGE = "Enter the ID or the name:";
    private final Section section;

    public SectionMenu(Section section) {
        this.section = section;

        String productName = section.getProductName().toLowerCase();
        options.put(0, "Go back");
        options.put(1, "List all " + productName + "s");
        options.put(2, "Checkout " + productName);
        options.put(3, "Returning " + productName);
    }

    public final void start(Scanner scanner, User loggedInUser) {
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
                            System.out.println(section.checkoutProduct(Integer.valueOf(terminalInput), loggedInUser.getLibraryNumber()) + "\n");
                        } else {
                            System.out.println(section.checkoutProduct(terminalInput, loggedInUser.getLibraryNumber()) + "\n");
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
}
