package com.twu.biblioteca.products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductTest {
    private Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product( "Titler", "Header");
    }

    @Test
    public void checkIsBorrowed() {
        assertFalse(product.isBorrowed());

        product.setBorrowedBy("123-1231");
        assertTrue(product.isBorrowed());
    }
}