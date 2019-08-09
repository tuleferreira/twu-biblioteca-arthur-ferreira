package com.twu.biblioteca.products;

public class MovieParser implements Parser<Product> {
    @Override
    public Movie parse(String[] attributes) {
        String title = attributes[0];
        int yearPublished = Integer.valueOf(attributes[1]);
        String director = attributes[2];

        if (attributes.length == 4) {
            int rating = Integer.valueOf(attributes[3]);

            return new Movie(title, yearPublished, director, rating);
        }

        return new Movie(title, yearPublished, director);
    }
}
