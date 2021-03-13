package lv.tsi.hoteldbfx.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    @Embedded
    private Profile profile;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    private String gender;


    public long getId() {
        return id;
    }

}
