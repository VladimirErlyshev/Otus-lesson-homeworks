package ru.verlyshev.homeworks.lesson13.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;

public class Application {
    public static void main(String[] args) throws IOException {
        try {
            try (var server = new ServerSocket(8888)) {
                System.out.println("Сервер запущен!");
                try (var clientSocket = server.accept()) {
                    var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    var out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    out.write("Список допустимых операций: + сложить - вычесть * умножить / разделить. Введите выражение для подсчета, например 2 2 *\n");
                    out.flush();
                    var message = in.readLine();
                    var data = message.split(" ");
                    out.write("Результат операции " + calculate(data[0], data[1], data[2]) + "\n");
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int calculate(String x, String y, String operation) {
        var arg1 = Integer.parseInt(x);
        var arg2 = Integer.parseInt(y);
        return switch (operation) {
            case "+" -> arg1 + arg2;
            case "-" -> arg1 - arg2;
            case "*" -> arg1 * arg2;
            case "/" -> arg1 / arg2;

            default -> throw new ArithmeticException("Некорректная операция!");
        };
    }
}
