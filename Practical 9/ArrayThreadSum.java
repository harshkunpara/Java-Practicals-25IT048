class SharedTotal {
    long total = 0;

    void add(long value) {
        total += value;
    }

    synchronized void synchronizedAdd(long value) {
        total += value;
    }
}

public class ArrayThreadSum {
    static final int SIZE = 1000000;
    static final int THREADS = 4;

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        SharedTotal unsafe = new SharedTotal();
        Thread[] threads = new Thread[THREADS];

        int part = SIZE / THREADS;

        long start = System.nanoTime();

        for (int i = 0; i < THREADS; i++) {
            int startIndex = i * part;
            int endIndex = (i + 1) * part;

            threads[i] = new Thread(() -> {
                for (int j = startIndex; j < endIndex; j++) {
                    unsafe.add(arr[j]);
                }
            });

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long end = System.nanoTime();

        System.out.println("Wrong shared total: " + unsafe.total);
        System.out.println("Time: " + (end - start) / 1000000.0 + " ms");

        SharedTotal safe = new SharedTotal();

        start = System.nanoTime();

        for (int i = 0; i < THREADS; i++) {
            int startIndex = i * part;
            int endIndex = (i + 1) * part;

            threads[i] = new Thread(() -> {
                for (int j = startIndex; j < endIndex; j++) {
                    safe.synchronizedAdd(arr[j]);
                }
            });

            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        end = System.nanoTime();

        System.out.println("Synchronized total: " + safe.total);
        System.out.println("Time: " + (end - start) / 1000000.0 + " ms");
    }
}