package library;
import java.io.*;
import java.util.ArrayList;
public class FileUtil {

    private static final String FILE_NAME = "books.dat";

    // Save books to file
    public static void saveBooks(ArrayList<Book> books) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(books);

        } catch (IOException e) {
            System.out.println("Error saving books to file.");
        }
    }

    // Load books from file
    @SuppressWarnings("unchecked")
    public static ArrayList<Book> loadBooks() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (ArrayList<Book>) ois.readObject();

        } catch (Exception e) {
            return new ArrayList<>(); // If file not found or empty
        }
    }
}
