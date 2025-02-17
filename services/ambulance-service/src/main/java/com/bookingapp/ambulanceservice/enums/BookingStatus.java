package com.bookingapp.bookingservice.enums;

public enum BookingStatus {
    AVAILABLE("AVAILABLE"),
    PENDING("PENDING"),
    CONFIRMED("CONFIRMED"),
    COMPLETED("COMPLETED");

    private final String value;

    BookingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
