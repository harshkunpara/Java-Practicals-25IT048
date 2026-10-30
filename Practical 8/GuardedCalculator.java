import java.util.InputMismatchException;
import java.util.Scanner;
class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}

public class GuardedCalculator{
    static double calculate(double num1, double num2, char operator)
            throws DivideByZeroException {

        switch (operator) {
            case '+':
                return num1 + num2;

            case '-':
                return num1 - num2;

            case '*':
                return num1 * num2;

            case '/':
                if (num2 == 0) {
                    throw new DivideByZeroException(
                        "Cannot divide by zero!"
                    );
                }
                return num1 / num2;

            default:
                throw new IllegalArgumentException(
                    "Invalid operator!"
                );
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean success = false;
        int attempt = 0;

        while (!success) {

            attempt++;
            try {

                System.out.println("\n--- Calculator Attempt " + attempt + " ---");

                System.out.print("Enter first number: ");
                double num1 = sc.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                char operator = sc.next().charAt(0);

                double result = calculate(num1, num2, operator);

                System.out.println("Result = " + result);

                success = true;

            }
            catch (InputMismatchException e) {

                System.out.println(
                    "Invalid number input! Please enter numbers only."
                );

                sc.nextLine();
            }
            catch (DivideByZeroException e) {

                System.out.println(
                    "Calculation Error: " + e.getMessage()
                );
            }
            catch (IllegalArgumentException e) {

                System.out.println(
                    "Input Error: " + e.getMessage()
                );

                sc.nextLine();
            }
            finally {

                System.out.println(
                    "Attempt " + attempt + " completed/logged."
                );
            }
        }
        System.out.println("\nCalculator finished successfully.");

        sc.close();
    }
}