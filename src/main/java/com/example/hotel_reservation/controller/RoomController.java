package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.dto.*;
import com.example.hotel_reservation.exception.*;
import com.example.hotel_reservation.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")  // 允許來自 63342 的請求
@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/check-availability")
    public ResponseEntity<?> checkRoomAvailability(@RequestBody CheckAvailabilityRequest request) {
        try {
            List<RoomResponse> availableRooms = roomService.findAvailableRooms(request.getStartDate(), request.getEndDate(), request.getNumberOfGuests());
            System.out.println("Available rooms: " + availableRooms);
            return ResponseEntity.ok(availableRooms);
        } catch (NoAvailableRoomException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/filter")
    public ResponseEntity<List<RoomResponse>> filterRooms(
            @RequestParam(required = false) String filterBy,
            @RequestParam(required = false) Integer capacity) {

        List<RoomResponse> rooms = roomService.filterRooms(filterBy, capacity);
        return ResponseEntity.ok(rooms);
    }
}