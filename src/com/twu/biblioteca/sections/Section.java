package com.twu.biblioteca.sections;

import com.twu.biblioteca.menus.MainMenu;
import com.twu.biblioteca.menus.Menu;
import com.twu.biblioteca.menus.SectionMenu;
import com.twu.biblioteca.products.Product;
import com.twu.biblioteca.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Section {
    private String productName;
    private String sectionName;
    private List<Product> productsList;
    private User loggedInUser;
    private final Menu menu;

    public Section(String productName, String sectionName, List<Product> productsList) {
        this.productName = productName.toLowerCase();
        this.sectionName = sectionName;

        loggedInUser = MainMenu.getInstance().getLoggedInUser();
        menu = new SectionMenu(this);

        this.productsList = new ArrayList<>();
        for (Product product : productsList) {
            addProduct(product);
        }
    }

    public String getProductName() {
        return productName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public Menu getMenu() {
        return menu;
    }

    public void addProduct(Product product) {
        product.setId(productsList.size() + 1);
        productsList.add(product);
    }

    public Optional<Product> getProduct(int id) {
        return productsList.stream()
                .filter(product -> id == product.getId())
                .findFirst();
    }

    public Optional<Product> getProduct(String title) {
        return productsList.stream()
                .filter(product -> product.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public String checkoutProduct(Object key) {
        Optional<Product> product = key instanceof Integer ? getProduct((int) key) : getProduct((String) key);

        if (!product.isPresent()) {
            return String.format("Sorry, this %s doesn't exist.", productName);
        } else if (product.get().isBorrowed()) {
            return String.format("Sorry, the '%s' is not available.", product.get().getTitle());
        }

        product.get().setBorrowedBy(loggedInUser.getLibraryNumber());
        return String.format("Thank you! Enjoy the '%s'.", product.get().getTitle());
    }

    public String returnProduct(Object key) {
        Optional<Product> product = key instanceof Integer ? getProduct((int) key) : getProduct((String) key);

        if (!product.isPresent()) {
            return String.format("Sorry, this %s doesn't exist.", productName);
        } else if (!product.get().isBorrowed()) {
            return String.format("Sorry, the '%s' is not borrowed.", product.get().getTitle());
        }

        product.get().setBorrowedBy(null);
        return String.format("Thank you for returning the '%s'.", product.get().getTitle());
    }

    public String getBorrowedList() {
        List<Product> borrowedList = productsList.stream()
                .filter(product -> product.getBorrowedBy().equals(Optional.of(loggedInUser.getLibraryNumber())))
                .collect(Collectors.toList());

        if (borrowedList.size() == 0) {
            return String.format("%s:\n%s", sectionName, "You have nothing borrowed");
        }

        return String.format(
                "%s:\n%s\n%s",
                sectionName,
                productsList.get(0).getProductShowHeader(),
                borrowedList.stream()
                        .map(Product::toString)
                        .collect(Collectors.joining("\n"))
        );
    }

    @Override
    public String toString() {
        if (productsList.size() == 0) {
            return String.format("%s:\n%s", sectionName, "This section is empty.");
        }

        return String.format(
                "%s:\n%s\n%s",
                sectionName,
                productsList.get(0).getProductShowHeader(),
                productsList.stream()
                        .map(Product::toString)
                        .collect(Collectors.joining("\n"))
        );
    }
}
