package com.twu.biblioteca.sections;

import com.twu.biblioteca.products.Movie;

import java.util.Arrays;

public class MoviesSection extends Section {
    public MoviesSection(String productName, String sectionName) {
        super(productName, sectionName);

        setProductsList(Arrays.asList(
                new Movie(1, "The Godfather", 1972, "Francis Ford Coppola", 10),
                new Movie(2, "The Dark Knight", 2008, "Christopher Nolan", 9),
                new Movie(3, "Casablanca", 1942, "Michael Curtiz", 9),
                new Movie(4, "Schindler's List", 1993, "Steven Spielberg")
        ));
    }
}
