package lv.tsi.hoteldbfx.service;

import lv.tsi.hoteldbfx.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {
    private final ClientRepository clientRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final BillRepository billRepository;
    private final WorkerRepository workerRepository;

    @Autowired
    public ReservationService(
              ClientRepository clientRepository,
              RoomRepository roomRepository,
              ReservationRepository reservationRepository,
              WorkerRepository workerRepository,
              BillRepository billRepository
    ) {
        this.clientRepository = clientRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.billRepository = billRepository;
        this.workerRepository = workerRepository;
    }

    public Optional<Reservation> createReservation(long clientPersonalCode, LocalDate checkIn, LocalDate checkOut, int roomId) {
        Client client = clientRepository.findClientByCode(clientPersonalCode);
        Room room = roomRepository.findRoomById(roomId);

        if (client == null || room == null) {
           return Optional.empty();
        }

        Reservation reservation = new Reservation(client, checkIn, checkOut, room);

        //ToDo in future worker should be taken from system at login

        Worker worker = workerRepository.findWorkerById(1L);

        if (worker == null) {
            return Optional.empty();
        }

        double priceSumm = TimingUtils.getDayDifference(checkOut, checkIn) * room.getPrice();

        reservation = reservationRepository.save(reservation);
        Bill bill = new Bill(reservation, worker, priceSumm);
        billRepository.save(bill);

        return Optional.of(reservation);
    }
}
