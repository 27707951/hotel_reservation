package com.example.hotel_reservation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class CheckAvailabilityRequest {
    @NotNull(message = "Start date is required.")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @Min(value = 1, message = "Guest number must be at least one")
    private Integer guestNumber;

    public CheckAvailabilityRequest() {}

    public CheckAvailabilityRequest(LocalDate startDate, LocalDate endDate, int guestNumber) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.guestNumber = guestNumber;
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

    public int getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(int guestNumber) {
        this.guestNumber = guestNumber;
    }
}
