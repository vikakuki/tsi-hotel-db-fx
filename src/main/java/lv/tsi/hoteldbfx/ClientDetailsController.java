package lv.tsi.hoteldbfx;


import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lv.tsi.hoteldbfx.domain.Client;
import lv.tsi.hoteldbfx.domain.ClientRepository;
import lv.tsi.hoteldbfx.domain.Profile;
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
@FxmlView("/clientDetails.fxml")
public class ClientDetailsController {
    private ClientRepository clientRepository;
    private final FxWeaver fxWeaver;

    public ClientDetailsController(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Autowired
    public ClientDetailsController(ClientRepository clientRepository, FxWeaver fxWeaver) {
        this.clientRepository = clientRepository;
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
    private TextField countryLbl;

    @FXML
    private TextField cityLbl;

    @FXML
    private TextField emailLbl;

    @FXML
    private TextField personalCodeLbl;

    @FXML
    private TextField idLbl;

    @FXML
    private TextField phoneLbl;

    @FXML
    private TextField errorLbl;

    @FXML
    private Button addNewBtn;

    @FXML
    private Button updateBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button backBtn;

    @FXML
    private ChoiceBox<String> gender;

    @FXML
    void initialize() {
        gender.getItems().addAll("Female", "Male", "Wont answer");
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
            Optional<Client> client = findClient(Long.parseLong(lookingId.getText()));

            if (client.isPresent()) {
                updateClientUI(client.get());
                return;
            }

            showError("Client is not found");

        });

        addNewBtn.setOnAction(event -> {

            Optional<Client> client = saveNewClient();

            if (client.isPresent()) {
                updateClientUI(client.get());
                return;
            }

            showError("New client add FAILED");
        });

        updateBtn.setOnAction(event -> {
            Long clientId = Long.valueOf(idLbl.getText());
            Optional<Client> client = findClient(clientId);

            if (client.isPresent()) {
                updateClient(client.get());
                Optional<Client> updatedClient = findClient(clientId);
                updateClientUI(updatedClient.get());
                return;
            }

            showError("Wrong client, write right client ID");
        });

        deleteBtn.setOnAction(event -> {
            clientRepository.deleteClientBy(Long.parseLong(lookingId.getText()));
        });
    }

    private void updateClient(Client client) {
        String city = cityLbl.getText();
        String country = countryLbl.getText();
        String gender = this.gender.getValue();
        String name = nameLbl.getText();
        String surname = surnameLbl.getText();
        Long personalCode = Long.parseLong(personalCodeLbl.getText());
        LocalDate date = birthDate.getValue();
        Date birthDay = java.sql.Date.valueOf(date);
        String email = emailLbl.getText();
        Integer phoneNumber = Integer.parseInt(phoneLbl.getText());

        clientRepository.updateClient(client.getId(), city, country, gender, name, surname, birthDay, email, phoneNumber, personalCode);
    }

    private void showError(String msg) {
        errorLbl.setVisible(true);
        errorLbl.setText(msg);
        errorLbl.setStyle("-fx-text-inner-color: red;");
    }

    private Optional<Client> saveNewClient() {
        String name = nameLbl.getText();
        String surname = surnameLbl.getText();
        Integer phoneNumber = Integer.parseInt(phoneLbl.getText());
        long personalCode = Long.parseLong(personalCodeLbl.getText());
        String cityLblText = cityLbl.getText();
        String country = countryLbl.getText();
        String gender = this.gender.getValue();
        String email = emailLbl.getText();
        Date birthDay = java.sql.Date.valueOf(birthDate.getValue());

        //clientRepository.addNewClient(cityLblText, country, gender, name, surname, birthDay, email, phoneNumber, personalCode);

        Profile profile = new Profile(name, surname, email, phoneLbl.getText(), birthDate.getValue(), Long.toString(personalCode));
        Client client = new Client(profile, country, cityLblText, gender);                    //will use for standart method clientRepository.save(client);

        clientRepository.save(client);
        //clientRepository.addNewClient(cityLblText, country, gender, name, surname, birthDay, email, phoneNumber, personalCode);

        return Optional.empty();
    }

    private Optional<Client> findClient(long id) {
        Client client = clientRepository.findClientById(id);

        if (client == null) {
            return Optional.empty();
        }

        return Optional.of(client);
    }

    private void updateClientUI(Client client) {
        Profile profile = client.getProfile();
        Date birthDate = new Date(profile.getBirthDate().getTime());
        LocalDate date = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        cityLbl.setText(client.getCity());
        countryLbl.setText(client.getCountry());
        emailLbl.setText(profile.getEmail());
        nameLbl.setText(profile.getName());
        surnameLbl.setText(profile.getSurname());
        this.birthDate.setValue(date);
        phoneLbl.setText(String.valueOf(profile.getPhoneNumber()));
        personalCodeLbl.setText(String.valueOf(profile.getPersonalCode()));
        gender.setValue(client.getGender());
        idLbl.setText(String.valueOf(client.getId()));
    }
}
