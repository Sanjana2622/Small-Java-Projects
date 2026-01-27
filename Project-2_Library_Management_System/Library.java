package library;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> books;
    private HashMap<Integer, Integer> issuedBooks;
    // bookId -> studentId

    // 🔧 UPDATED CONSTRUCTOR (Load data from file)
    public Library() {
        books = FileUtil.loadBooks();   // Load books from file
        issuedBooks = new HashMap<>();
    }

    // Add new book
    public void addBook(Book book) {
        books.add(book);
        FileUtil.saveBooks(books);      // Save after adding
        System.out.println("Book added successfully!");
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("ID | Title | Author | Status");
        for (Book book : books) {
            book.displayBook();
        }
    }

    // Search book by ID
    public Book searchBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    // Issue book
    public void issueBook(int bookId, int studentId) {
        Book book = searchBook(bookId);

        if (book == null) {
            System.out.println("Book not found!");
        } else if (book.isIssued()) {
            System.out.println("Book already issued!");
        } else {
            book.setIssued(true);
            issuedBooks.put(bookId, studentId);
            FileUtil.saveBooks(books);  // Save after issuing
            System.out.println("Book issued successfully!");
        }
    }

    // Return book
    public void returnBook(int bookId) {
        Book book = searchBook(bookId);

        if (book == null) {
            System.out.println("Book not found!");
        } else if (!book.isIssued()) {
            System.out.println("This book was not issued!");
        } else {
            book.setIssued(false);
            issuedBooks.remove(bookId);
            FileUtil.saveBooks(books);  // Save after returning
            System.out.println("Book returned successfully!");
        }
    }
}
