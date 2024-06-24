package org.example;

class AudioBook extends Book {
    private String narrator;

    public AudioBook(String title, Author author, String publicationDate, String genre, String narrator) {
        super(title, author, publicationDate, genre);
        this.narrator = narrator;
    }

    public String getNarrator() {
        return narrator;
    }

    @Override
    public String toString() {
        return super.toString() + ", Narrator: " + narrator + "  ";
    }
}
