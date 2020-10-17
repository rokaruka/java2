package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private List<ClientHandler> clients;
    private AuthService authService;

    public Server() {
        clients = new CopyOnWriteArrayList<>();
        authService = new SimpleAuthService();
        ServerSocket server = null;
        Socket socket = null;
        final int PORT = 8189;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            while (true) {
                socket = server.accept();
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(ClientHandler sender, String msg) {
        String message = String.format("[ %s ]: %s", sender.getNickname(), msg);
        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }
    public void prMsg(ClientHandler sender,String recipient, String msg) {
        String message = String.format("[ %s ]>>>[ %s ]: %s", sender.getNickname(),recipient, msg);
        for (ClientHandler c : clients) {
            if (c.getNickname().equals(recipient)) {
                c.sendMsg(message);
                if(!sender.getNickname().equals(recipient)){
                    sender.sendMsg(message);
                }
                return;
            }
        }
        sender.sendMsg(String.format("Client %s do not found", recipient));
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public AuthService getAuthService() {
        return authService;
    }
}
