package com.example.hotel_reservation.model;

import jakarta.persistence.Entity;

@Entity
public class Room {

    private Long id;

    private String roomID;
    private String roomType;
    private String status;
    private int price;
    private int maxOccupancy;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;

    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public boolean checkAvailibility(String startDate, String endDate) {


        return true;


    }

    public void updateStatus(String status) {
        this.status = status;

    }
}
