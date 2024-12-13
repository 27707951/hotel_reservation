package com.example.hotel_reservation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CustomerRequest {
    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Phone number is Required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits.")
    private String phone;

    private String detail;

    public CustomerRequest() {}

    public CustomerRequest(String name, String phone, String detail) {
        this.name = name;
        this.phone = phone;
        this.detail = detail;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
