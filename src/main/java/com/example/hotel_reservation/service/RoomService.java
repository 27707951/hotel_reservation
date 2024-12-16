package com.example.hotel_reservation.service;

import com.example.hotel_reservation.dto.RoomResponse;
import com.example.hotel_reservation.exception.NoAvailableRoomException;
import com.example.hotel_reservation.model.Room;
import com.example.hotel_reservation.repository.ReservationRepository;
import com.example.hotel_reservation.repository.RoomRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    // 使用構造函數注入兩個 Repository
    public RoomService(RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomResponse> findAvailableRooms(LocalDate startDate, LocalDate endDate) {
        List<Room> rooms = roomRepository.findAvailableRooms(startDate, endDate);

        if (rooms.isEmpty()) {
            throw new NoAvailableRoomException("No rooms available for the given dates");
        }

        return rooms.stream()
                .map(room -> new RoomResponse(
                        room.getId(),
                        room.getRoomType(),
                        room.getMaxOccupancy(),
                        room.getPrice(),
                        room.getImageUrl()))
                .toList();
    }

    public List<RoomResponse> filterRooms(String filterBy, Integer capacity) {
        List<Room> rooms;

        switch (filterBy) {
            case "priceHighToLow":
                rooms = roomRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
                break;
            case "capacity":
                if (capacity != null) {
                    rooms = roomRepository.findByMaxOccupancy(capacity);
                } else {
                    throw new IllegalArgumentException("Capacity must be provided when filtering by capacity");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid filter criteria: " + filterBy);
        }

        return rooms.stream()
                .map(room -> new RoomResponse(
                        room.getId(),
                        room.getRoomType(),
                        room.getMaxOccupancy(),
                        room.getPrice(),
                        room.getImageUrl()))
                .toList();
    }
}
