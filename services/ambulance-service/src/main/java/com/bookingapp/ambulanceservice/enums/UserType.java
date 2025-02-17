package com.bookingapp.bookingservice.enums;

public enum UserType {
    USER("USER"),
    HOSPITAL("HOSPITAL"),
    AMBULANCE("AMBULANCE");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}