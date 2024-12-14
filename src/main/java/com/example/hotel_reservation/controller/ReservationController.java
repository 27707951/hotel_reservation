package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.dto.CheckAvailabilityRequest;
import com.example.hotel_reservation.dto.CustomerRequest;
import com.example.hotel_reservation.dto.ReservationResponse;
import com.example.hotel_reservation.exception.NoAvailableRoomException;
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
    public ResponseEntity<?> checkAvailability(@RequestBody CheckAvailabilityRequest reservationRequest) {
        boolean isAvailable = reservationService.checkAvailability(request);
        if (isAvailable) {
            return ResponseEntity.ok("Room available");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No available rooms");
        }

    }

    @PostMapping("/confirm")
    public ResponseEntity<?> confirmReservation(@RequestBody CustomerRequest customerRequest,
                                                @RequestBody CheckRoomAvailabilityRequest checkRoomRequest) {

        try {
            ReservationResponse reservation = reservationService.confirmReservation();
            return ResponseEntity.ok(reservation);
        } catch (NoAvailableRoomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
