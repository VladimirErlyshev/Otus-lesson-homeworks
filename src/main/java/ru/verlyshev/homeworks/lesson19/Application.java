package ru.verlyshev.homeworks.lesson19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        var directory = new File(".");
        System.out.println("Список текстовых файлов в корневой директории проекта:");
        System.out.println(Arrays.toString(Arrays.stream(directory.listFiles())
                .map(File::getName)
                .filter(name -> name.contains(".txt")).toArray()));

        System.out.println("Введите имя файла: ");
        var scanner = new Scanner(System.in);
        var fileName = scanner.nextLine();

        if (!Arrays.asList(directory.list()).contains(fileName)) {
            System.out.println("Указанного файла нет в текущем каталоге");
        } else {
            try (var in = new InputStreamReader(new BufferedInputStream(new FileInputStream(fileName)))) {
                System.out.println("Содержимое файла: ");
                var n = in.read();
                while (n != -1) {
                    System.out.print((char) n);
                    n = in.read();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            try (var out = new BufferedOutputStream(new FileOutputStream(fileName, true))) {
                System.out.println("\nВведите строку для записи:");
                var outData = scanner.nextLine();
                var buffer = outData.getBytes(StandardCharsets.UTF_8);

                out.write(buffer);

                System.out.println("Строка успешно записана");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
