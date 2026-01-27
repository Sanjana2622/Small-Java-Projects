package library;

public class User {
    protected int userId;
    protected String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    // Method to be overridden (Polymorphism)
    public void showRole() {
        System.out.println("User");
    }
}
