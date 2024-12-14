package ru.netology.nikolaJ80.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] answers = {"Nikola", "45", "Russia"};
        String host = "netology.homework";
        int port = 8089;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String resp = "";
            for (String str : answers) {
                resp = in.readLine();
                System.out.println(resp);

                out.println(in);
                System.out.printf("Written: %s\n", str);
            }

            resp = in.readLine();
            System.out.println(resp);

        }
    }
}
