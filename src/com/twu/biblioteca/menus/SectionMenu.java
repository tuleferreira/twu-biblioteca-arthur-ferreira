package com.twu.biblioteca.menus;

import com.twu.biblioteca.sections.Section;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.stream.Collectors;

import static com.twu.biblioteca.BibliotecaApp.mainMenu;
import static com.twu.biblioteca.menus.MenuOption.option;

public class SectionMenu extends Observable implements Menu {
    private final String PRODUCT_SELECTION_MESSAGE = "Enter the ID or the name:";
    private Map<Integer, MenuOption> options = new HashMap<>();

    public SectionMenu(Section section) {
        String productName = section.getProductName().toLowerCase();

        addObserver(mainMenu);

        options.put(0, option("Go back", () -> {
            setChanged();
            notifyObservers();
        }));
        options.put(1, option(String.format("List all %ss", productName), () -> System.out.println(section)));
        options.put(2, option(String.format("Checkout %s", productName), () -> System.out.println(section.checkoutProduct(getProductInput()) + "\n")));
        options.put(3, option(String.format("Returning %s", productName), () -> System.out.println(section.returnProduct(getProductInput()) + "\n")));
    }

    public Map<Integer, MenuOption> getOptions() {
        return options;
    }

    public final void start() {
        while (true) {
            System.out.println(this);

            try {
                options.get(Integer.valueOf(SCANNER.nextLine())).behaviour.execute();
            } catch (Exception e) {
                System.out.println(INVALID_OPTION + "\n");
            }
        }
    }

    private Object getProductInput() {
        System.out.println(PRODUCT_SELECTION_MESSAGE);
        String productSelected = SCANNER.nextLine();

        return productSelected.matches("\\d")
                ? Integer.valueOf(productSelected)
                : productSelected;
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
