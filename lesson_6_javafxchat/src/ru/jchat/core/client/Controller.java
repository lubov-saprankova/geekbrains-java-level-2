package ru.jchat.core.client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextArea textArea;

    @FXML
    TextField msgField;

    private Socket socket;
    private DataOutputStream  out;
    private DataInputStream in;

    final String SERVER_IP = "127.0.0.1";
    final int SERVER_PORT = 8181;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.socket = new Socket(SERVER_IP, SERVER_PORT);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(){

        try {
            out.writeUTF(msgField.getText());
            msgField.clear();
            msgField.requestFocus();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
