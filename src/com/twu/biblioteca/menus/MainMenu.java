package com.twu.biblioteca.menus;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.sections.Section;
import com.twu.biblioteca.users.User;

import java.util.*;
import java.util.stream.Collectors;

public class MainMenu implements Menu {
    private Map<Integer, String> options;
    private List<Section> sectionsList;
    private User loggedInUser;

    public MainMenu(User loggedInUser) {
        this.loggedInUser = loggedInUser;

        options = new HashMap<>();
        sectionsList = new ArrayList<>();

        options.put(0, "Quit");
        options.put(1, "View my information");
        options.put(2, "View checked out list");
    }

    @Override
    public final void start(Scanner scanner) {
        String terminalInput = "";

        do {
            boolean validOptionInput = false;
            System.out.println(this);

            try {
                terminalInput = getOption(Integer.valueOf(scanner.nextLine()));

                for (Section section : sectionsList) {
                    if (terminalInput.equals(section.getSectionName())) {
                        section.getMenu().start(scanner);
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
                        borrowedList = section.toString(BibliotecaApp.libraryNumberConnected);

                        if (borrowedList != null) {
                            System.out.println(borrowedList);
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

    @Override
    public String getOption(int key) {
        return options.getOrDefault(key, INVALID_OPTION);
    }

    public void addSection(Section section) {
        sectionsList.add(section);
        options.put(options.size(), section.getSectionName());
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
