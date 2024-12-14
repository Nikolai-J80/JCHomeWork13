package ru.netology.nikolaJ80.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String[] questions = {"Write yor name.", "How old are you?", "What is your country?", "Nice to meet you!"};
        System.out.println("Server starting");
        int port = 8089;
        try (ServerSocket serverSocket = new ServerSocket(port)) { // порт можно выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый, рекомендуем использовать около 8080
            while (true) {
                Socket clientSocket = serverSocket.accept(); // ждем подключения
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());

                out.println(questions[0]);
                final String name = in.readLine();

                out.println(questions[1]);
                final String age = in.readLine();

                out.println(questions[2]);
                final String city = in.readLine();

                out.println(questions[3]);
                //serverSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
