/*
Simple book management application with ArrayList.
User should be able to add a book to ArrayList.
User should be able to remove a book from ArrayList.
Easy: Work with String in ArrayList. All the actions should be available for user.

Medium: Work with String User should be able to repeat all the actions infinitely.

Hard: Create a Book class and work with Book object to the ArrayList.
*/
Main.java

  public class Main {
    public static void main(String[] args) {

        BookRepository repo = new BookRepository();
        BookService bookService = new BookService(repo);

        LibraryService libraryService = new LibraryService(bookService);
        libraryService.populateLibrary(libraryService);
        libraryService.startLibrary();


    }
}

LibraryService.java
  
import java.util.List;
import java.util.Scanner;

public class LibraryService {

    BookService bookService;

    public LibraryService(BookService bookService) {

        this.bookService = bookService;
    }

    public void startLibrary() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPress 1 to add a book");
            System.out.println("Press 2 to remove a book");
            System.out.println("Press 3 to show the books");
            System.out.println("Press 4 to quit");
            System.out.print("Enter your choice: ");


            var userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                System.out.println("Enter the book title:");
                var title = scanner.nextLine();
                System.out.println("Enter the book author:");
                var author = scanner.nextLine();
                System.out.println("Enter the book year:");
                var year = scanner.nextInt();
                scanner.nextLine();
                Book book = new Book(title, author, year);
                bookService.addBook(book);
            } else if (userInput.equals("2")) {
                System.out.println("Enter the book index:");
                var index = scanner.nextInt();
                scanner.nextLine();
                bookService.removeBook(index - 1);
            } else if (userInput.equals("3")) {
                List<Book> books = bookService.getBooks();
                if (books.isEmpty()) {
                    System.out.println("No books in the library");
                    continue;
                }
                int i = 0;
                for (Book b : books) {
                    System.out.printf("%d %s\n", ++i, b);
                }
            } else if (userInput.equals("4")) {
                break;
            } else {
                System.out.println("Invalid input. Please try again. ");
            }
        }

    }

    public void populateLibrary(LibraryService libraryService) {

        Book book1 = new Book("Book1", "Author1", 2021);
        Book book2 = new Book("Book2", "Author2", 2022);
        Book book3 = new Book("Book3", "Author3", 2023);
        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
    }
}

BookRepository.java

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void removeBook(int index) {
        books.remove(index);
    }
}

BookService.java

import java.util.List;

public class BookService {

    private BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }
    public void addBook(Book book) {
        repo.addBook(book);
        System.out.println("Book added");
    }

    public void removeBook(Book book) {
        repo.removeBook(book);
        System.out.println("Book removed");
    }

    public List<Book> getBooks() {
        return repo.getBooks();
    }

    public void removeBook(int index) {
        repo.removeBook(index);
        System.out.println("Book removed");
    }
}

Book.java

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
