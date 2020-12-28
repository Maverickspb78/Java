package lesson4;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedDeque;

public class EchoServer {

    private final ConcurrentLinkedDeque<SerialHandler> clients = new ConcurrentLinkedDeque<>();
    private boolean running;


    public EchoServer() throws SQLException, ClassNotFoundException {


        running = true;
        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Server started!");
            while (running) {
                System.out.println("Server is waiting connection");
                Socket socket = server.accept();
                System.out.println("Client accepted!");
                SerialHandler handler = new SerialHandler(socket, this);

                new Thread(handler).start();
                System.out.println("Client info: " + socket.getInetAddress());
                System.out.println(handler.getUserName());
                clients.add(handler);
            }
        } catch (Exception e) {
            System.out.println("Server crashed");
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new EchoServer();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void broadCast(Message msg) throws IOException {
        for (SerialHandler client : clients) {
            client.sendMessage(msg);
        }
    }

    public void sendMessageTo(String from, String nick, String message) throws IOException {
        for (SerialHandler client : clients) {
            if (client.getUserName().equals(nick)) {
                client.sendMessage(Message.of(from, message));
            }
        }
    }

    public void kickMe(SerialHandler client) {
        clients.remove(client);
    }

    public ConcurrentLinkedDeque<SerialHandler> getClients() {
        return clients;
    }

}
