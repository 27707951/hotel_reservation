package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.dto.ReservationResponse;
import com.example.hotel_reservation.model.Customer;
import com.example.hotel_reservation.model.Room;
import com.example.hotel_reservation.repository.CustomerRepository;
import com.example.hotel_reservation.repository.RoomRepository;
import com.example.hotel_reservation.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;

    public ReservationController(ReservationService reservationService,
                                 CustomerRepository customerRepository,
                                 RoomRepository roomRepository) {
        this.reservationService = reservationService;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
    }

    @PostMapping("/confirm")
    public ResponseEntity<ReservationResponse> confirmReservation(@RequestBody ReservationResponse response,
                                                                  @RequestParam Integer customerId,
                                                                  @RequestParam Integer roomId) {
        try {
            ReservationResponse savedReservation = reservationService.saveReservation(response, customerId, roomId);
            return ResponseEntity.ok(savedReservation);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
