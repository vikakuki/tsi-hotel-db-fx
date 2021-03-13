package lv.tsi.hoteldbfx.domain;

import lv.tsi.hoteldbfx.service.TimingUtils;

import javax.persistence.*;
import java.sql.Date;
import java.time.ZoneId;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Reservation.class)
    @JoinColumn(name = "reservation_id" , nullable = false)
    private Reservation reservation;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Worker.class)
    @JoinColumn(name = "worker_id", nullable = false)
    private Worker worker;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private Date date;

    public Bill() {
    }

    public Bill(Reservation reservation, Worker worker, double price) {
        this.reservation = reservation;
        this.worker = worker;
        this.price = price;
        this.date = Date.valueOf(TimingUtils.getLocalDate());
    }

    public long getId() {
        return id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Worker getWorker() {
        return worker;
    }

    public double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
}
