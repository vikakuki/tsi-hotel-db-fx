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
import lv.tsi.hoteldbfx.domain.Room;
import lv.tsi.hoteldbfx.domain.RoomRepository;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("/billsTable.fxml")
public class BillsViewController {
    private BillRepository billRepository;
    private final FxWeaver fxWeaver;

    private final ObservableList<Bill> bills;

    @Autowired
    public BillsViewController(BillRepository billRepository, FxWeaver fxWeaver) {
        this.billRepository = billRepository;
        this.fxWeaver = fxWeaver;
        List<Bill> billList = billRepository.findAll();
        bills = FXCollections.observableArrayList(billList);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Bill> billsTable;

    @FXML
    private TableColumn<Bill, ?> id;

    @FXML
    private TableColumn<Bill, Date> date;

    @FXML
    private TableColumn<Bill, Double> price;

    @FXML
    private TableColumn<Bill, Long> clientId;

    @FXML
    private TableColumn<Bill, Long> reservationId;

    @FXML
    private TableColumn<Bill, Long> workerId;

    @FXML
    private TextField reportId;

    @FXML
    private Button reportBtn;

    @FXML
    private Button backBtn;

    @FXML
    void initialize() {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        clientId.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        reservationId.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        workerId.setCellValueFactory(new PropertyValueFactory<>("workerId"));


        billsTable.setItems(bills);

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
