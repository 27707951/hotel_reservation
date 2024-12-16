package com.example.hotel_reservation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String roomType ;
    private Integer price ;
    private Integer maxOccupancy;
    private String imageUrl;

    public Room() {}

    public Room (Integer id, String roomType, Integer price , Integer maxOccupancy){
        this.id = id;
        this.roomType = roomType;
        this.price = price;
        this.maxOccupancy = maxOccupancy;
        this.imageUrl = imageUrl;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType){
        this.roomType = roomType;

    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(Integer maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
