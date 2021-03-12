package lv.tsi.hoteldbfx;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/workerPanel.fxml")
public class WorkerPanelController {
    private final FxWeaver fxWeaver;

    public WorkerPanelController( FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @FXML
    private Group root;

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
        clientBtn.setCursor(Cursor.HAND);
        clientBtn.setOnMouseClicked(event -> {
            clientBtn.getScene().getWindow().hide();

            Stage stage = new Stage();
            stage.setScene(new Scene(fxWeaver.loadView(ClientDetailsController.class), 626, 417));
            stage.showAndWait();
        });



    }
}
