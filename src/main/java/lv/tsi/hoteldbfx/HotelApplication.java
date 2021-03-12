package lv.tsi.hoteldbfx;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelApplication {

    public static void main(String[] args) {
        Application.launch(ChartApplication.class, args);
    }

}
