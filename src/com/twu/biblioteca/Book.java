package com.twu.biblioteca;

import java.time.LocalDate;

public class Book {
    private int id;
    private String name;
    private String author;
    private String category;
    private String description;
    private LocalDate publishDate;
    private int rating;

    public Book(int id, String name, String author, String category, String description, LocalDate publishDate, int rating) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.description = description;
        this.publishDate = publishDate;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("| %07d | %-70s| %-30s| %-20s| %02d/%02d/%s | %-6s |", id, name, author, category, publishDate.getDayOfMonth(), publishDate.getMonthValue(), publishDate.getYear(), rating);

    }
}
