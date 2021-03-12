package lv.tsi.hoteldbfx.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
    private String name;
    private String surname;
    private String country;
    private String city;
    private String gender;
    private String email;
    @Column(name = "phone_number")
    private int phoneNumber;
    @Column(name = "birth_date")
    private Date birthDate;

    public Client(){};

    public Client(String name) {
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
