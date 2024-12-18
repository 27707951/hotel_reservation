package com.example.hotel_reservation.dto;

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
    private Integer customerId;
    private Integer roomId;

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

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public Integer getRoomId() { return roomId; }
    public void setRoomId(Integer roomId) { this.roomId = roomId; }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
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

    public Integer getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(Integer maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
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
