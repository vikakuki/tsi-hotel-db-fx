package lv.tsi.hoteldbfx.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query("SELECT worker FROM Worker worker WHERE worker.id = ?1")
    public Worker findWorkerById(Long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Worker worker set worker.salary = ?2,worker.position = ?3, worker.login = ?4," +
            " worker.profile.name = ?5, worker.profile.surname = ?6, worker.profile.birthDate = ?7," +
            " worker.profile.email = ?8, worker.profile.phoneNumber = ?9, worker.password = ?10, worker.profile.personalCode = ?11 WHERE worker.id = ?1")
    public void updateWorker(Long id, Double salary, String position, String login, String name, String surname, Date birthDate, String email, Integer phoneNumber, String password, Long personalCode);


    @Modifying
    @Query(value = "insert into workers (login, password, position, birth_date, email, name, phone_number, surname, salary)" +
            " VALUES (login = ?1, password = ?2, position = ?3, birth_date = ?6, email = ?7, name = ?4, phone_number = ?8, surname = ?5, salary = ?9, personal_code = ?10)", nativeQuery = true)
    @Transactional
    public void addNewWorker(String login, String password, String position, String name, String surname, Date birthDate, String email, Integer phoneNumber, Double salary, Long personalCode);

    @Modifying
    @Transactional
    @Query("DELETE FROM Worker worker WHERE worker.id = ?1")
    public void deleteWorkerBy(Long id);

}
