package com.twu.biblioteca.menus;

import com.twu.biblioteca.sections.Section;
import com.twu.biblioteca.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.menus.MenuOption.option;

public class MainMenu extends Menu {
    public final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore";
    private List<Section> sectionsList;

    public MainMenu(User loggedInUser) {
        sectionsList = new ArrayList<>();

        options.put(0, option("Quit", () -> System.exit(0)));
        options.put(1, option("View my information", () -> System.out.println(String.format("%s\n", loggedInUser))));
        options.put(2, option("View checked out list", () -> System.out.println(getBorrowedListsOfSections() + "\n")));
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
}
