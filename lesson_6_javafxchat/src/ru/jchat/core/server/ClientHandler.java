package ru.jchat.core.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    public ClientHandler(Socket socket){
        this.socket = socket;

        try {
            this.out = new DataOutputStream(this.socket.getOutputStream());
            this.in = new DataInputStream(this.socket.getInputStream());

            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        String message = in.readUTF();
                        System.out.println("Клиент: " + message);
                        out.writeUTF("echo: " + message);

                        if (message.equals("/end")) break;
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });


        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
