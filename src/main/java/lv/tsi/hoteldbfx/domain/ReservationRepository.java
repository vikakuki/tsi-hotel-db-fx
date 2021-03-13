package lv.tsi.hoteldbfx.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Query("SELECT reservation FROM Reservation reservation WHERE reservation.id = ?1")
    public Reservation findReservationBy(Long id);


}
