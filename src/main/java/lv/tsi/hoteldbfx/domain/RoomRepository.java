package lv.tsi.hoteldbfx.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

        @Query("SELECT room FROM Room room WHERE room.id = ?1")
        public Room findRoomById(Integer id);


}
