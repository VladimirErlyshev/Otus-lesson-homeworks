package ru.verlyshev.homeworks.lesson142;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        firstImpl();
        secondImpl();
    }

    private static void firstImpl() {
        var start = System.nanoTime();
        var arr = new double[100_000_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = calculateElement(i);
        }
        var end = System.nanoTime();
        System.out.println("Выполнился за " + (end - start) + " мс");
    }

    private static void secondImpl() throws InterruptedException {
        var start = System.nanoTime();
        var arr = new double[100_000_000];
        var t1 = new Thread(() -> {
            for (int i = 0; i < 25_000_000; i++) {
                arr[i] = calculateElement(i);
            }
        });

        var t2 = new Thread(() -> {
            for (int i = 25_000_000; i < 50_000_000; i++) {
                arr[i] = calculateElement(i);
            }
        });

        var t3 = new Thread(() -> {
            for (int i = 50_000_000; i < 75_000_000; i++) {
                arr[i] = calculateElement(i);
            }
        });

        var t4 = new Thread(() -> {
            for (int i = 75_000_000; i < arr.length; i++) {
                arr[i] = calculateElement(i);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        var end = System.nanoTime();
        System.out.println("Выполнился за " + (end - start) + " мс");
    }

    private static double calculateElement(int i) {
        return 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
    }
}
