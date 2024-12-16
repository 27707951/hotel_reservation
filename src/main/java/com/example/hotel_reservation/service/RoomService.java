package com.example.hotel_reservation.service;

import com.example.hotel_reservation.dto.RoomResponse;
import com.example.hotel_reservation.exception.NoAvailableRoomException;
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
        List<RoomResponse> availableRooms = roomRepository.findAvailableRooms(startDate, endDate);
        if (availableRooms.isEmpty()) {
            throw new NoAvailableRoomException("No rooms available for the selected dates.");
        }
        return availableRooms;
    }

    public List<RoomResponse> filterRooms(String filterBy, Integer capacity) {
        if ("priceHighToLow".equals(filterBy)) {
            return roomRepository.findAll(Sort.by(Sort.Direction.DESC, "price"))
                    .stream()
                    .map(room -> new RoomResponse(
                            room.getId(),
                            room.getRoomType(),
                            room.getMaxOccupancy(),
                            room.getPrice(),
                            room.getImageUrl()))
                    .toList();
        } else if ("capacity".equals(filterBy) && capacity != null) {
            return roomRepository.findByMaxOccupancy(capacity)
                    .stream()
                    .map(room -> new RoomResponse(
                            room.getId(),
                            room.getRoomType(),
                            room.getMaxOccupancy(),
                            room.getPrice(),
                            room.getImageUrl()))
                    .toList();
        }
        throw new IllegalArgumentException("Invalid filter criteria");
    }
}
