package lv.tsi.hoteldbfx;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/startPage.fxml")
public class StartController {
    private final FxWeaver fxWeaver;

    public StartController( FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clientLoginBtn;

    @FXML
    private Button workerLoginBtn;

    @FXML
    void initialize() {
        workerLoginBtn.setCursor(Cursor.HAND);

        workerLoginBtn.setOnAction(event -> {
            workerLoginBtn.getScene().getWindow().hide();

            Stage stage = new Stage();
            stage.setScene(new Scene(fxWeaver.loadView(LogInController.class), 626, 417));
            stage.showAndWait();

        });
    }
}
