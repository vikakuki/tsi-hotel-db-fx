package lv.tsi.hoteldbfx.domain;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
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

    public Reservation() {
    }

    public Reservation(Client client, LocalDate checkIn, LocalDate checkOut, Room room) {
        this.client = client;
        this.room = room;
        this.checkIn = Date.valueOf(checkIn);
        this.checkOut = Date.valueOf(checkOut);
    }

    public long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Room getRoom() {
        return room;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
}
