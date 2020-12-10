package lesson4;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Message implements Serializable {

    private static final SimpleDateFormat format = new SimpleDateFormat("[HH:mm:ss dd.MM.yy ]");
    private Date sendAt;
    private String author;
    private String message;

    public Message() {
    }

    public static Message of(String author, String message) {
        Message m = new Message();
        m.setAuthor(author);
        m.setMessage(message);
        m.setSendAt(new Date());
        return m;
    }

    public Date getSendAt() {
        return sendAt;
    }

    public void setSendAt(Date sendAt) {
        this.sendAt = sendAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %s\n", format.format(sendAt), author, message);
    }
}