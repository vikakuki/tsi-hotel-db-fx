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
import lv.tsi.hoteldbfx.domain.Client;
import lv.tsi.hoteldbfx.domain.ClientRepository;
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
@FxmlView("/clientsTable.fxml")
public class ClientsViewController {
    private ClientRepository clientRepository;
    private final FxWeaver fxWeaver;

    private final ObservableList<Client> clients;

    @Autowired
    public ClientsViewController(ClientRepository clientRepository, FxWeaver fxWeaver) {
        this.clientRepository = clientRepository;
        this.fxWeaver = fxWeaver;
        List<Client> roomList = clientRepository.findAll();
        clients = FXCollections.observableArrayList(roomList);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Client> clientTable;

    @FXML
    private TableColumn<Client, Long> id;

    @FXML
    private TableColumn<Client, String> name;

    @FXML
    private TableColumn<Client, String> surname;

    @FXML
    private TableColumn<Client, String> email;

    @FXML
    private TableColumn<Client, Integer> phone;

    @FXML
    private TableColumn<Client, Date> birthDate;

    @FXML
    private TextField reportId;

    @FXML
    private Button reportBtn;

    @FXML
    private Button backBtn;

    @FXML
    void initialize() {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("profile.surname"));
        email.setCellValueFactory(new PropertyValueFactory<>("profile.email"));
        phone.setCellValueFactory(new PropertyValueFactory<>("profile.phone"));
        birthDate.setCellValueFactory(new PropertyValueFactory<>("profile.birthDate"));


        clientTable.setItems(clients);

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
