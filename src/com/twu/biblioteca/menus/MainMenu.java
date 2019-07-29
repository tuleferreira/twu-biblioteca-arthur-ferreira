package com.twu.biblioteca.menus;

import com.twu.biblioteca.sections.Section;

import java.util.*;
import java.util.stream.Collectors;

public class MainMenu implements Menu {
    private Map<Integer, String> options;
    private List<Section> sectionsList;

    public MainMenu() {
        options = new HashMap<>();
        sectionsList = new ArrayList<>();

        options.put(0, "Quit");
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
        options.put(sectionsList.size(), section.getSectionName());
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
