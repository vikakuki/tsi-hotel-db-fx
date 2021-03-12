package lv.tsi.hoteldbfx.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Client.class)
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Reservation.class)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Worker.class)
    @JoinColumn(name = "worker_id")
    private Worker worker;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private Date date;

    public long getId() {
        return id;
    }
}
