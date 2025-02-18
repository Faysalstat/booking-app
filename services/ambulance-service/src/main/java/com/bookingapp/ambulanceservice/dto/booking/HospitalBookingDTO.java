package com.bookingapp.ambulanceservice.dto.booking;

import java.time.LocalDateTime;

public class HospitalBookingDTO {
    private Long id;
    private Long userId;
    private Long hospitalId;
    private Long ambulanceBookingId;
    private LocalDateTime bookingDateTime;
    private String status;

    // Constructors
    public HospitalBookingDTO() {}

    public HospitalBookingDTO(Long id, Long userId, Long hospitalId, Long ambulanceBookingId, LocalDateTime bookingDateTime, String status) {
        this.id = id;
        this.userId = userId;
        this.hospitalId = hospitalId;
        this.ambulanceBookingId = ambulanceBookingId;
        this.bookingDateTime = bookingDateTime;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getAmbulanceBookingId() {
        return ambulanceBookingId;
    }

    public void setAmbulanceBookingId(Long ambulanceBookingId) {
        this.ambulanceBookingId = ambulanceBookingId;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

