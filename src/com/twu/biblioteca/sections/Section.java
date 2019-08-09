package com.twu.biblioteca.sections;

import com.twu.biblioteca.menus.MainMenu;
import com.twu.biblioteca.menus.SectionMenu;
import com.twu.biblioteca.products.Product;
import com.twu.biblioteca.users.User;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String productName;
    private String sectionName;
    private List<Product> productsList;
    private final User loggedInUser;
    private final SectionMenu menu;

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

    public SectionMenu getMenu() {
        return menu;
    }

    public void addProduct(Product product) {
        product.setId(productsList.size() + 1);
        productsList.add(product);
    }

    public Product getProduct(int id) {
        for (Product product : productsList) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public Product getProduct(String title) {
        for (Product product : productsList) {
            if (product.getTitle().equalsIgnoreCase(title)) {
                return product;
            }
        }

        return null;
    }

    public String checkoutProduct(Object key) {
        Product product = key instanceof Integer ? getProduct((int) key) : getProduct((String) key);

        if (product == null || product.isBorrowed()) {
            return "Sorry, that " + this.productName + " is not available.";
        }

        product.setBorrowedBy(loggedInUser.getLibraryNumber());

        return "Thank you! Enjoy the " + productName + ".";
    }

    public String returnProduct(Object key) {
        Product product = key instanceof Integer ? getProduct((int) key) : getProduct((String) key);

        if (product == null || !product.isBorrowed()) {
            return "That is not a valid " + this.productName + " to return.";
        }

        product.setBorrowedBy(null);

        return "Thank you for returning the " + this.productName + ".";
    }

    public String getBorrowedList() {
        StringBuilder borrowedBooksString = new StringBuilder(sectionName + ":\n").append(productsList.get(0).getProductShowHeader()).append("\n");

        for (Product product : productsList) {
            if (product.getBorrowedBy() != null && product.getBorrowedBy().equals(loggedInUser.getLibraryNumber())) {
                borrowedBooksString.append(product);
            }
        }

        if (borrowedBooksString.toString().split("\n").length == 2) {
            return sectionName + ":\n" + "You have nothing borrowed";
        }

        return borrowedBooksString.toString();
    }

    @Override
    public String toString() {
        StringBuilder allBooksString = new StringBuilder(productsList.get(0).getProductShowHeader()).append("\n");

        for (Product product : productsList) {
            if (!product.isBorrowed()) {
                allBooksString.append(product).append("\n");
            }
        }

        return allBooksString.toString();
    }
}
