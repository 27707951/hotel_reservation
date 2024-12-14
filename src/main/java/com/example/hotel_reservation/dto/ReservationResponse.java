package com.example.hotel_reservation.dto;

import java.time.LocalDate;

public class ReservationResponse {
    private Integer id;
    private String name;
    private String phone;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer guestNumber;
    private String roomType;
    private String detail;

    public ReservationResponse(String name, String phone, LocalDate startDate, LocalDate endDate, Integer guestNumber, String roomType, String detail) {
        this.name = name;
        this.phone = phone;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guestNumber = guestNumber;
        this.roomType = roomType;
        this.detail = detail;
    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
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

    public Integer getGuestNumber() {

        return guestNumber;
    }

    public void setGuestNumber(Integer guestNumber) {

        this.guestNumber = guestNumber;
    }

    public String getRoomType() {

        return roomType;
    }

    public void setRoomType(String roomType) {

        this.roomType = roomType;
    }

    public String getDetail() {

        return detail;
    }

    public void setDetail(String detail) {

        this.detail = detail;
    }
}
