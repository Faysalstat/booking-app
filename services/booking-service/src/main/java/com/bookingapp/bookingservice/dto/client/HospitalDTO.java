package com.bookingapp.bookingservice.dto.client;

public class HospitalDTO {
    private Long id;
    private String hospitalName;
    private String location;
    private Long userId;

    // Constructors
    public HospitalDTO() {}

    public HospitalDTO(Long id, String hospitalName, String location, Long userId) {
        this.id = id;
        this.hospitalName = hospitalName;
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

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
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

