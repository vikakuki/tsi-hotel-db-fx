package lv.tsi.hoteldbfx.domain;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT client FROM Client client WHERE client.id = ?1")
    public Client findClientById(Long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Client client set client.city = ?2," +
            "client.country = ?3, client.gender = ?4, client.profile.name = ?5, client.profile.surname = ?6," +
            "client.profile.birthDate = ?7, client.profile.email = ?8, client.profile.phoneNumber = ?9, client.profile.personalCode = ?10 WHERE client.id = ?1")
    public void updateClient(Long id, String city, String country, String gender, String name, String surname, Date birthDate, String email, Integer phoneNumber, Integer personalCode);


    @Modifying
    @Query(value = "insert into clients (city, country, gender, birth_date, email, name, phone_number, surname)" +
            " VALUES (clients.city = ?1, country = ?2, gender = ?3, birth_date = ?6, email = ?7, name = ?4, phone_number = ?8, surname = ?5)", nativeQuery = true)
    @Transactional
    public void addNewClient(String city, String country, String gender, String name, String surname, Date birthDate, String email, Integer phoneNumber, Integer personalCode);

    @Modifying
    @Transactional
    @Query("DELETE FROM Client client WHERE client.id = ?1")
    public void deleteClientBy(Long id);
}
