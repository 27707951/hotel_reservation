package com.example.hotel_reservation.repository;

import com.example.hotel_reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    boolean existsByRoom_IdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Integer roomId, LocalDate startDate, LocalDate endDate);
    // 確認房間是否在指定日期範圍內已被預訂
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Reservation r " +
            "WHERE r.room.ID = :roomId AND r.startDate <= :endDate AND r.endDate >= :startDate")
    boolean isRoomBookedWithinDateRange(@Param("roomId") Integer roomId,
                                        @Param("startDate") LocalDate startDate,
                                        @Param("endDate") LocalDate endDate);

    // 刪除預約
    @Modifying
    @Transactional
    @Query("DELETE FROM Reservation r WHERE r.id = :id")
    void deleteReservationById(@Param("id") Integer id);

    // 更新預約細節
    @Modifying
    @Transactional
    @Query("UPDATE Reservation r SET r.detail = :detail WHERE r.id = :id")
    void updateReservationDetail(@Param("id") Integer id, @Param("detail") String detail);
}
