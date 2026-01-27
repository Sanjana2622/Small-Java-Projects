package library;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int bookId = sc.nextInt();

                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();

                    library.issueBook(bookId, studentId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();

                    library.returnBook(returnId);
                    break;

                case 5:
                    System.out.println("Exiting Library System. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);
    }
}
