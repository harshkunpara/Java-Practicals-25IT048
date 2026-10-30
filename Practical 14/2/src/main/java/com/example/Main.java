package com.example;

import com.example.service.CounterService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        CounterService service = new CounterService();
        Path file = Path.of("counter-data.txt");

        if (Files.exists(file)) {
            service.load(file);
            System.out.println("Loaded count: " + service.getCount());
        }

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n1. Add");
                System.out.println("2. Show Count");
                System.out.println("3. Save");
                System.out.println("4. Load");
                System.out.println("0. Exit");
                System.out.print("Choice: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input.");
                    sc.next();
                    continue;
                }

                int choice = sc.nextInt();

                try {
                    switch (choice) {
                        case 1:
                            service.add();
                            System.out.println("Count increased.");
                            break;
                        case 2:
                            System.out.println("Count: " + service.getCount());
                            break;
                        case 3:
                            service.save(file);
                            System.out.println("Data saved.");
                            break;
                        case 4:
                            service.load(file);
                            System.out.println("Data loaded.");
                            break;
                        case 0:
                            System.out.println("Goodbye!");
                            return;
                        default:
                            System.out.println("Invalid action.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
