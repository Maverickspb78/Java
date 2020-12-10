package lesson4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    public TextArea output;
    public TextField input;
    private String userName;
    private CharReader reader;

    public void send(ActionEvent actionEvent) throws IOException {
        NetworkService.getInstance()
                .write(Message.of(userName, input.getText()));
        input.clear();
    }

    public void quit(ActionEvent actionEvent) throws IOException {
        reader.setDaemon(true);
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName = NetworkService.getInstance().getUserName();
        reader = new CharReader(output, NetworkService.getInstance().getInputStream());
        reader.start();
    }
}