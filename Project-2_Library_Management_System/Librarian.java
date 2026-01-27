package library;

public class Librarian  extends User {
    public Librarian(int userId, String name) {
        super(userId, name);
    }

    @Override
    public void showRole() {
        System.out.println("Librarian");
    }
}
