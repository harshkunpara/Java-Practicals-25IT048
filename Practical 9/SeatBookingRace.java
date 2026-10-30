class TicketCounter {
    int seatsLeft = 5;

    void book(String name) {
        if (seatsLeft > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            seatsLeft--;
            System.out.println(name + " booked a seat");
        }
    }

    synchronized void synchronizedBook(String name) {
        if (seatsLeft > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            seatsLeft--;
            System.out.println(name + " booked a seat");
        }
    }
}

public class SeatBookingRace {
    public static void main(String[] args) throws InterruptedException {
        TicketCounter c1 = new TicketCounter();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            String name = "User-" + (i + 1);
            threads[i] = new Thread(() -> c1.book(name));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Seats left without synchronization: " + c1.seatsLeft);

        TicketCounter c2 = new TicketCounter();

        for (int i = 0; i < 10; i++) {
            String name = "User-" + (i + 1);
            threads[i] = new Thread(() -> c2.synchronizedBook(name));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Seats left with synchronization: " + c2.seatsLeft);
    }
}