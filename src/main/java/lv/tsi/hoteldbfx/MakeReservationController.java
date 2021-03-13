package lv.tsi.hoteldbfx;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lv.tsi.hoteldbfx.domain.RoomRepository;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/reservationMake.fxml")
public class MakeReservationController {
    private RoomRepository roomRepository;
    private final FxWeaver fxWeaver;


    @Autowired
    public MakeReservationController(RoomRepository roomRepository, FxWeaver fxWeaver) {
        this.roomRepository = roomRepository;
        this.fxWeaver = fxWeaver;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField clientId;

    @FXML
    private TextField clientName;

    @FXML
    private TextField clientSurname;

    @FXML
    private TextField roomCategory;

    @FXML
    private TextField roomView;

    @FXML
    private TextField roomFloor;

    @FXML
    private TextField roomPrice;

    @FXML
    private Button addNewBtn;

    @FXML
    private Button findRoomBtn;

    @FXML
    private TextField roomId;

    @FXML
    private Button findClientBtn;

    @FXML
    private DatePicker checkInDate;

    @FXML
    private DatePicker checkOutDate;

    @FXML
    private Button backBtn;

    @FXML
    void initialize() {
        backBtn.setCursor(Cursor.HAND);
        addNewBtn.setCursor(Cursor.HAND);
        Stage stage = new Stage();
        stage.setTitle("Hotel Database Management");

        backBtn.setOnAction(event -> {
            backBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(WorkerPanelController.class), 626, 417));
            stage.setTitle("Hotel Database Management");
            stage.showAndWait();
        });

        addNewBtn.setOnAction(event -> {
            addNewBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(MakeReservationController.class), 626, 417));
            stage.setTitle("Hotel Database Management");
            stage.showAndWait();
        });

    }

}
