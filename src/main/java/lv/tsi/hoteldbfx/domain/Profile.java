package lv.tsi.hoteldbfx.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;
import java.time.LocalDate;

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

    public Profile() {}

    public Profile(String name, String surname, String email, String phoneNumber, LocalDate date) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = Integer.parseInt(phoneNumber);
        this.birthDate = Date.valueOf(date);
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
