package com.example.hotel_reservation.service;

import com.example.hotel_reservation.dto.ReservationResponse;
import com.example.hotel_reservation.model.Reservation;
import com.example.hotel_reservation.exception.NoAvailableRoomException;
import com.example.hotel_reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    // 透過構造函數注入 Repository
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // 儲存預約
    public ReservationResponse saveReservation(ReservationResponse response) {
        // 將 DTO 轉換成 Reservation 實體類
        Reservation reservation = new Reservation();
        reservation.setName(response.getName());
        reservation.setPhone(response.getPhone());
        reservation.setStartDate(response.getStartDate());
        reservation.setEndDate(response.getEndDate());
        reservation.setGuestNumber(response.getGuestNumber());
        reservation.setRoomType(response.getRoomType());
        reservation.setDetail(response.getDetail());

        // 儲存資料到資料庫
        Reservation savedReservation = reservationRepository.save(reservation);

        // 回傳 ReservationResponse
        return new ReservationResponse(
                savedReservation.getId(),
                savedReservation.getName(),
                savedReservation.getPhone(),
                savedReservation.getStartDate(),
                savedReservation.getEndDate(),
                savedReservation.getGuestNumber(),
                savedReservation.getRoomType(),
                savedReservation.getDetail()
        );
    }

    // 刪除預約
    public void deleteReservation(Integer reservationId) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            reservationRepository.deleteById(reservationId);
        } else {
            throw new IllegalArgumentException("Reservation with ID " + reservationId + " does not exist.");
        }
    }



}
