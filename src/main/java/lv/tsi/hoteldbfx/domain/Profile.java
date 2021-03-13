package lv.tsi.hoteldbfx.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;

@Embeddable
public class Profile {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(name = "phone_number",nullable = false)
    private int phoneNumber;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
}
