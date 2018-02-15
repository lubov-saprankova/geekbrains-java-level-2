package ru.jchat.core.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

class Server {
    private Vector<ClientHandler> clients;

    Server() {

        try (ServerSocket serverSocket = new ServerSocket(8181)) {
            clients = new Vector<>();
            System.out.println("Сервер запущен. Ожидание клиента...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Клиент успешно присоединился к серверу.");

                clients.add( new ClientHandler(this, socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void broadcastMessage(String message) {
        for (ClientHandler c : this.clients){
            c.sendMessage(message);
        }
    }

}
