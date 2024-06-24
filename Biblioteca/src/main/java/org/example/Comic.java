package org.example;

class Comic extends Book {
    private String hero;

    public Comic(String title, Author author, String publicationDate, String genre, String hero) {
        super(title, author, publicationDate, genre);
        this.hero = hero;
    }

    public String getHero() {
        return hero;
    }

    @Override
    public String toString() {
        return super.toString() + ", Hero: " + hero + "  ";
    }
}