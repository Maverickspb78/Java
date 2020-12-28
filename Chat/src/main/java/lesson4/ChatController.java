package lesson4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    private final ArrayList<String> arrTemp = new ArrayList<>();
    private final ArrayList<String> arrayList = new ArrayList<>();
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

        reader.stop();


        FileHistoryService.getInstance().save(Collections.singletonList(output.getText()));
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        userName = NetworkService.getInstance().getUserName();
        reader = new CharReader(output, NetworkService.getInstance().getInputStream());
        reader.start();

        FileHistoryService.getInstance().load().forEach(historyLine -> {
            arrTemp.add(historyLine + "\n");
        });
        if (arrTemp.size() <= 10) {
            FileHistoryService.getInstance().load().forEach(historyLine -> {
                output.appendText(historyLine + "\n");
            });
        } else {
            for (int i = (arrTemp.size() - 10); i < arrTemp.size(); i++) {
                output.appendText(FileHistoryService.getInstance().load().get(i) + "\n");

            }
        }

    }
}