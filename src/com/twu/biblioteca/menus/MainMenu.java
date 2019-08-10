package com.twu.biblioteca.menus;

import com.twu.biblioteca.sections.Section;
import com.twu.biblioteca.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.menus.MenuOption.option;

public class MainMenu extends Menu {
    private static MainMenu instance;

    private List<Section> sectionsList;
    private User loggedInUser;

    private MainMenu() {
        sectionsList = new ArrayList<>();

        options.put(0, option("Quit", () -> System.exit(0)));
        options.put(1, option("View my information", () -> System.out.println(loggedInUser)));
        options.put(2, option("View checked out list", () -> System.out.println(getBorrowedListsOfSections())));
    }

    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }

        return instance;
    }

    @Override
    public final void start() {
        while (true) {
            System.out.println(String.format("\n%s\n", this));
            try {
                options.get(Integer.valueOf(SCANNER.nextLine())).behaviour.execute();
            } catch (Exception e) {
                System.out.println(INVALID_OPTION);
            }
        }
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
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
