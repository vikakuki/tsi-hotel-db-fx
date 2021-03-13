package lv.tsi.hoteldbfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lv.tsi.hoteldbfx.domain.Bill;
import lv.tsi.hoteldbfx.domain.BillRepository;
import lv.tsi.hoteldbfx.domain.Reservation;
import lv.tsi.hoteldbfx.domain.ReservationRepository;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("/reservationsTable.fxml")
public class ReservationsViewController {
    private ReservationRepository reservationRepository;
    private final FxWeaver fxWeaver;

    private final ObservableList<Reservation> bills;

    @Autowired
    public ReservationsViewController(ReservationRepository reservationRepository, FxWeaver fxWeaver) {
        this.reservationRepository = reservationRepository;
        this.fxWeaver = fxWeaver;
        List<Reservation> reservationList = reservationRepository.findAll();
        bills = FXCollections.observableArrayList(reservationList);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Reservation> reservationTable;

    @FXML
    private TableColumn<Reservation, Long> id;

    @FXML
    private TableColumn<Reservation, Date> checkIn;

    @FXML
    private TableColumn<Reservation, Date> checkOut;

    @FXML
    private TableColumn<Reservation, Long> billId;

    @FXML
    private TableColumn<Reservation, Long> clientId;

    @FXML
    private TableColumn<Reservation, Long> roomId;

    @FXML
    private TextField reportId;

    @FXML
    private Button reportBtn;

    @FXML
    private Button backBtn;

    @FXML
    void initialize() {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        checkIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        checkOut.setCellValueFactory(new PropertyValueFactory<>("checkOut"));
        clientId.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        billId.setCellValueFactory(new PropertyValueFactory<>("billId"));
        roomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));


        reservationTable.setItems(bills);

        Stage stage = new Stage();
        stage.setTitle("Hotel Database Management");

        backBtn.setCursor(Cursor.HAND);
        backBtn.setOnAction(event -> {
            backBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(WorkerPanelController.class), 626, 417));
            stage.showAndWait();
        });
    }

}
