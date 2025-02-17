package com.bookingapp.securityservice.enums;

public enum AvailabilityStatus {
    AVAILABLE("AVAILABLE"),
    BOOKED("BOOKED");

    private final String value;

    AvailabilityStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
