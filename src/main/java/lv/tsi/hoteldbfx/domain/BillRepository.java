package lv.tsi.hoteldbfx.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query("SELECT bill FROM Bill bill WHERE bill.id = ?1")
    public Bill findBillBy(Long id);

    @Query("SELECT bill FROM Bill bill WHERE bill.reservation = ?1")
    public Bill findBillByReservation(Reservation reservation);



}
