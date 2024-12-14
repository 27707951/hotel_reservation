package com.example.hotel_reservation.service;

import com.example.hotel_reservation.dto.CheckAvailabilityRequest;
import com.example.hotel_reservation.dto.CustomerRequest;
import com.example.hotel_reservation.dto.ReservationResponse;
import com.example.hotel_reservation.exception.NoAvailableRoomException;
import com.example.hotel_reservation.model.Customer;
import com.example.hotel_reservation.model.Reservation;
import com.example.hotel_reservation.repository.CustomerRepository;
import com.example.hotel_reservation.repository.ReservationRepository;
import com.example.hotel_reservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class ReservationService {


    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;


    @Autowired
    public ReservationService(ReservationRepository reservationRepository,CustomerRepository customerRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;

    }

    // Confirm Reservation Logic
    public ReservationResponse confirmReservation(CustomerRequest customerRequest, CheckAvailabilityRequest checkRoomRequest) throws NoAvailableRoomException {
        // Validate the customer data
        if (customerRequest == null || checkRoomRequest == null) {
            throw new NoAvailableRoomException("Invalid reservation request");
        }

        // 這裡檢查該房間是否在該日期區間內已經被預訂
        if (isRoomAlreadyBooked(Reservation.getRoomId(), Reservation.getStartDate(), Reservation.getEndDate())) {
            throw new NoAvailableRoomException("The room is already booked for the selected dates.");
        }

        // 處理預訂邏輯，並創建預訂實體
        Reservation reservation = new Reservation();
        reservation.setCustomerId(Customer.getId());
        reservation.setRoomId(Reservation.getRoomId());
        Reservation.setStartDate(Reservation.getStartDate());
        Reservation.setEndDate(Reservation.getEndDate());
        reservation.setDetail(Reservation.getDetail());

        // 儲存預訂到資料庫
        reservationRepository.save(reservation);

        // 回應包含預訂ID和日期
        ReservationResponse response = new ReservationResponse();
        Reservation.setId(reservation.getID());
        Reservation.setStartDate(Reservation.getStartDate());
        Reservation.setEndDate(Reservation.getEndDate());
        return reservation;
    }

    // 檢查房間是否已經預訂
    private boolean isRoomAlreadyBooked(Integer roomId, LocalDate startDate, LocalDate endDate) {
        // 查詢資料庫檢查該房間在選定日期範圍內是否有預訂
        return reservationRepository.existsByRoomIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                roomId, endDate, startDate
        );
    }

    // Check Availability Logic
    public boolean checkAvailability(CheckAvailabilityRequest request) {
        // 檢查是否有可用房間，這裡簡單示範可以根據需求改成具體邏輯
        if (request == null || request.getRoomId() == null || request.getDate() == null) {
            return false;
        }

        // 假設查詢房間是否可用的邏輯
        return !reservationRepository.existsByRoomIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                request.getRoomId(), request.getDate(), request.getDate()
        );
    }
}
}
