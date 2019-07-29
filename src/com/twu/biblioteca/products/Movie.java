package com.twu.biblioteca.products;

public class Movie implements Product {
    private final int id;
    private final String title;
    private final int yearPublished;
    private final String director;
    private final int rating;
    private final String productShowHeader;
    private boolean borrowed;

    public Movie(int id, String title, int yearPublished, String director) {
        this(id, title, yearPublished, director, -1);
    }

    public Movie(int id, String title, int yearPublished, String director, int rating) {
        this.id = id;
        this.title = title;
        this.yearPublished = yearPublished;
        this.director = director;
        this.rating = rating;
        this.productShowHeader = String.format("| %7s | %-70s| %-30s| %-12s | %7s |", "ID", "MOVIE", "DIRECTOR", "YEAR", "RATING");
        this.borrowed = false;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getDirector() {
        return director;
    }

    public String parseRating() {
        return rating < 1 ? "Unrated" : String.valueOf(rating);
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String getProductShowHeader() {
        return productShowHeader;
    }

    @Override
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return String.format("| %7s | %-70s| %-30s| %-12s | %7s |", id, title, director, yearPublished, parseRating());
    }
}
