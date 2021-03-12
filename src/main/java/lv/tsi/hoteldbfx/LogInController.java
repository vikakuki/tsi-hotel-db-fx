package lv.tsi.hoteldbfx;


import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/logInForm.fxml")
public class LogInController {
    private final FxWeaver fxWeaver;

    public LogInController( FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button workerLoginBtn;

    @FXML
    void initialize() {
        workerLoginBtn.setCursor(Cursor.HAND);

        workerLoginBtn.setOnAction(event -> {
            workerLoginBtn.getScene().getWindow().hide();


            Stage stage = new Stage();
            stage.setScene(new Scene(fxWeaver.loadView(WorkerPanelController.class), 626, 417));
            stage.showAndWait();

        });

    }
}
