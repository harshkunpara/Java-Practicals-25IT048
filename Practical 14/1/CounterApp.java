import java.util.Scanner;
public class CounterApp {
    public static void main(String[] args) {
        CounterService service = new CounterService();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n1. Add");
                System.out.println("2. Show Count");
                System.out.println("3. Show History");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Enter a valid number.");
                    sc.next();
                    continue;
                }
                int choice = sc.nextInt();
                try {
                    switch (choice) {
                        case 1:
                            service.performAction(1);
                            System.out.println("Count increased.");
                            break;
                        case 2:
                            System.out.println("Count: "
                                    + service.getCount());
                            break;
                        case 3:
                            System.out.println(service.getHistory());
                            break;
                        case 0:
                            System.out.println("Goodbye!");
                            return;
                        default:
                            service.performAction(choice);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
//25IT048