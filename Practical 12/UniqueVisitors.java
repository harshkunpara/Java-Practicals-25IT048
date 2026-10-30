import java.util.*;
public class UniqueVisitors {
    public static void main(String[] args) {
        List<String> logins = Arrays.asList(
                "Harsh", "Rahul", "Amit", "Harsh",
                "Priya", "Rahul", "Neha"
        );

        HashSet<String> uniqueUsers = new HashSet<>();
        LinkedHashSet<String> orderedUsers = new LinkedHashSet<>();

        for (String user : logins) {
            uniqueUsers.add(user);
            orderedUsers.add(user);
        }

        System.out.println(
                "Unique visitor count: " + uniqueUsers.size());
        System.out.println("First three distinct visitors:");
        int count = 0;
        for (String user : orderedUsers) {
            if (count == 3) {
               break;
            }
            System.out.println(user);
            count++;
        }
    }
}
