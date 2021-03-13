package lv.tsi.hoteldbfx;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lv.tsi.hoteldbfx.domain.WorkerRepository;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
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
    public WorkerDetailsController(WorkerRepository clientRepository, FxWeaver fxWeaver) {
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
    private TextField emailLbl;

    @FXML
    private TextField phoneLbl;

    @FXML
    private Button updateBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button backBtn;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    void initialize() {

    }
}