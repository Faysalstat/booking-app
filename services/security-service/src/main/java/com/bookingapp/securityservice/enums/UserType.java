package com.bookingapp.securityservice;

public enum UserType {
    USER("User"),
    HOSPITAL("Hospital"),
    AMBULANCE("Ambulance");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
