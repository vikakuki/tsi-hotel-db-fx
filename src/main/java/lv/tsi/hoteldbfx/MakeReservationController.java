package lv.tsi.hoteldbfx;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lv.tsi.hoteldbfx.domain.Client;
import lv.tsi.hoteldbfx.domain.ClientRepository;
import lv.tsi.hoteldbfx.domain.Room;
import lv.tsi.hoteldbfx.domain.RoomRepository;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
@FxmlView("/reservationMake.fxml")
public class MakeReservationController {
    private RoomRepository roomRepository;
    private final FxWeaver fxWeaver;
    private ClientRepository clientRepository;

    @Autowired
    public MakeReservationController(RoomRepository roomRepository, ClientRepository clientRepository, FxWeaver fxWeaver) {
        this.roomRepository = roomRepository;
        this.fxWeaver = fxWeaver;
        this.clientRepository = clientRepository;
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
    private TextField personalCodeLbl;

    @FXML
    private TextField roomCategory;

    @FXML
    private TextField errorMsg;

    @FXML
    private TextField roomView;

    @FXML
    private TextField roomFloor;

    @FXML
    private TextField roomPrice;

    @FXML
    private Button saveBtn;

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
        saveBtn.setCursor(Cursor.HAND);
        findClientBtn.setCursor(Cursor.HAND);
        findClientBtn.setCursor(Cursor.HAND);
        Stage stage = new Stage();
        stage.setTitle("Hotel Database Management");

        backBtn.setOnAction(event -> {
            backBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(WorkerPanelController.class), 626, 417));
            stage.showAndWait();
        });

        findClientBtn.setOnAction(event -> {
            long id = Long.parseLong(clientId.getText());
            Optional<Client> client = Optional.of(clientRepository.findClientById(id));

            if (client.isPresent()) {
                clientName.setText(client.get().getProfile().getName());
                clientSurname.setText(client.get().getProfile().getSurname());
                personalCodeLbl.setText(String.valueOf(client.get().getProfile().getPersonalCode()));
                return;
            }

            showError("Client is not found");
        });

        findRoomBtn.setOnAction(event -> {
            long id = Long.parseLong(roomId.getText());
            Optional<Room> room = Optional.of(roomRepository.findRoomById(id));

            if (room.isPresent()) {
                Room myRoom = room.get();
                roomCategory.setText(myRoom.getCategory());
                roomFloor.setText(String.valueOf(myRoom.getFloor()));
                roomPrice.setText(String.valueOf(myRoom.getPrice()));
                roomView.setText(myRoom.getView());
                return;
            }

            showError("Room is not found");
        });

        saveBtn.setOnAction(event -> {
            saveBtn.getScene().getWindow().hide();


        });

    }

    private void showError(String msg) {
        errorMsg.setVisible(true);
        errorMsg.setText(msg);
        errorMsg.setStyle("-fx-text-inner-color: red;");
    }

}
