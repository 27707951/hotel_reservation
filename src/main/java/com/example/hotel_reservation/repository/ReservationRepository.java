package com.example.hotel_reservation.repository;

import com.example.hotel_reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    boolean existsByRoomIdAndDate(Integer roomId, String date);
}
