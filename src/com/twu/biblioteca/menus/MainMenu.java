package com.twu.biblioteca.menus;

import com.twu.biblioteca.sections.Section;
import com.twu.biblioteca.users.User;

import java.util.*;
import java.util.stream.Collectors;

import static com.twu.biblioteca.menus.MenuOption.option;

public class MainMenu implements Menu, Observer {
    public final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
    private Map<Integer, MenuOption> options = new HashMap<>();
    private List<Section> sectionsList;

    public MainMenu(User loggedInUser) {
        sectionsList = new ArrayList<>();

        options.put(0, option("Quit", () -> System.exit(0)));
        options.put(1, option("View my information", () -> System.out.println(String.format("%s\n", loggedInUser))));
        options.put(2, option("View checked out list", () -> System.out.println(getBorrowedListsOfSections() + "\n")));

        System.out.println(WELCOME_MESSAGE);
    }

    public Map<Integer, MenuOption> getOptions() {
        return options;
    }

    @Override
    public void update(Observable o, Object arg) {
        start();
    }

    public final void start() {
        while (true) {
            System.out.println(this);
            try {
                options.get(Integer.valueOf(SCANNER.nextLine())).behaviour.execute();
            } catch (Exception e) {
                System.out.println(String.format("%s\n", INVALID_OPTION));
            }
        }
    }

    public void addSection(Section section) {
        sectionsList.add(section);
        options.put(options.size(), option(section.getSectionName(), () -> section.getMenu().start()));
    }

    public String getBorrowedListsOfSections() {
        return sectionsList.stream()
                .map(Section::getBorrowedList)
                .collect(Collectors.joining("\n\n"));
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
