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

    public ReservationResponse saveReservation(ReservationResponse response, Integer customerId, Integer roomId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found."));
        Room room = roomRepository.findById((long) roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found."));
        if (customer == null || room == null) {
            throw new IllegalArgumentException("Customer or Room information cannot be null.");
        }

        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        reservation.setRoom(room);
        reservation.setStartDate(response.getStartDate());
        reservation.setEndDate(response.getEndDate());
        reservation.setDetail(response.getDetail());

        Reservation savedReservation = reservationRepository.save(reservation);

        return new ReservationResponse(
                savedReservation.getId(),
                customer.getName(),
                customer.getPhone(),
                savedReservation.getStartDate(),
                savedReservation.getEndDate(),
                room.getMaxOccupancy(),
                room.getRoomType(),
                savedReservation.getDetail()
        );
    }
}
