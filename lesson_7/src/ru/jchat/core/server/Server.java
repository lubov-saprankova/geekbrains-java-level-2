package ru.jchat.core.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

class Server {
    private Vector<ClientHandler> clients;
    private AuthService authService = null;

    public AuthService getAuthService() {
        return authService;
    }

    Server() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            clients = new Vector<>();
            authService = new AuthService();
            authService.connect();
            System.out.println("Сервер запущен... Ожидание клиентов...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Клиент присоеденился " + socket.getInetAddress() + " " + socket.getPort() + " " + socket.getLocalPort());
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Не удалось запустить сервис авторизации");
        } finally {
            authService.disconnect();
        }
    }

    void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }
}
