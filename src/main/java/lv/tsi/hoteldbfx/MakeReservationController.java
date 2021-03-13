package lv.tsi.hoteldbfx;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lv.tsi.hoteldbfx.domain.*;
import lv.tsi.hoteldbfx.service.ReservationService;
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
    private ReservationService reservationService;

    @Autowired
    public MakeReservationController(RoomRepository roomRepository, ClientRepository clientRepository, ReservationService reservationService, FxWeaver fxWeaver) {
        this.roomRepository = roomRepository;
        this.reservationService = reservationService;
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
            Client client = clientRepository.findClientById(id);

            if (client != null) {
                clientName.setText(client.getProfile().getName());
                clientSurname.setText(client.getProfile().getSurname());
                personalCodeLbl.setText(String.valueOf(client.getProfile().getPersonalCode()));
                return;
            }

            showError("Client is not found");
        });

        findRoomBtn.setOnAction(event -> {
            int id = Integer.parseInt(roomId.getText());
            Room room = roomRepository.findRoomById(id);

            if (room != null) {
                roomCategory.setText(room.getCategory());
                roomFloor.setText(String.valueOf(room.getFloor()));
                roomPrice.setText(String.valueOf(room.getPrice()));
                roomView.setText(room.getView());
                return;
            }

            showError("Room is not found");
        });

        saveBtn.setOnAction(event -> {

            long clientPersonalCode = Long.parseLong(personalCodeLbl.getText());
            int roomId = Integer.parseInt(this.roomId.getText());

            Optional<Reservation> reservation = reservationService.createReservation(clientPersonalCode, checkInDate.getValue(), checkOutDate.getValue(), roomId);

            if (reservation.isPresent()) {

                return;
            }

            showError("Reservation was not made");
        });

    }

    private void showError(String msg) {
        errorMsg.setVisible(true);
        errorMsg.setText(msg);
        errorMsg.setStyle("-fx-text-inner-color: red;");
    }

}
