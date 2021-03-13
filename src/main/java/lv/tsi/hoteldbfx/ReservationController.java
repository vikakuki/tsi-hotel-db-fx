package lv.tsi.hoteldbfx;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lv.tsi.hoteldbfx.domain.RoomRepository;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/reservationDetails.fxml")
public class ReservationController {
    private RoomRepository roomRepository;
    private final FxWeaver fxWeaver;


    @Autowired
    public ReservationController(RoomRepository roomRepository, FxWeaver fxWeaver) {
        this.roomRepository = roomRepository;
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
    void initialize() {



    }

}
