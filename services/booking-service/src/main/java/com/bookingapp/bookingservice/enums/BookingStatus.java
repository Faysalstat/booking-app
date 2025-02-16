package com.bookingapp.bookingservice.enums;

public enum BookingStatus {
    AVAILABLE("Available"),
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    COMPLETED("Completed");

    private final String value;

    BookingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
