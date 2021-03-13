package lv.tsi.hoteldbfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lv.tsi.hoteldbfx.domain.Room;
import lv.tsi.hoteldbfx.domain.RoomRepository;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("/makeReservation.fxml")
public class MakeReservationController {
    private RoomRepository roomRepository;
    private final FxWeaver fxWeaver;

    private final ObservableList<Room> rooms;

    @Autowired
    public MakeReservationController(RoomRepository roomRepository, FxWeaver fxWeaver) {
        this.roomRepository = roomRepository;
        this.fxWeaver = fxWeaver;
        List<Room> roomList = roomRepository.findAll();
        rooms = FXCollections.observableArrayList(roomList);
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
    void initialize() {




    }

}
