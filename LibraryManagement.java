import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String issuedTo;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.issuedTo = null;
    }
}

class Member {
    String name;

    Member(String name) {
        this.name = name;
    }
}

public class LibraryManagement {
    // ansi escape codes for colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addBook() {
        System.out.print(ANSI_YELLOW + "Enter book title: " + ANSI_RESET);
        String title = sc.nextLine();
        System.out.print(ANSI_YELLOW + "Enter author: " + ANSI_RESET);
        String author = sc.nextLine();
        books.add(new Book(title, author));
        System.out.println(ANSI_GREEN + "Book added successfully!" + ANSI_RESET);
    }

    static void deleteBook() {
        System.out.print(ANSI_YELLOW + "Enter book title to delete: " + ANSI_RESET);
        String title = sc.nextLine();
        boolean removed = books.removeIf(book -> book.title.equalsIgnoreCase(title));
        if (removed) {
            System.out.println(ANSI_GREEN + "Book deleted successfully!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Book not found." + ANSI_RESET);
        }
    }

    static void addMember() {
        System.out.print(ANSI_YELLOW + "Enter member name: " + ANSI_RESET);
        String name = sc.nextLine();
        members.add(new Member(name));
        System.out.println(ANSI_GREEN + "Member added successfully!" + ANSI_RESET);
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println(ANSI_YELLOW + "No books available in the library." + ANSI_RESET);
            return;
        }
        System.out.println(ANSI_CYAN + "\n--- Available Books ---" + ANSI_RESET);
        for (Book book : books) {
            String status;
            if (book.issuedTo == null) {
                status = ANSI_GREEN + "[Available]" + ANSI_RESET;
            } else {
                status = ANSI_RED + "[Issued to " + book.issuedTo + "]" + ANSI_RESET;
            }
            System.out.println("- " + ANSI_WHITE + book.title + ANSI_RESET + " by " + book.author + " " + status);
        }
    }

    static void searchBook() {
        System.out.print(ANSI_YELLOW + "Enter book title to search: " + ANSI_RESET);
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;
        System.out.println(ANSI_CYAN + "\n--- Search Results ---" + ANSI_RESET);
        for (Book book : books) {
            if (book.title.toLowerCase().contains(keyword)) {
                System.out.println("- " + ANSI_WHITE + book.title + ANSI_RESET + " by " + book.author);
                found = true;
            }
        }
        if (!found) {
            System.out.println(ANSI_RED + "No books found matching your search." + ANSI_RESET);
        }
    }

    static void issueBook() {
        System.out.print(ANSI_YELLOW + "Enter book title to issue: " + ANSI_RESET);
        String title = sc.nextLine();
        System.out.print(ANSI_YELLOW + "Enter your name: " + ANSI_RESET);
        String name = sc.nextLine();
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.issuedTo == null) {
                book.issuedTo = name;
                System.out.println(ANSI_GREEN + "Book issued successfully to " + name + "!" + ANSI_RESET);
                return;
            }
        }
        System.out.println(ANSI_RED + "Book is not available for issue." + ANSI_RESET);
    }

    static void returnBook() {
        System.out.print(ANSI_YELLOW + "Enter book title to return: " + ANSI_RESET);
        String title = sc.nextLine();
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.issuedTo != null) {
                book.issuedTo = null;
                System.out.println(ANSI_GREEN + "Book returned successfully!" + ANSI_RESET);
                return;
            }
        }
        System.out.println(ANSI_RED + "Book not found or was not issued." + ANSI_RESET);
    }

    public static void main(String[] args) {
        // pre-add some books for demonstration
        books.add(new Book("Love Story", "F. Scott Fitzgerald"));
        books.add(new Book("Too Good To Be true", "Prajakta Koli"));

        while (true) {
            System.out.println(ANSI_PURPLE + "\n===== DIGITAL LIBRARY MANAGEMENT =====" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "1. Admin Login");
            System.out.println("2. User Menu");
            System.out.println("3. Exit" + ANSI_RESET);
            System.out.print(ANSI_YELLOW + "Enter choice: " + ANSI_RESET);
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print(ANSI_YELLOW + "Enter Admin Password: " + ANSI_RESET);
                String pass = sc.nextLine();
                if (pass.equals("sarvesh123")) {
                    while (true) {
                        System.out.println(ANSI_CYAN + "\n--- Admin Menu ---" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "1. Add Book");
                        System.out.println("2. Delete Book");
                        System.out.println("3. Add Member");
                        System.out.println("4. View All Books"); 
                        System.out.println("5. Back to Main Menu" + ANSI_RESET); 
                        System.out.print(ANSI_YELLOW + "Enter choice: " + ANSI_RESET);
                        String adminChoice = sc.nextLine();
                        if (adminChoice.equals("1")) addBook();
                        else if (adminChoice.equals("2")) deleteBook();
                        else if (adminChoice.equals("3")) addMember();
                        else if (adminChoice.equals("4")) viewBooks(); 
                        else if (adminChoice.equals("5")) break; 
                        else System.out.println(ANSI_RED + "Invalid choice." + ANSI_RESET);
                    }
                } else {
                    System.out.println(ANSI_RED + "Wrong password!" + ANSI_RESET);
                }
            } else if (choice.equals("2")) {
                while (true) {
                    System.out.println(ANSI_CYAN + "\n--- User Menu ---" + ANSI_RESET);
                    System.out.println(ANSI_WHITE + "1. View All Books");
                    System.out.println("2. Search for a Book");
                    System.out.println("3. Issue a Book");
                    System.out.println("4. Return a Book");
                    System.out.println("5. Back to Main Menu" + ANSI_RESET);
                    System.out.print(ANSI_YELLOW + "Enter choice: " + ANSI_RESET);
                    String userChoice = sc.nextLine();
                    if (userChoice.equals("1")) viewBooks();
                    else if (userChoice.equals("2")) searchBook();
                    else if (userChoice.equals("3")) issueBook();
                    else if (userChoice.equals("4")) returnBook();
                    else if (userChoice.equals("5")) break;
                    else System.out.println(ANSI_RED + "Invalid choice." + ANSI_RESET);
                }
            } else if (choice.equals("3")) {
                System.out.println(ANSI_PURPLE + "Exiting the Digital Library. Goodbye!" + ANSI_RESET);
                break;
            } else {
                System.out.println(ANSI_RED + "Invalid choice. Please try again." + ANSI_RESET);
            }
        }
    }
}
