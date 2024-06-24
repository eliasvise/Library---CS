package org.example;

class Manga extends Book {
    private String illustrator;

    public Manga(String title, Author author, String publicationDate, String genre, String illustrator) {
        super(title, author, publicationDate, genre);
        this.illustrator = illustrator;
    }

    public String getIllustrator() {
        return illustrator;
    }

    @Override
    public String toString() {
        return super.toString() + ", Illustrator: " + illustrator + "  ";
    }
}