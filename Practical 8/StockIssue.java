import java.util.*;

class OutOfStockException extends Exception {

    private int shortfall;

    public OutOfStockException(String message, int shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {

    public InvalidQuantityException(String message) {
        super(message);
    }
}
class Warehouse {
    private Map<String, Integer> stock;
    public Warehouse() {

        stock = new HashMap<>();
        stock.put("Laptop", 10);
        stock.put("Mouse", 5);
        stock.put("Keyboard", 8);
        stock.put("Monitor", 3);
    }
    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than 0."
            ); }

        if (!stock.containsKey(item)) {
            System.out.println(
                "Item '" + item + "' does not exist."
            );
            return;}

        int available = stock.get(item);
        if (qty > available) {
            int shortfall = qty - available;
            throw new OutOfStockException(
                "Not enough stock for " + item,
                shortfall
            );
        }

        stock.put(item, available - qty);

        System.out.println(
            "Issued " + qty + " " + item +
            "(s) successfully."
        );
    }
    public void displayStock() {

        System.out.println("\n--- Current Stock ---");

        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(
                entry.getKey() + " : " +
                entry.getValue()
            );}}}

public class  StockIssue{

    public static void main(String[] args) {
           Warehouse warehouse = new Warehouse();

        String[][] requests = {
            {"Laptop", "3"},
            {"Mouse", "10"},
            {"Keyboard", "-2"},
            {"Monitor", "2"},
            {"Laptop", "20"},
            {"Mouse", "2"}
        };


        for (String[] request : requests) {

            String item = request[0];
            int qty = Integer.parseInt(request[1]);

            System.out.println(
                "\nRequest: " + item + " x " + qty
            );
            try {
                warehouse.issue(item, qty);
            }
            catch (OutOfStockException e) {
                System.out.println(
                    "Out of Stock: " +
                    e.getMessage()
                );

                System.out.println(
                    "Shortfall: " +
                    e.getShortfall()
                );
            }
            catch (InvalidQuantityException e) {
                System.out.println(
                    "Invalid Quantity: " +
                    e.getMessage()
                );
            }
        }
        warehouse.displayStock();
    }
}