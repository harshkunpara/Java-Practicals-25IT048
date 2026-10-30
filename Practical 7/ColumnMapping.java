import java.lang.annotation.*;
import java.lang.reflect.Field;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}
class Student {
    @Column(name = "StudentName")
    private String name;
    @Column(name = "Age")
    private int age;
    @Column(name = "Email")
    private String email;
    @Override
    public String toString() {
        return "Student{name='" + name
                + "', age=" + age
                + ", email='" + email + "'}";}}
public class ColumnMapping {
    public static void populate(
            Object obj, String[] headers, String[] data)
            throws Exception {
        if (headers.length != data.length) {
            throw new IllegalArgumentException(
                    "Header and data lengths must match");}
        for (Field field :
                obj.getClass().getDeclaredFields()) {
            if (!field.isAnnotationPresent(Column.class)) {
                continue;}
            String columnName =
                    field.getAnnotation(Column.class).name();
            int index = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase(columnName)) {
                    index = i;
                    break;}}
            if (index == -1) {
                System.out.println(
                        "Missing column: " + columnName);
                continue;}
            field.setAccessible(true);
            String value = data[index];
            if (field.getType() == String.class) {
                field.set(obj, value);
            } else if (field.getType() == int.class) {
                field.setInt(obj, Integer.parseInt(value));
            } else if (field.getType() == double.class) {
                field.setDouble(obj, Double.parseDouble(value));
            } else if (field.getType() == boolean.class) {
                field.setBoolean(obj, Boolean.parseBoolean(value));}}}
    public static void main(String[] args) throws Exception {
        String[] headers = {
            "Email", "StudentName", "Age"
        };
        String[] data = {
            "harsh@example.com", "Harsh", "20"
        };
        Student student = new Student();
        populate(student, headers, data);
        System.out.println(student);}}
