package lv.tsi.hoteldbfx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class WorkerPanelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logOutBtn;

    @FXML
    private ImageView clientBtn;

    @FXML
    private ImageView settingsBtn;

    @FXML
    private ImageView checksBtn;

    @FXML
    private ImageView roomsBtn;

    @FXML
    private ImageView reservationBtn;

    @FXML
    private ImageView workerBtn;

    @FXML
    void initialize() {
/*
        clientBtn.setOnAction(event -> {
            clientBtn.getScene().getWindow().hide();

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
*/

    }
}
