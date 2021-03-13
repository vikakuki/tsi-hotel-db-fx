package lv.tsi.hoteldbfx.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    @Embedded
    private Profile profile;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private double salary;

    public Worker() {
    }

    public Worker(Profile profile, String login, String password, String position, Double salary) {
        this.profile = profile;
        this.login = login;
        this.password = password;
        this.position = position;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getPosition() {
        return position;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public double getSalary() {
        return salary;
    }
}
