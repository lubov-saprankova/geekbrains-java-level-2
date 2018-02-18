package decilya.jchat.core.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ClientHandler {
    private Server server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;

    ClientHandler(Server server, Socket socket) {

        try {
            this.server = server;
            this.socket = socket;
            this.out = new DataOutputStream(this.socket.getOutputStream());
            this.in = new DataInputStream(this.socket.getInputStream());

            new Thread(() -> {

                try {
                    while (true) {
                        String message = in.readUTF();
                        if (message.equals("/end")) break;
                        this.server.broadcastMessage(message);
                       // sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void sendMessage(String message){
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
