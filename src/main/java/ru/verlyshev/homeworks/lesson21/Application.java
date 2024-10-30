package ru.verlyshev.homeworks.lesson21;

import java.util.concurrent.Executors;

public class Application {
    private static final Object monitor = new Object();
    private static char lastChar = 'C';

    public static void main(String[] args) {
        var executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> print('A', 'C'));
        executorService.execute(() -> print('B', 'A'));
        executorService.execute(() -> print('C', 'B'));
        executorService.shutdown();

    }

    private static void print(char printChar, char waitChar) {
        synchronized (monitor) {
            for (int i = 0; i < 5; i++) {
                while (lastChar != waitChar) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(printChar);
                lastChar = printChar;
                monitor.notifyAll();
            }
        }
    }

}
