package lv.tsi.hoteldbfx;


import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lv.tsi.hoteldbfx.domain.*;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

@Component
@FxmlView("/reservationDetails.fxml")
public class ReservationController {
    private RoomRepository roomRepository;
    private ReservationRepository reservationRepository;
    private ClientRepository clientRepository;
    private BillRepository billRepository;
    private final FxWeaver fxWeaver;


    @Autowired
    public ReservationController(RoomRepository roomRepository, ReservationRepository reservationRepository,
                                 ClientRepository clientRepository, BillRepository billRepository, FxWeaver fxWeaver) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
        this.billRepository = billRepository;
        this.fxWeaver = fxWeaver;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lookingId;

    @FXML
    private TextField clientId;

    @FXML
    private TextField clientBirthDate;

    @FXML
    private DatePicker checkInDate;

    @FXML
    private TextField clientName;

    @FXML
    private TextField clientCity;

    @FXML
    private TextField clientSurname;

    @FXML
    private TextField clientCountry;

    @FXML
    private Button updateBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextField clientEmail;

    @FXML
    private TextField clientPhone;

    @FXML
    private TextField clientGender;

    @FXML
    private TextField roomId;

    @FXML
    private TextField roomCategory;

    @FXML
    private TextField roomView;

    @FXML
    private TextField roomFloor;

    @FXML
    private TextField roomPrice;

    @FXML
    private TextField billId;

    @FXML
    private DatePicker checkOutDate;

    @FXML
    private DatePicker todayDate;

    @FXML
    private TextField paymentSumm;

    @FXML
    private Button addNewBtn;

    @FXML
    private Button findBtn;

    @FXML
    private TextField workerId;

    @FXML
    private Button backBtn;


    @FXML
    void initialize() {
        Stage stage = new Stage();
        stage.setTitle("Hotel Database Management");

        backBtn.setCursor(Cursor.HAND);
        backBtn.setOnAction(event -> {
            backBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(WorkerPanelController.class), 626, 417));
            stage.setTitle("Hotel Database Management");
            stage.showAndWait();
        });

        findBtn.setCursor(Cursor.HAND);
        findBtn.setOnAction(event -> {
            findBtn.getScene().getWindow().hide();

            long reservationId = Long.parseLong(lookingId.getText());
            Reservation reservation = reservationRepository.findReservationBy(reservationId);

            if (reservation == null) {
                return;
            }

            Client client = reservation.getClient();
            Client clientById = clientRepository.findClientById(client.getId());
            clientId.setText(String.valueOf(clientById.getId()));
            Profile profile = clientById.getProfile();
            clientName.setText(profile.getName());
            clientSurname.setText(profile.getSurname());
            clientBirthDate.setText(profile.getBirthDate().toString());
            clientEmail.setText(profile.getEmail());
            clientPhone.setText(String.valueOf(profile.getPhoneNumber()));
            clientGender.setText(clientById.getGender());
            clientCountry.setText(clientById.getCountry());
            clientCity.setText(clientById.getCity());

            Room room = reservation.getRoom();
            Room roomById = roomRepository.findRoomById(room.getId());
            roomId.setText(String.valueOf(roomById.getId()));
            roomCategory.setText(roomById.getCategory());
            roomView.setText(roomById.getView());
            roomFloor.setText(String.valueOf(roomById.getFloor()));
            roomPrice.setText(String.valueOf(roomById.getPrice()));

            /*
            Bill bill = reservation.getBill();

            if (bill != null) {
                billId.setText(String.valueOf(bill.getId()));
                Bill billBy = billRepository.findBillBy(bill.getId());
                paymentSumm.setText(String.valueOf(billBy.getPrice()));
            }

            checkInDate.setValue(reservation.getCheckIn().toLocalDate());
            checkOutDate.setValue(reservation.getCheckOut().toLocalDate());
            Date date = new Date();
            LocalDate today = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            todayDate.setValue(today);
*/

        });

        addNewBtn.setCursor(Cursor.HAND);
        addNewBtn.setOnAction(event -> {
            addNewBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(MakeReservationController.class), 626, 417));
            stage.setTitle("Hotel Database Management");
            stage.showAndWait();
        });

    }

}
