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

public class RegistrationController {

    public TextField login;
    public TextField password;
    public Label msgReg;
    public TextField nikName;
    Message message = new Message();

    public void enter(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        try {
            NetworkService.getInstance();

            String msg = String.format("/reg %s %s %s", login.getText(), password.getText(), nikName.getText());
            message.setMessage(msg);
            NetworkService.getInstance().write(message);
            message = NetworkService.getInstance().read();
            System.out.println(message);

            if (message.getMessage().equals("true")) {

                Parent chat = FXMLLoader.load(getClass().getResource("chat.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Сетевой чат");
                stage.setScene(new Scene(chat));
                stage.setResizable(false);
                stage.show();
                login.getScene().getWindow().hide();

            } else {
                msgReg.setText("WRONG LOGIN OR NickName");
//                    login.clear();
//                    password.clear();
            }

        } catch (Exception e) {
            System.out.println("disconnect");
            NetworkService.getInstance().close();
        }

//        MockAuthServiceImpl.getInstance().addUser(false, login.getText(), password.getText(), nikName.getText());

//        String msg = String.format("/auth %s %s", login, password);
//        message.setMessage(msg);
//        service.write(message);
        if (MockAuthServiceImpl.getInstance().isAccept()) {
            Parent chat = FXMLLoader.load(getClass().getResource("chat.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Сетевой чат");
            stage.setScene(new Scene(chat));
            stage.setResizable(false);
            stage.show();

            login.getScene().getWindow().hide();
        }
        msgReg.setText("This user already exists");
    }

}
