package com.example.hotel_reservation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class CheckAvailabilityRequest {

    @NotNull(message = "Start date is required.")
    private LocalDate startDate;

    @NotNull(message = "End date is required.")
    private LocalDate endDate;

    @Min(value = 1, message = "Number of guests must be at least one.")
    private Integer numberOfGuests;

    public CheckAvailabilityRequest() {}

    public CheckAvailabilityRequest(LocalDate startDate, LocalDate endDate, int numberOfGuests) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfGuests = numberOfGuests;
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

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }
}
