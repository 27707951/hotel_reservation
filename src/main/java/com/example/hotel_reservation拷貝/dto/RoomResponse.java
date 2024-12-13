package com.example.hotel_reservation.dto;

public class RoomResponse {
    private String roomType;
    private Integer maxOccupancy;
    private Integer price;

    public RoomResponse(String roomType, Integer maxOccupancy, Integer price) {
        this.roomType = roomType;
        this.maxOccupancy = maxOccupancy;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(Integer maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
