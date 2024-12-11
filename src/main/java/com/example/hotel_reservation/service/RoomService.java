package com.example.hotel_reservation.service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomResponse> checkAvailability(RoomRequest request) {
        List<Room> availableRooms = roomRepository.findAvailableRooms(
                request.getStartDate(), request.getEndDate(), request.getGuestNumber());

        if (availableRooms.isEmpty()) {
            throw new NoAvailableRoomException("No available rooms for the given criteria.");
        }

        return availableRooms.stream()
                .map(room -> new RoomResponse(room.getId(), room.getType(), room.getPrice()))
                .toList();
    }
}
