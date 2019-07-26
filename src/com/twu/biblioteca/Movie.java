package com.twu.biblioteca;

public class Movie {
    private final int id;
    private final String title;
    private final int yearPublished;
    private final String director;
    private final int rating;
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
        this.borrowed = false;
    }

    @Override
    public String toString() {
        String ratingToString;

        if (rating == -1) {
            ratingToString = "Unrated";
        } else {
            ratingToString = String.valueOf(rating);
        }

        return String.format("| %7s | %-70s| %-30s| %-12s | %7s |", id, title, director, yearPublished, ratingToString);
    }
}
