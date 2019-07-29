package com.twu.biblioteca.sections;

import com.twu.biblioteca.menus.Menu;
import com.twu.biblioteca.menus.SubMenu;
import com.twu.biblioteca.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private String productName;
    private String sectionName;
    private final String SUCCESSFUL_CHECKOUT_MESSAGE;
    private final String UNSUCCESSFUL_CHECKOUT_MESSAGE;
    private final String SUCCESSFUL_RETURNING_MESSAGE;
    private final String UNSUCCESSFUL_RETURNING_MESSAGE;
    List<Product> productsList = new ArrayList<>();
    private final Menu menu;

    public Section(String productName, String sectionName) {
        this.productName = productName.toLowerCase();
        this.sectionName = sectionName;

        this.SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the " + this.productName + ".";
        this.UNSUCCESSFUL_CHECKOUT_MESSAGE = "Sorry, that " + this.productName + " is not available.";
        this.SUCCESSFUL_RETURNING_MESSAGE = "Thank you for returning the " + this.productName + ".";
        this.UNSUCCESSFUL_RETURNING_MESSAGE = "That is not a valid " + this.productName + " to return.";

        menu = new SubMenu(this);
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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public Product getProduct(int id) {
        for (Product product : productsList) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    ;

    public Product getProduct(String title) {
        for (Product product : productsList) {
            if (product.getTitle().equalsIgnoreCase(title)) {
                return product;
            }
        }

        return null;
    }

    public String checkoutProduct(int id) {
        Product product = getProduct(id);

        if (product == null || product.isBorrowed()) {
            return UNSUCCESSFUL_CHECKOUT_MESSAGE;
        }

        product.setBorrowed(true);

        return SUCCESSFUL_CHECKOUT_MESSAGE;
    }

    public String checkoutProduct(String name) {
        Product product = getProduct(name);

        if (product == null || product.isBorrowed()) {
            return UNSUCCESSFUL_CHECKOUT_MESSAGE;
        }

        product.setBorrowed(true);

        return SUCCESSFUL_CHECKOUT_MESSAGE;
    }

    public String returnProduct(int id) {
        Product product = getProduct(id);

        if (product == null || !product.isBorrowed()) {
            return UNSUCCESSFUL_RETURNING_MESSAGE;
        }

        product.setBorrowed(false);

        return SUCCESSFUL_RETURNING_MESSAGE;
    }

    public String returnProduct(String name) {
        Product product = getProduct(name);

        if (product == null || !product.isBorrowed()) {
            return UNSUCCESSFUL_RETURNING_MESSAGE;
        }

        product.setBorrowed(false);

        return SUCCESSFUL_RETURNING_MESSAGE;
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

    ;
}
