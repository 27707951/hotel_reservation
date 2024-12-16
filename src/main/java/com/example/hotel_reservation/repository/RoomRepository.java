package com.example.hotel_reservation.repository;

import com.example.hotel_reservation.dto.RoomResponse;
import com.example.hotel_reservation.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r WHERE r.id NOT IN (" +
            " SELECT res.room.id FROM Reservation res" +
            " WHERE res.endDate > :startDate AND res.startDate < :endDate)")
    List<Room> findAvailableRooms(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<Room> findByMaxOccupancy(Integer maxOccupancy);

}
