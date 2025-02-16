package com.bookingapp.bookingservice.dto.client;

public class AmbulanceDriverDTO {
    private Long id;
    private String driverName;
    private String phone;
    private String ambulanceNumber;
    private String location;
    private Long userId;

    // Constructors
    public AmbulanceDriverDTO() {}

    public AmbulanceDriverDTO(Long id, String driverName, String phone, String ambulanceNumber, String location, Long userId) {
        this.id = id;
        this.driverName = driverName;
        this.phone = phone;
        this.ambulanceNumber = ambulanceNumber;
        this.location = location;
        this.userId = userId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAmbulanceNumber() {
        return ambulanceNumber;
    }

    public void setAmbulanceNumber(String ambulanceNumber) {
        this.ambulanceNumber = ambulanceNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
