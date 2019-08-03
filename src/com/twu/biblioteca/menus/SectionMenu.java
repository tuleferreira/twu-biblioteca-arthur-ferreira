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
        int input = 0;

        do {
            System.out.println(this);

            try {
                input = Integer.valueOf(scanner.nextLine());

                switch (input) {
                    case 0:
                        break;
                    case 1:
                        System.out.println(section);
                        break;
                    case 2:
                        System.out.println(section.checkoutProduct(getProductInput(scanner), loggedInUser.getLibraryNumber()) + "\n");
                        break;
                    case 3:
                        System.out.println(section.returnProduct(getProductInput(scanner)) + "\n");
                        break;
                    default:
                        System.out.println(getOption(input));
                }
            } catch (NumberFormatException e) {
                System.out.println(INVALID_OPTION + "\n");
            }
        } while (input != 0);
    }

    public Object getProductInput(Scanner scanner) {
        System.out.println(PRODUCT_SELECTION_MESSAGE);

        String productSelected = scanner.nextLine();

        return productSelected.matches("\\d")
                ? Integer.valueOf(productSelected)
                : productSelected;
    }
}
