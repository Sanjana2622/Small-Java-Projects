package library;
import java.io.Serializable;
public class Book implements Serializable {
    private int bookId;
    private String title;
    private String author;
    private boolean issued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    // Getters (Encapsulation)
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    // Setters
    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    // Display book details
    public void displayBook() {
        System.out.println(bookId + " | " + title + " | " + author + " | " +
                (issued ? "Issued" : "Available"));
    }
}
