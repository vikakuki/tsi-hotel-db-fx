package lv.tsi.hoteldbfx;


import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lv.tsi.hoteldbfx.domain.Profile;
import lv.tsi.hoteldbfx.domain.Worker;
import lv.tsi.hoteldbfx.domain.WorkerRepository;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
@FxmlView("/workerDetails.fxml")
public class WorkerDetailsController {
    private WorkerRepository workerRepository;
    private final FxWeaver fxWeaver;

    public WorkerDetailsController(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Autowired
    public WorkerDetailsController(WorkerRepository workerRepository, FxWeaver fxWeaver) {
        this.workerRepository = workerRepository;
        this.fxWeaver = fxWeaver;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lookingId;

    @FXML
    private Button findBtn;

    @FXML
    private TextField nameLbl;

    @FXML
    private TextField surnameLbl;

    @FXML
    private DatePicker birthDate;

    @FXML
    private TextField position;

    @FXML
    private TextField salary;

    @FXML
    private TextField personalCodeLbl;

    @FXML
    private TextField emailLbl;

    @FXML
    private TextField phoneLbl;
    
    @FXML
    private TextField idLbl;

    @FXML
    private Button updateBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Button addNewBtn;
    
    @FXML
    private TextField errorLbl;
    
    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    void initialize() {
        Stage stage = new Stage();

        backBtn.setCursor(Cursor.HAND);
        findBtn.setCursor(Cursor.HAND);
        addNewBtn.setCursor(Cursor.HAND);
        updateBtn.setCursor(Cursor.HAND);
        deleteBtn.setCursor(Cursor.HAND);
        backBtn.setOnAction(event -> {
            backBtn.getScene().getWindow().hide();

            stage.setScene(new Scene(fxWeaver.loadView(WorkerPanelController.class), 626, 417));
            stage.showAndWait();
        });

        findBtn.setOnAction(event -> {
            Optional<Worker> worker = findWorker(Long.parseLong(lookingId.getText()));

            if (worker.isPresent()) {
                updateWorkerUI(worker.get());
                return;
            }

            showError("Client is not found");

        });

        addNewBtn.setOnAction(event -> {
            saveNewWorker();
        });

        updateBtn.setOnAction(event -> {
            Long workerId = Long.valueOf(idLbl.getText());
            Optional<Worker> worker = findWorker(workerId);

            if (worker.isPresent()) {
                updateWorker(worker.get());
                Optional<Worker> updatedClient = findWorker(workerId);
                updateWorkerUI(updatedClient.get());
                return;
            }

            showError("Wrong client, write right client ID");
        });

        deleteBtn.setOnAction(event -> {
            workerRepository.deleteWorkerBy(Long.parseLong(lookingId.getText()));
        });
    }

    private void updateWorker(Worker worker) {
        String position = this.position.getText();
        String login = this.login.getText();
        String password = this.password.getText();
        String name = nameLbl.getText();
        Double salary = Double.parseDouble(this.salary.getText());
        String surname = surnameLbl.getText();
        LocalDate date = birthDate.getValue();
        Date birthDay = java.sql.Date.valueOf(date);
        String email = emailLbl.getText();
        Integer phoneNumber = Integer.parseInt(phoneLbl.getText());
        Integer personalCode = Integer.parseInt(personalCodeLbl.getText());

        workerRepository.updateWorker(worker.getId(), salary, position, login, name, surname, birthDay, email, phoneNumber, password, personalCode);
    }

    private void showError(String msg) {
        errorLbl.setVisible(true);
        errorLbl.setText(msg);
        errorLbl.setStyle("-fx-text-inner-color: red;");
    }

    private void saveNewWorker() {
        String login = this.login.getText();
        String surname = surnameLbl.getText();
        Integer phoneNumber = Integer.parseInt(phoneLbl.getText());
        Integer personalCode = Integer.parseInt(personalCodeLbl.getText());
        String password = this.password.getText();
        String name = nameLbl.getText();
        Double salary = Double.parseDouble(this.salary.getText());
        String position = this.position.getText();
        String email = emailLbl.getText();
        Date birthDay = java.sql.Date.valueOf(birthDate.getValue());

        workerRepository.addNewWorker(login, password, position, name, surname, birthDay, email, phoneNumber, salary, personalCode);
    }

    private Optional<Worker> findWorker(long id) {
        Worker client = workerRepository.findWorkerById(id);

        if (client == null) {
            return Optional.empty();
        }

        return Optional.of(client);
    }

    private void updateWorkerUI(Worker worker) {
        Profile profile = worker.getProfile();
        Date birthDate = new Date(profile.getBirthDate().getTime());
        LocalDate date = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        login.setText(worker.getLogin());
        password.setText(worker.getPassword());
        position.setText(worker.getPosition());
        emailLbl.setText(profile.getEmail());
        nameLbl.setText(profile.getName());
        surnameLbl.setText(profile.getSurname());
        this.birthDate.setValue(date);
        phoneLbl.setText(String.valueOf(profile.getPhoneNumber()));
        salary.setText(String.valueOf(worker.getSalary()));
        idLbl.setText(String.valueOf(worker.getId()));
        personalCodeLbl.setText(String.valueOf(profile.getPersonalCode()));
    }
}