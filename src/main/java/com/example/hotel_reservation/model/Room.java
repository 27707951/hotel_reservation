package com.example.hotel_reservation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID ;

    @Column(name = "roomType")
    private String roomType ;

    @Column(name ="price")
    private Integer price ;

    @Column(name ="maxOccupancy")
    private Integer maxOccupancy;

    @Column(name = "imageUrl")
    private String imageUrl;

    public Room() {}

    public Room (Integer id, String roomType, Integer price , Integer maxOccupancy){
        this.ID = id;
        this.roomType = roomType;
        this.price = price;
        this.maxOccupancy = maxOccupancy;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return ID;
    }

    public void setId(Integer id) {
        this.ID = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getMaxOccupancy() {
        return maxOccupancy;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
