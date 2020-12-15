package lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthController {

    public TextField login;
    public TextField password;
    public Label labelAuth;



    public void enter(ActionEvent actionEvent) throws IOException {
        boolean auth = MockAuthServiceImpl.getInstance()
                .auth(login.getText(), password.getText());
        if (auth) {

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


}
