package com.twu.biblioteca.products;

public class Movie extends Product {
    private final String director;
    private final int yearPublished;
    private final int rating;


    public Movie(int id, String title, int yearPublished, String director, int rating) {
        super(id, title, String.format("| %7s | %-70s| %-30s| %-12s | %7s |", "ID", "MOVIE", "DIRECTOR", "YEAR", "RATING"));
        this.yearPublished = yearPublished;
        this.director = director;
        this.rating = rating;
    }

    public Movie(int id, String title, int yearPublished, String director) {
        this(id, title, yearPublished, director, -1);
    }

    public String parseRating() {
        return rating < 1 ? "Unrated" : String.valueOf(rating);
    }

    @Override
    public String toString() {
        return String.format("| %7s | %-70s| %-30s| %-12s | %7s |", getId(), getTitle(), director, yearPublished, parseRating());
    }
}
