package org.example;


class Revista extends Book {
    private String editorial;

    public Revista(String title, Author author, String publicationDate, String genre, String editorial) {
        super(title, author, publicationDate, genre);
        this.editorial = editorial;
    }

    public String getIssueNumber() {
        return editorial;
    }

    @Override
    public String toString() {
        return super.toString() + ", Editorial: " + editorial + "  ";
    }
}
