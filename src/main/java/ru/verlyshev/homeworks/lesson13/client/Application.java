package ru.verlyshev.homeworks.lesson13.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Application {

    public static void main(String[] args) {
        try {
            try (var clientSocket = new Socket("localhost", 8888)) {
                System.out.println("Клиент запущен");
                var reader = new BufferedReader(new InputStreamReader(System.in));
                var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                var out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                var operation = in.readLine();
                System.out.println(operation);
                var message = reader.readLine();
                out.write(message + "\n");
                out.flush();
                var serverWord = in.readLine();
                System.out.println(serverWord);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
