package org.example;

class Literature extends Book {
    private String idioma;

    public Literature(String title, Author author, String publicationDate, String genre, String idioma) {
        super(title, author, publicationDate, genre);
        this.idioma = idioma;
    }

    public String getLiteraryMovement() {
        return idioma;
    }

    @Override
    public String toString() {
        return super.toString() + ", Lenguage: " + idioma + "  ";
    }
}