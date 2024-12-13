package com.example.hotel_reservation.model;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne
    @JoinColumn(name = "customerID", referencedColumnName = "ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "roomID", referencedColumnName = "ID")
    private Room room;

    private LocalDate startDate;
    private LocalDate endDate;
    private String detail;


    public Reservation(Integer ID, Room room, Customer customer, LocalDate startDate, LocalDate endDate, String detail ) {
        this.ID = ID;
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.detail = detail;

    }

    public Reservation() {

    }

    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }



}
