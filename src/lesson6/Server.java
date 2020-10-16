package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args)  {
        ServerSocket server = null;
        Socket socket = null;
        final int PORT = 8188;
        Scanner scanner = new Scanner(System.in);

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");
            socket = server.accept();
            System.out.println("Client connected");
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            new Thread (()->{
                try{
                    while (true){
                        output.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            while (true){
                String text = input.readUTF();
                if(text.equals("/close")){
                    System.out.println("Connection lost");
                    break;
                }else {
                    System.out.println(text);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException |NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}