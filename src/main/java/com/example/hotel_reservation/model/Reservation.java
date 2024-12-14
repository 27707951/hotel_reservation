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

    public static void setId(Integer id) {
    }

    public Integer getID() {

        return ID;
    }

    public void setID(Integer ID) {

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
    public static LocalDate getStartDate() {

        return startDate;
    }
    public static void setStartDate(LocalDate startDate) {

        Reservation.startDate = startDate;
    }
    public static LocalDate getEndDate() {

        return endDate;
    }
    public static void setEndDate(LocalDate endDate) {

        Reservation.endDate = endDate;
    }
    public static String getDetail() {

        return detail;
    }
    public void setDetail(String detail) {

        Reservation.detail = detail;
    }



}
