package org.example;

import java.util.Date;

public class Author {
    protected String name;
    protected String lastName;
    protected String nationality;
    protected String birth;

    public Author(String name, String lastName, String nationality, String birth) {
        this.name = name;
        this.lastName = lastName;
        this.nationality = nationality;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + " " + lastName + ", Nationality: " + nationality + ", Birth Date: " + birth;
    }

}
