package ru.verlyshev.homeworks.lesson20;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("Введите название файла:");
        var scanner = new Scanner(System.in);
        var fileName = scanner.nextLine();
        try (var bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            var bytes = bufferedInputStream.readAllBytes();
            var data = new String(bytes, StandardCharsets.UTF_8);
            System.out.println("Введите искомую последовательность:");
            var targetWord = scanner.nextLine();
            if (targetWord.length() > data.length()) {
                System.out.println("Длина искомой последовательности не может быть " +
                        "больше, чем длина строки в файле");
            } else {
                var pattern = Pattern.compile("\\b%s(?!\\w)".format(targetWord));
                var matcher = pattern.matcher(data);
                var wordCount = 0;
                while (matcher.find()) {
                    wordCount++;
                }

                System.out.println("Количество вхождений искомой последовательности в тексте " + wordCount);
            }
        } catch (IOException e) {
            System.out.println("Искомый файл не найден!");
        }
    }
}
