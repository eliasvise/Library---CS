package org.example;

import java.util.Date;

public class Book{
    private String title;
    private Author author;
    private String publishDate;
    private String genre;
    private boolean isAvailable;

    public Book(String title, Author author, String publishDate, String genre) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.genre = genre;
        this.isAvailable = true; // Default as true due to al new book has just arrive to the store
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", published on: " + publishDate + ", genre: " + genre + ", is available? " + isAvailable;
        //(isAvailable ? "Available" : "Not Available")
    }
}
