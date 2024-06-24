package org.example;

public class User {
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String idNumber;

    public User(String name, String lastName, String address, String phone, String idNumber) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phone;
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + " " + lastName + ", adress: " + address + ", phone number: " + phoneNumber + ", id: " + idNumber;
    }
}

