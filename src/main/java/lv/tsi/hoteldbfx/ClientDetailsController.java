package lv.tsi.hoteldbfx;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lv.tsi.hoteldbfx.domain.Client;
import lv.tsi.hoteldbfx.domain.ClientRepository;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.time.LocalDate;
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
    private TextField phoneLbl;

    @FXML
    private Button updateBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private ChoiceBox<String> gender;

    @FXML
    void initialize() {
        gender.getItems().addAll("Female", "Male", "Wont answer");

    }
}
