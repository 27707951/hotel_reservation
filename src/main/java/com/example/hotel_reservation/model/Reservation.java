package com.example.hotel_reservation.model;
import jakarta.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @JoinColumn(name = "customerID", nullable = false)
    private Integer customerID;

    @JoinColumn(name = "roomID", nullable = false)
    private Integer roomID;

    private String startDate;
    private String endDate;

    @Lob
    private String detail;

    public Reservation(Customer customer, Room room, Date startdate, Date enddate, String detail) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.detail = detail;
    }

    public int getReservationID() {
        return ID;
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

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void createReservation(Customer customer, Room room, Date startdate, Date enddate, String detail) {
        this.customer = customer;
        this.room = room;
        this.startdate = startdate;
        this.enddate = enddate;
        this.detail = detail;
    }
}
