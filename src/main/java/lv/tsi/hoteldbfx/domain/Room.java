package lv.tsi.hoteldbfx.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
    @Column(nullable = false)
    private int floor;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private boolean isSeaView;
    @Column(nullable = false)
    private double price;

    public long getId() {
        return id;
    }
}
