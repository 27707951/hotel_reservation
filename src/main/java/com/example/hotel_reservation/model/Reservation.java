package com.example.hotel_reservation.model;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservation {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private Integer customerId;
    private static Integer roomId;
    private static LocalDate startDate;
    private static LocalDate endDate;
    private static String detail;


    public Reservation(Integer ID, Integer customerId, Integer roomId, LocalDate startDate, LocalDate endDate, String detail ) {

        this.customerId = customerId;
        this.roomId = roomId;
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
    public Integer getCustomerId() {

        return customerId;
    }

    public void setCustomerId(Integer customerId) {

        this.customerId = customerId;
    }
    public static Integer getRoomId() {

        return roomId;
    }
    public void setRoomId(Integer roomId) {

        Reservation.roomId = roomId;
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
