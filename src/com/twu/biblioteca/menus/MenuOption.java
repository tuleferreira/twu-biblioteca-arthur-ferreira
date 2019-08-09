package com.twu.biblioteca.menus;

public final class MenuOption {
    final String title;
    final OptionBehavior behaviour;

    public MenuOption(String title, OptionBehavior behaviour) {
        this.title = title;
        this.behaviour = behaviour;
    }

    public static MenuOption option(String title, OptionBehavior behaviour) {
        return new MenuOption(title, behaviour);
    }
}
