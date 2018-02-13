package ru.jchat.core.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[ ] args){
        try (ServerSocket serverSocket = new ServerSocket(8181)) {

            System.out.println("Сервер запущен. Ожидание клиента...");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент успешно присоединился к серверу.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String message = in.readUTF();
                System.out.println("Клиент: " + message);
                out.writeUTF("echo: " + message);

                if (message.equals("/end")) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
