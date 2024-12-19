package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.dto.ReservationResponse;
import com.example.hotel_reservation.model.Customer;
import com.example.hotel_reservation.model.Reservation;
import com.example.hotel_reservation.model.Room;
import com.example.hotel_reservation.repository.CustomerRepository;
import com.example.hotel_reservation.repository.RoomRepository;
import com.example.hotel_reservation.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Map;

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

    @GetMapping("/findCustomer")
    public ResponseEntity<Map<String, Integer>> findCustomerByNameAndPhone(@RequestParam String name, @RequestParam String phone) {
        Optional<Customer> customerOpt = customerRepository.findByNameAndPhone(name, phone);
        if (customerOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(Map.of("id", customerOpt.get().getId()));
    }

    @GetMapping("/findRoom")
    public ResponseEntity<Map<String, Integer>> findRoomByType(@RequestParam String type) {
        Optional<Room> roomOpt = roomRepository.findByRoomType(type);
        if (roomOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(Map.of("id", roomOpt.get().getId()));
    }

    @PostMapping("/confirm")
    public ResponseEntity<?> confirmReservation(@RequestBody ReservationResponse response) {
        try {
            if (response.getCustomerId() == null || response.getRoomId() == null ||
                    response.getStartDate() == null || response.getEndDate() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input data.");
            }

            Customer customer = customerRepository.findById(response.getCustomerId())
                    .orElseThrow(() -> new IllegalArgumentException("Customer not found."));

            Room room = roomRepository.findById(response.getRoomId())
                    .orElseThrow(() -> new IllegalArgumentException("Room not found."));

            Reservation savedReservation = reservationService.saveReservation(
                    response.getCustomerId(),
                    response.getRoomId(),
                    response.getStartDate(),
                    response.getEndDate(),
                    response.getDetail()
            );

            return ResponseEntity.ok(savedReservation);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while saving reservation.");
        }
    }
}
