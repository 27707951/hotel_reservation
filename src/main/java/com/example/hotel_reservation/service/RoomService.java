package com.example.hotel_reservation.service;

import com.example.hotel_reservation.dto.RoomResponse;
import com.example.hotel_reservation.exception.NoAvailableRoomException;
import com.example.hotel_reservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<RoomResponse> findAvailableRooms(LocalDate startDate, LocalDate endDate) {
        List<RoomResponse> availableRooms = roomRepository.findAvailableRooms(startDate, endDate);
        if (availableRooms.isEmpty()) {
            throw new NoAvailableRoomException("No rooms available for the selected dates.");
        }
        return availableRooms;
    }
}
