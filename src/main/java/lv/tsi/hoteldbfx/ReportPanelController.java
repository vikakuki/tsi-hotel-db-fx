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
@FxmlView("/reportPanel.fxml")
public class ReportPanelController {
    private final FxWeaver fxWeaver;

    public ReportPanelController(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button logOutBtn;

    @FXML
    private Button clientBtn;

    @FXML
    private Button biilsBtn;

    @FXML
    private Button roomsBtn;

    @FXML
    private Button reservationBtn;

    @FXML
    private Button workerBtn;

    @FXML
    void initialize() {
        clientBtn.setCursor(Cursor.HAND);
        workerBtn.setCursor(Cursor.HAND);
        roomsBtn.setCursor(Cursor.HAND);
        reservationBtn.setCursor(Cursor.HAND);
        biilsBtn.setCursor(Cursor.HAND);
        Stage stage = new Stage();
        stage.setTitle("Hotel Database management");


        roomsBtn.setOnAction(event -> {
            roomsBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(RoomsViewController.class), 626, 417));
            stage.showAndWait();
        });

        clientBtn.setOnAction(event -> {
            clientBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(ClientsViewController.class), 626, 417));
            stage.showAndWait();
        });

        workerBtn.setOnAction(event -> {
            workerBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(WorkersViewController.class), 626, 417));
            stage.showAndWait();
        });

        biilsBtn.setOnAction(event -> {
            biilsBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(BillsViewController.class), 626, 417));
            stage.showAndWait();
        });
    }
}
