package com.twu.biblioteca.menus;

import com.twu.biblioteca.sections.Section;
import com.twu.biblioteca.users.User;

import java.util.*;
import java.util.stream.Collectors;

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

        int input = 0;
        do {
            System.out.println(this);

            try {
                input = Integer.valueOf(scanner.nextLine());
                Optional<Section> selectedSection = getSection(getOption(input));

                if (!selectedSection.isPresent()) {
                    switch (input) {
                        case 0:
                            break;
                        case 1:
                            System.out.println(loggedInUser + "\n");
                            break;
                        case 2:
                            System.out.println(getBorrowedListsOfSections(loggedInUser.getLibraryNumber()) + "\n");
                            break;
                        default:
                            System.out.println(getOption(input));
                    }
                } else {
                    selectedSection.get().getMenu().start(scanner, loggedInUser);
                }
            } catch (NumberFormatException e) {
                System.out.println(INVALID_OPTION + "\n");
            }
        } while (input != 0);

        scanner.close();
    }

    public void addSection(Section section) {
        sectionsList.add(section);
        options.put(options.size(), section.getSectionName());
    }

    public Optional<Section> getSection(String sectionName) {
        return sectionsList.stream()
                .filter(section -> section.getSectionName().equals(sectionName))
                .findFirst();
    }

    public String getBorrowedListsOfSections(String libraryNumber) {
        return sectionsList.stream()
                .map(section -> section.getBorrowedListByLibraryNumber(libraryNumber))
                .collect(Collectors.joining("\n\n"));
    }
}
