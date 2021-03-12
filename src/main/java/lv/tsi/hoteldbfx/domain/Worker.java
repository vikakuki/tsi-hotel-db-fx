package lv.tsi.hoteldbfx.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private double salary;
    @Column(nullable = false)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    public Worker(){};

    public Worker(String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
