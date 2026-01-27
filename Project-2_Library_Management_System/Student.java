package library;

public class Student extends User{
    public Student(int userId, String name) {
        super(userId, name);
    }

    @Override
    public void showRole() {
        System.out.println("Student");
    }

}
