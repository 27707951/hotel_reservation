package com.example.hotel_reservation.service;

import com.example.hotel_reservation.dto.ReservationResponse;
import com.example.hotel_reservation.model.Reservation;
import com.example.hotel_reservation.repository.CustomerRepository;
import com.example.hotel_reservation.repository.ReservationRepository;
import com.example.hotel_reservation.repository.RoomRepository;
import org.springframework.stereotype.Service;
import com.example.hotel_reservation.model.*;


import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              CustomerRepository customerRepository,
                              RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
    }

    public Reservation saveReservation(Integer customerID, Integer roomID, LocalDate startDate, LocalDate endDate, String detail) {

        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found."));
        Room room = roomRepository.findById(roomID)
                .orElseThrow(() -> new IllegalArgumentException("Room not found."));

        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        reservation.setRoom(room);
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setDetail(detail);

        return reservationRepository.save(reservation);
    }
}


