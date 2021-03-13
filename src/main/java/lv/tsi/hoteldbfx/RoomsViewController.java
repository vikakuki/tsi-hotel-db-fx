package lv.tsi.hoteldbfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lv.tsi.hoteldbfx.domain.Room;
import lv.tsi.hoteldbfx.domain.RoomRepository;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("/roomsTable.fxml")
public class RoomsViewController {
    private RoomRepository roomRepository;
    private final FxWeaver fxWeaver;

    private final ObservableList<Room> rooms;

    @Autowired
    public RoomsViewController(RoomRepository roomRepository, FxWeaver fxWeaver) {
        this.roomRepository = roomRepository;
        this.fxWeaver = fxWeaver;
        List<Room> roomList = roomRepository.findAll();
        rooms = FXCollections.observableArrayList(roomList);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Room> roomsTable;

    @FXML
    private TableColumn<Room, Long> id;

    @FXML
    private TableColumn<Room, String> category;

    @FXML
    private TableColumn<Room, Integer> floor;

    @FXML
    private TableColumn<Room, Boolean> isSeaView;

    @FXML
    private TableColumn<Room, Double> price;

    @FXML
    void initialize() {

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        floor.setCellValueFactory(new PropertyValueFactory<>("floor"));
        isSeaView.setCellValueFactory(new PropertyValueFactory<Room, Boolean>("isSeaView"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        roomsTable.setItems(rooms);


    }

}
