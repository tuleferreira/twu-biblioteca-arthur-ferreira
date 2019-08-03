package com.twu.biblioteca.sections;

import com.twu.biblioteca.menus.SectionMenu;
import com.twu.biblioteca.products.Product;

import java.util.List;

public class Section {
    private String productName;
    private String sectionName;
    private final List<Product> productsList;
    private final SectionMenu menu;

    public Section(String productName, String sectionName, List<Product> productsList) {
        this.productName = productName.toLowerCase();
        this.sectionName = sectionName;
        this.productsList = productsList;

        menu = new SectionMenu(this);
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

    public String checkoutProduct(Object key, String libraryNumber) {
        Product product = key instanceof Integer ? getProduct((int) key) : getProduct((String) key);

        if (product == null || product.isBorrowed()) {
            return "Sorry, that " + this.productName + " is not available.";
        }

        product.setBorrowedBy(libraryNumber);

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

    public String getBorrowedListByLibraryNumber(String libraryNumber) {
        StringBuilder borrowedBooksString = new StringBuilder(sectionName + ":\n").append(productsList.get(0).getProductShowHeader()).append("\n");

        for (Product product : productsList) {
            if (product.getBorrowedBy() != null && product.getBorrowedBy().equals(libraryNumber)) {
                borrowedBooksString.append(product);
            }
        }

        if (borrowedBooksString.toString().split("\n").length == 2) {
            return sectionName + ":\n"  + "You have nothing borrowed";
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
