package com.example.hotel_reservation.repository;

import com.example.hotel_reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query("SELECT COUNT(r) > 0 FROM Reservation r WHERE r.room.id = :roomId AND :date BETWEEN r.startDate AND r.endDate")
    boolean RoomExistsByDate(@Param("roomId") Integer roomId, @Param("date") LocalDate date);
}
