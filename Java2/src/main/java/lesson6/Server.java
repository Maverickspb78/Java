package lesson6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static ClientHandler clientHandlerhandler;

    public static void main(String[] args) throws IOException {
        Thread readThread = new Thread(() -> {
            try {
                Scanner in = new Scanner(System.in);
                while (in.hasNext()) {
                    String msg = in.next();
                    if (clientHandlerhandler == null) {
                        System.out.println("You have to wait connection");
                        while (clientHandlerhandler == null) {
                            Thread.sleep(500);
                        }
                    }
                    if (clientHandlerhandler.isRunning()) {
                        clientHandlerhandler.sendMessage(msg);
                        if (msg.equals("/quit")) {
                            clientHandlerhandler.setRunning(false);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        readThread.setDaemon(true);
        readThread.start();
        try (ServerSocket server = new ServerSocket(4455)) {
            while (true) {
                Socket socket = server.accept();
                clientHandlerhandler = new ClientHandler(socket);
                new Thread(clientHandlerhandler).start();
            }
        }
    }
}
