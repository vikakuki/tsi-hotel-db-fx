package lv.tsi.hoteldbfx.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = -1;
    @Column(nullable = false)
    private int floor;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String view;
    @Column(nullable = false)
    private double price;

    public int getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public String getCategory() {
        return category;
    }

    public String getView() {
        return view;
    }

    public double getPrice() {
        return price;
    }
}
