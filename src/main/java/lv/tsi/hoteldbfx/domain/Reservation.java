package lv.tsi.hoteldbfx.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Bill.class)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Client.class)
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Room.class)
    @JoinColumn(name = "room_id")
    private Room room;
    @Column(nullable = false)
    private Date checkIn;
    @Column(nullable = false)
    private Date checkOut;

    public long getId() {
        return id;
    }
}
