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
import lv.tsi.hoteldbfx.domain.Worker;
import lv.tsi.hoteldbfx.domain.WorkerRepository;
import lv.tsi.hoteldbfx.domain.WorkerRepository;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("/workersTable.fxml")
public class WorkersViewController {
    private WorkerRepository workerRepository;
    private final FxWeaver fxWeaver;

    private final ObservableList<Worker> workers;

    @Autowired
    public WorkersViewController(WorkerRepository workerRepository, FxWeaver fxWeaver) {
        this.workerRepository = workerRepository;
        this.fxWeaver = fxWeaver;
        List<Worker> workerList = workerRepository.findAll();
        workers = FXCollections.observableArrayList(workerList);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Worker> workerTable;

    @FXML
    private TableColumn<Worker, Long> id;

    @FXML
    private TableColumn<Worker, String> name;

    @FXML
    private TableColumn<Worker, String> surname;

    @FXML
    private TableColumn<Worker, String> email;

    @FXML
    private TableColumn<Worker, String> position;

    @FXML
    private TableColumn<Worker, Double> salary;

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
        position.setCellValueFactory(new PropertyValueFactory<>("position"));
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));


        workerTable.setItems(workers);

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
