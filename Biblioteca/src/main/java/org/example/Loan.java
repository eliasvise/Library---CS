package org.example;

public class Loan {
    private Book book;
    private User user;
    private String loanDate;
    private String returnDate;

    public Loan(Book book, User user, String loanDate, String returnDate) {
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        book.setIsAvailable(false);
    }

    @Override
    public String toString() {
        return "Book: " + book + " loaned to: " + user + " loan Date:  " + loanDate + " expected return date: " + returnDate;
    }
}
