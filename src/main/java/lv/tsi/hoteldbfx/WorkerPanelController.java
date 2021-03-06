package lv.tsi.hoteldbfx;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;


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
    private ImageView reportBtn;

    @FXML
    private ImageView reservationBtn;

    @FXML
    private ImageView workerBtn;

    @FXML
    void initialize() {
        clientBtn.setCursor(Cursor.HAND);
        workerBtn.setCursor(Cursor.HAND);
        reportBtn.setCursor(Cursor.HAND);
        Stage stage = new Stage();
        stage.setTitle("Hotel Database Management");

        clientBtn.setOnMouseClicked(event -> {
            clientBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(ClientDetailsController.class), 626, 417));
            stage.showAndWait();
        });

        workerBtn.setOnMouseClicked(event -> {
            workerBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(WorkerDetailsController.class), 626, 417));
            stage.showAndWait();
        });

        reportBtn.setOnMouseClicked(event -> {
            reportBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(ReportPanelController.class), 626, 417));
            stage.showAndWait();
        });

        checksBtn.setOnMouseClicked(event -> {
            checksBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(ReservationController.class), 626, 417));
            stage.showAndWait();
        });

        reservationBtn.setOnMouseClicked(event -> {
            reservationBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(ReservationController.class), 626, 417));
            stage.showAndWait();
        });

        logOutBtn.setCursor(Cursor.HAND);
        logOutBtn.setOnAction(event -> {
            logOutBtn.getScene().getWindow().hide();

            Class<LogInController> controllerClass = LogInController.class;
            stage.setScene(new Scene(fxWeaver.loadView(controllerClass), 626, 417));
            stage.showAndWait();
        });
    }
}
