package com.bookingapp.bookingservice.dto.booking;

import java.time.LocalDateTime;

public class AmbulanceBookingDTO {
    private Long id;
    private Long userId;
    private Long ambulanceDriverId;
    private LocalDateTime bookingDateTime;
    private String status;

    // Constructors
    public AmbulanceBookingDTO() {}

    public AmbulanceBookingDTO(Long id, Long userId, Long ambulanceDriverId, LocalDateTime bookingDateTime, String status) {
        this.id = id;
        this.userId = userId;
        this.ambulanceDriverId = ambulanceDriverId;
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

    public Long getAmbulanceDriverId() {
        return ambulanceDriverId;
    }

    public void setAmbulanceDriverId(Long ambulanceDriverId) {
        this.ambulanceDriverId = ambulanceDriverId;
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

