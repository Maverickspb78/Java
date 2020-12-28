package lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

public class AuthController {

    public TextField login;
    public TextField password;
    public Label labelAuth;
    //    private NetworkService service = new NetworkService();
    Message message = new Message();


    public void enter(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        try {
            NetworkService.getInstance();


            String msg = String.format("/auth %s %s", login.getText(), password.getText());
            message.setMessage(msg);
            NetworkService.getInstance().write(message);
            message = NetworkService.getInstance().read();
            System.out.println(message);
            System.out.println(message.toString());
            String[] data = message.getMessage().split(" ");
            System.out.println(Arrays.toString(data));


            if (message.getMessage().equals("accept")) {

                Parent chat = FXMLLoader.load(getClass().getResource("chat.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Сетевой чат");
                stage.setScene(new Scene(chat));
                stage.setResizable(false);
                stage.show();
                login.getScene().getWindow().hide();

            } else {
                labelAuth.setText("WRONG LOGIN OR PASSWORD");
                login.clear();
                password.clear();
            }
        } catch (Exception e) {
            System.out.println("disconnect");
            NetworkService.getInstance().close();
        }
    }

    public void reg(ActionEvent actionEvent) throws IOException {

        Parent chat = FXMLLoader.load(getClass().getResource("registration.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(chat));
        stage.setResizable(false);
        stage.show();
        login.getScene().getWindow().hide();
    }

    public void quit(ActionEvent actionEvent) throws IOException {
        Parent chat = FXMLLoader.load(getClass().getResource("auth.fxml"));
    }


}
