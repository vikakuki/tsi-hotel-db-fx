package lv.tsi.hoteldbfx.service;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

public class TimingUtils {
    public static int getDayDifference(LocalDate checkOut, LocalDate checkIn) {
        //ToDO
        return 5;
    }

    public static LocalDate getLocalDate() {
        Calendar calendar = Calendar.getInstance();

        return calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
