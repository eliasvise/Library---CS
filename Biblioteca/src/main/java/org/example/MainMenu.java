package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private static List<Author> authors = new ArrayList<>();
    private static List<Book> books = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static List<Loan> loans = new ArrayList<>();

    public static void main(String[] args) {
        begin();
    }

    public static void begin() {
        Scanner scanner = new Scanner(System.in);
        String credential = "Admin123";

        //Log in
        System.out.println("Type the Admin Username(Admin123)");
        String username = scanner.nextLine();
        System.out.println("Type the Admin Password(Admin123)");
        String password = scanner.nextLine();

        if (username.equals(credential) && password.equals(credential)) {
            // Invoke main menu of functions
            MainMenu();
        } else {
            System.out.println("\n\nSomething was wrong with the username and password, please try again");
            begin();
        }
    }

    public static void MainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the library program!");
        System.out.println("1. Books. \n2. Authors. \n3. Users \n4. Loans. \n5. Log out");
        int option = scanner.nextInt();

        // Switch para la eleccion libre de el modulo a escoger.
        //Each option should have an specific menu to select show or add records
        switch (option) {
            case 1:
                booksMenu();
                break;
            case 2:
                authorsMenu();
                break;
            case 3:
                usersMenu();
                break;
            case 4:
                loansMenu();
                break;
            case 5:
                System.out.println("You have leave the program");
                System.exit(0);
                break;
            // Default para errores.
            default:
                System.out.println("\nOption not supported, please try again below.\n\n");
                MainMenu();
                break;
        }
    }

    private static void booksMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add Book\n2. Show All Books\n3. Back to Main Menu");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                addBook();
                break;
            case 2:
                showBooks();
                break;
            case 3:
                MainMenu();
                break;
            default:
                System.out.println("\nOption not supported, please try again below.\n\n");
                booksMenu();
                break;
        }
    }

    private static void addBook() {
        Scanner scanner = new Scanner(System.in);
        if (authors.isEmpty()) {
            System.out.println("No authors available. Please add authors first.");
            booksMenu();
            return;
        }

        System.out.println("Choose book type:\n1. General Book\n2. Comic\n3. AudioBook\n4. Literature\n5. Manga\n6. Revista\n7. Science");
        int bookType = scanner.nextInt();
        scanner.nextLine();

        //Get Book's title
        System.out.println("Insert the title of the Book: ");
        String title = scanner.nextLine();
        //Get Book's published date
        System.out.println("Insert the publication date of the Book: ");
        String publicationDate = scanner.nextLine();
        //Get Book's genre
        System.out.println("Insert the genre of the Book: ");
        String genre = scanner.nextLine();

        //This for will show all authors register and the idea is just send the id for the author and assign the index on the list
        System.out.println("Choose an author from the list: ");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println((i + 1) + ". " + authors.get(i));
        }
        int authorIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // consume the newline

        //This validate if the Author if typed exist on the authors list, else will be redirect to add new book again
        if (authorIndex < 0 || authorIndex >= authors.size()) {
            System.out.println("Invalid choice, Try again.");
            addBook();
            return;
        }

        Book book;
        //This switch define the book type and also the constructor to use acording to the genre
        switch (bookType) {
            case 1:
                book = new Book(title, authors.get(authorIndex), publicationDate, genre);
                break;
            case 2:
                System.out.println("Insert the name of the hero: ");
                String hero = scanner.nextLine();
                book = new Comic(title, authors.get(authorIndex), publicationDate, genre, hero);
                break;
            case 3:
                System.out.println("Insert the name of the narrator: ");
                String narrator = scanner.nextLine();
                book = new AudioBook(title, authors.get(authorIndex), publicationDate, genre, narrator);
                break;
            case 4:
                System.out.println("Insert the literary movement: ");
                String literaryMovement = scanner.nextLine();
                book = new Literature(title, authors.get(authorIndex), publicationDate, genre, literaryMovement);
                break;
            case 5:
                System.out.println("Insert the name of the illustrator: ");
                String illustrator = scanner.nextLine();
                book = new Manga(title, authors.get(authorIndex), publicationDate, genre, illustrator);
                break;
            case 6:
                System.out.println("Insert the issue number: ");
                String issueNumber = scanner.nextLine();
                book = new Revista(title, authors.get(authorIndex), publicationDate, genre, issueNumber);
                break;
            case 7:
                System.out.println("Insert the field of study: ");
                String fieldOfStudy = scanner.nextLine();
                book = new Science(title, authors.get(authorIndex), publicationDate, genre, fieldOfStudy);
                break;
            default:
                System.out.println("Invalid book type, Try again.");
                addBook();
                return;
        }

        books.add(book);
        System.out.println("Book added successfully!");

        booksMenu();
    }

    //Show all books, including availables and non availables
    private static void showBooks() {
        if (books.isEmpty()) {
            System.out.println("\nNo books available.\n\n");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
        booksMenu();
    }

    private static void authorsMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add Author\n2. Show All Authors\n3. Back to Main Menu");
        int option = scanner.nextInt();
        scanner.nextLine();  // consume the newline

        switch (option) {
            case 1:
                addAuthor();
                break;
            case 2:
                showAuthors();
                break;
            case 3:
                MainMenu();
                break;
            default:
                System.out.println("\nOption not supported, please try again below.\n\n");
                authorsMenu();
                break;
        }
    }

    private static void addAuthor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the name of the Author: ");
        String name = scanner.nextLine();
        System.out.println("Insert the last name of the Author: ");
        String lastName = scanner.nextLine();
        System.out.println("Insert the nationality of the Author: ");
        String nationality = scanner.nextLine();
        System.out.println("Insert the birth date of the Author: ");
        String birth = scanner.nextLine();

        Author author = new Author(name, lastName, nationality, birth);
        authors.add(author);
        System.out.println("Author added successfully!");

        authorsMenu();
    }

    private static void showAuthors() {
        if (authors.isEmpty()) {
            System.out.println("No authors available.\n\n");
        } else {
            for (Author author : authors) {
                System.out.println(author);
            }
        }
        authorsMenu();
    }

    private static void usersMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add User\n2. Show All Users\n3. Back to Main Menu");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                addUser();
                break;
            case 2:
                showUsers();
                break;
            case 3:
                MainMenu();
                break;
            default:
                System.out.println("\nOption not supported, please try again below.\n\n");
                usersMenu();
                break;
        }
    }

    private static void addUser() {
        Scanner scanner = new Scanner(System.in);

        //Get user's name
        System.out.println("Insert the name of the User: ");
        String name = scanner.nextLine();
        //Get user's last name
        System.out.println("Insert the last name of the User: ");
        String lastName = scanner.nextLine();
        //Get user's adress
        System.out.println("Insert the address of the User: ");
        String address = scanner.nextLine();
        //Get user's phone
        System.out.println("Insert the phone of the User: ");
        String phone = scanner.nextLine();
        //Get user's ID
        System.out.println("Insert the ID number of the User: ");
        String idNumber = scanner.nextLine();

        User user = new User(name, lastName, address, phone, idNumber);
        users.add(user);
        System.out.println("User added successfully!");
        //return to menu
        usersMenu();
    }
    //Show all users
    private static void showUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.\n\n");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
        usersMenu();
    }

    private static void loansMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add Loan\n2. Show All Loans\n3. Back to Main Menu");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                addLoan();
                break;
            case 2:
                showLoans();
                break;
            case 3:
                MainMenu();
                break;
            default:
                System.out.println("\nOption not supported, please try again below.\n\n");
                loansMenu();
                break;
        }
    }

    private static void addLoan() {
        Scanner scanner = new Scanner(System.in);
        //Si no hay libros registrados no se pueden realizar prestamos
        if (books.isEmpty()) {
            System.out.println("No books available.\n\n");
            loansMenu();
            return;
        }
        //No se pueden asociar libros sin usuarios registrados
        if (users.isEmpty()) {
            System.out.println("No users available.\n\n");
            loansMenu();
            return;
        }
        //Show all books in order to select which will be loan
        System.out.println("Choose a book from the list: ");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAvailable()) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
        int bookIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        // Validate if the book selected exist on the books list, else will be required insert a correct values
        if (bookIndex < 0 || bookIndex >= books.size() || !books.get(bookIndex).getAvailable()) {
            System.out.println("Invalid choice or book not available, Try again.");
            addLoan();
            return;
        }

        //Show users list to get the index of the required user to the loan
        System.out.println("Choose a user from the list: ");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i));
        }
        int userIndex = scanner.nextInt() - 1;
        scanner.nextLine();  // consume the newline

        //Validate if the user index inserted exist on the users list
        if (userIndex < 0 || userIndex >= users.size()) {
            System.out.println("Invalid choice, try again.");
            addLoan();
            return;
        }

        System.out.println("Insert the loan date (format: 2023-06-24): ");
        String loanDate = scanner.nextLine();
        System.out.println("Insert the return date (format: 2023-07-24): ");
        String returnDate = scanner.nextLine();

        Loan loan = new Loan(books.get(bookIndex), users.get(userIndex), loanDate, returnDate);
        loans.add(loan);
        System.out.println("Loan added successfully!");

        loansMenu();
    }

    private static void showLoans() {
        if (loans.isEmpty()) {
            System.out.println("No loans register.");
        } else {
            for (Loan loan : loans) {
                System.out.println(loan);
            }
        }
        loansMenu();
    }
}