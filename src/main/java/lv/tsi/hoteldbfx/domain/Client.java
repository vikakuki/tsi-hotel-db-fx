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

    public Client() {}

    public Client(Profile profile, String country, String city, String gender) {
        this.profile = profile;
        this.country = country;
        this.city = city;
        this.gender = gender;
    }


    public long getId() {
        return id;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
       return profile.getName();
    }

    public String getSurname() {
       return profile.getSurname();
    }

    public String getEmail() {
       return profile.getEmail();
    }

    public Date getBirthDate() {
       return profile.getBirthDate();
    }

    public String getPhoneNumber() {
       return String.valueOf(profile.getPhoneNumber());
    }


}
