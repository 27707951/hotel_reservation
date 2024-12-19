package com.example.hotel_reservation.dto;

public class RoomResponse {
    private String roomType;
    private Integer maxOccupancy;
    private Integer price;
    private Integer id;
    private String imageUrl;

    public RoomResponse(Integer id, String roomType, Integer maxOccupancy, Integer price, String imageUrl) {
        this.id = id;
        this.roomType = roomType;
        this.maxOccupancy = maxOccupancy;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RoomResponse{" +
                "id=" + id +
                ", roomType='" + roomType + '\'' +
                ", maxOccupancy=" + maxOccupancy +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
