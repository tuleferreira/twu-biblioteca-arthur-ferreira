package com.twu.biblioteca.menus;

import com.twu.biblioteca.sections.Section;
import com.twu.biblioteca.users.User;

import java.util.*;

public class MainMenu extends Menu {
    protected final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
    private List<Section> sectionsList;
    private User loggedInUser;

    public MainMenu(User loggedInUser) {
        this.loggedInUser = loggedInUser;

        sectionsList = new ArrayList<>();

        options.put(0, "Quit");
        options.put(1, "View my information");
        options.put(2, "View checked out list");
    }

    public final void start(Scanner scanner) {
        System.out.println("\n" + WELCOME_MESSAGE + "\n");

        String terminalInput = "";

        do {
            boolean validOptionInput = false;
            System.out.println(this);

            try {
                terminalInput = getOption(Integer.valueOf(scanner.nextLine()));

                for (Section section : sectionsList) {
                    if (terminalInput.equals(section.getSectionName())) {
                        section.getMenu().start(scanner, loggedInUser);
                        validOptionInput = true;
                    }
                }

                if (terminalInput.equals(getOption(0))) {
                    break;
                } else if (terminalInput.equals(getOption(1))) {
                    System.out.println(loggedInUser + "\n");
                } else if (terminalInput.equals(getOption(2))) {
                    String borrowedList;

                    for (Section section : sectionsList) {
                        borrowedList = section.getBorrowedListByLibraryNumber(loggedInUser.getLibraryNumber());

                        if (borrowedList != null) {
                            System.out.println(borrowedList + "\n");
                        }
                    }
                } else if (!validOptionInput) {
                    System.out.println(terminalInput);
                }
            } catch (NumberFormatException e) {
                System.out.println(INVALID_OPTION + "\n");
            }
        } while (!terminalInput.equals("Quit"));

        scanner.close();
    }

    public void addSection(Section section) {
        sectionsList.add(section);
        options.put(options.size(), section.getSectionName());
    }

}
