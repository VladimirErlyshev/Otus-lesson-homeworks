package ru.verlyshev.homeworks.lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Введите число от 1 до 5");

        var scanner = new Scanner(System.in);
        var command = scanner.nextInt();
        var random = new Random();

        switch (command) {
            case 1 -> greetings();
            case 2 -> checkSign(random.nextInt(), random.nextInt(), random.nextInt());
            case 3 -> selectColor();
            case 4 -> compareNumbers();
            case 5 -> addOrSubtractAndPrint(random.nextInt(), random.nextInt(), random.nextBoolean());
            default -> System.out.println("Введен некорректный номер команды");
        }
    }

    static void greetings() {
        var greetingWords = Arrays.asList("Hello", "World", "from", "Java");
        greetingWords.forEach(System.out::println);
    }

    static void checkSign(int a, int b, int c) {
        var sum = a + b + c;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    static void selectColor() {
        var random = new Random();
        var data = random.nextInt(30);

        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        var random = new Random();

        var a = random.nextInt();
        var b = random.nextInt();

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }
}
