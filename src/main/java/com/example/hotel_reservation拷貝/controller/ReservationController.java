package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.dto.ReservationResponse;
import com.example.hotel_reservation.service.ReservationService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    
    @PostMapping("/check-availability")
    public ResponseEntity<?> checkAvailability(@RequestBody CheckAvailabilityRequest reservationRequest) {}

    @PostMapping("/confirm")
    public ResponseEntity<?> confirmReservation(@RequestBody ReservationRequest request) {
        try {
            ReservationResponse reservation = reservationService.confirmReservation(request);
            return ResponseEntity.ok(reservation);
        } catch (InvalidReservationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
