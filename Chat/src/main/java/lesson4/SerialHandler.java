package lesson4;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

public class SerialHandler implements Closeable, Runnable {

    private static int cnt = 0;
    private final ObjectInputStream is;
    private final ObjectOutputStream os;
    private final byte[] buffer;
    private final EchoServer server;
    String login;
    String pass;
    UserSQLLiteDao dao = new UserSQLLiteDao();
    User user = new User(null, null);
    private String userName;
    private boolean running;


    public SerialHandler(Socket socket, EchoServer server) throws IOException, SQLException, ClassNotFoundException {

        os = new ObjectOutputStream(socket.getOutputStream());
        is = new ObjectInputStream(socket.getInputStream());
        cnt++;
        userName = "user#" + cnt;
        running = true;
        buffer = new byte[256];
        this.server = server;
//        os.writeObject(Message.of(userName, "OK"));
//        os.flush();

    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Message message = (Message) is.readObject();
                if (message.getMessage().startsWith("/changeNick")) {
                    String[] data = message.getMessage().split(" ");
                    String oldName = userName;
                    userName = data[1];
                    String msg = String.format("User %s change name to %s", oldName, userName);
                    sendMessage(Message.of(userName, msg));
                    dao.getUserByLogin(oldName).setNikName(userName);
                    continue;
                }
                if (message.getMessage().startsWith("/private")) {
                    String[] data = message.getMessage().split(" ");
                    String nick = data[1];
                    String msg = data[2];
                    sendMessage(message);
                    server.sendMessageTo(userName, nick, msg);
                    continue;
                }
                if (message.getMessage().startsWith("/auth")) {
                    String[] data = message.getMessage().split(" ");
                    login = data[1];
                    pass = data[2];
                    user = dao.getUserByLogin(login);
                    if (user.getPassword() == null) {

                        os.writeObject(Message.of(userName, "close"));
                        os.flush();
                        server.kickMe(this);
                        continue;
                    }
                    if (user.getPassword().equals(pass)) {

                        os.writeObject(Message.of(userName, "accept"));
                        os.flush();
                        userName = user.getNikName();
                        continue;

                    } else {
                        os.writeObject(Message.of(userName, "close"));
                        os.flush();
                        server.kickMe(this);
                    }

                    continue;
                }

                if (message.getMessage().startsWith("/reg")) {
                    String[] data = message.getMessage().split(" ");
                    login = data[1];
                    pass = data[2];
                    userName = data[3];
                    user = dao.getUserByLogin(login);
                    if (user.getLogin() == null) {
                        user.setLogin(login);
                        user.setPassword(pass);
                        user.setNikName(userName);
                        dao.addUser(user);
                        os.writeObject(Message.of(userName, "true"));
                    } else {
                        os.writeObject(Message.of(userName, "false"));
                        os.flush();
                    }

                    continue;
                }

                message.setAuthor(userName);
                System.out.println(message);
                server.broadCast(message);
            } catch (IOException | ClassNotFoundException | SQLException e) {
                System.err.println("Exception while read");
                break;
            }
        }
    }

    public User getUser() {
        return user;
    }

    public void sendMessage(Message message) throws IOException {
        os.writeObject(message);
        os.flush();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void close() throws IOException {
        os.close();
        is.close();
    }
}