package lv.tsi.hoteldbfx;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button workerLoginBtn;

    @FXML
    void initialize() {
        workerLoginBtn.setOnAction(event -> {
            workerLoginBtn.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            FileInputStream file = null;

            try {
                file = new FileInputStream("src/main/resources/workerPanel.fxml");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            try {
                loader.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }
}
