package com.example.hotel_reservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ReservationResponse {
    private Integer id;
    private String customerName;
    private String customerPhone;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer maxOccupancy;
    private String roomType;
    private String detail;

    @JsonProperty("customerId")
    private Integer customerID;

    @JsonProperty("roomId")
    private Integer roomID;

    public ReservationResponse() {
    }

    public ReservationResponse(Integer id, String customerName, String customerPhone,
                               LocalDate startDate, LocalDate endDate,
                               Integer maxOccupancy, String roomType, String detail) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxOccupancy = maxOccupancy;
        this.roomType = roomType;
        this.detail = detail;

    }

    public Integer getCustomerId() { return customerID; }

    public Integer getRoomId() { return roomID; }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
