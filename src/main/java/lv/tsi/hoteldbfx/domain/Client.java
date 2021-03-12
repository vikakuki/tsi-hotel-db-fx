package lv.tsi.hoteldbfx.domain;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
