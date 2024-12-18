package com.example.hotel_reservation.repository;

import com.example.hotel_reservation.dto.RoomResponse;
import com.example.hotel_reservation.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    // 查詢符合日期範圍內可用的房間
    /*@Query("SELECT r FROM Room r WHERE r.ID NOT IN (" +
            "SELECT res.room.ID FROM Reservation res " +
            "WHERE res.startDate < :endDate AND res.endDate > :startDate) " +
            "AND r.maxOccupancy >= :numberOfGuests")
    List<Room> findAvailableRooms(@Param("startDate") LocalDate startDate,
                                  @Param("endDate") LocalDate endDate,
                                  @Param("numberOfGuests") Integer numberOfGuests);


    // 按照價格高到低排序查詢所有房間
    @Query("SELECT r FROM Room r ORDER BY r.price DESC")
    List<Room> findAllByPriceDesc();*/
    @Query("SELECT r FROM Room r " +
            "LEFT JOIN Reservation res ON r.ID = res.room.ID " +
            "AND res.startDate < :endDate " +
            "AND res.endDate > :startDate " +
            "WHERE res.room.ID IS NULL " +
            "AND r.maxOccupancy >= :numberOfGuests")
    List<Room> findAvailableRooms(@Param("startDate") LocalDate startDate,
                                  @Param("endDate") LocalDate endDate,
                                  @Param("numberOfGuests") Integer numberOfGuests);

    // 根據最大容納人數篩選房間
    @Query("SELECT r FROM Room r WHERE r.maxOccupancy >= :capacity")
    List<Room> findByMaxOccupancy(@Param("capacity") Integer capacity);

    Optional<Room> findByRoomType(String roomType);


}


