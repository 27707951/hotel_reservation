package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.dto.ReservationResponse;
import com.example.hotel_reservation.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // 儲存預約
    @PostMapping("/confirm")
    public ResponseEntity<ReservationResponse> confirmReservation(@RequestBody ReservationResponse response) {
        ReservationResponse savedReservation = reservationService.saveReservation(response);
        return ResponseEntity.ok(savedReservation);
    }

    // 刪除預約
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok("Reservation with ID " + id + " has been deleted.");
    }


}
