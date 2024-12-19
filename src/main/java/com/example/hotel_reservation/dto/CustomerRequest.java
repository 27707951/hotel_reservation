package com.example.hotel_reservation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CustomerRequest {
    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Phone number is Required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits.")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
}