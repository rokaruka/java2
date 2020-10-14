package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class Client {
    private static final String IP = "localhost";
    private static final int PORT = 8188;

    public static void main(String[] args) {
        Socket socket;
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket(IP,PORT);
            System.out.println("Connect to server");
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

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}