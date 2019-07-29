package com.twu.biblioteca.menus;

import java.util.Scanner;

public interface Menu {
    String INVALID_OPTION = "Please select a valid option!";
    String PRODUCT_SELECTION_MESSAGE = "Enter the ID or the name:";

    void start(Scanner scanner);

    String getOption(int key);
}
