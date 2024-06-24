package org.example;

class Science extends Book {
    private String fieldOfStudy;

    public Science(String title, Author author, String publicationDate, String genre, String fieldOfStudy) {
        super(title, author, publicationDate, genre);
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    @Override
    public String toString() {
        return super.toString() + ", Field of Study: " + fieldOfStudy + "  ";
    }
}
