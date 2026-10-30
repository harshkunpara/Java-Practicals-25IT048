import java.io.*;
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    transient String password;
    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    @Override
    public String toString() {
        return "ID: " + id
                + ", Name: " + name
                + ", Password: " + password;
    }
}
public class SaveLoad {
    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "Harsh", "abc123"),
            new Student(2, "Rahul", "xyz456"),
            new Student(3, "Amit", "pass789")
        };
        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream("students.dat"))) {
            out.writeObject(students);
            System.out.println("Objects saved successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream("students.dat"))) {
            Student[] loaded =
                    (Student[]) in.readObject();
            System.out.println("\nLoaded Students:");
            for (Student student : loaded) {
                System.out.println(student);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
