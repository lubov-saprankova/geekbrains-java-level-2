package ru.jchat.core.server;


import java.util.Vector;

public class ServerMain {

    private Vector<ClientHandler> clients;

    public static void main(String[ ] args){

       new Server();

    }
}
