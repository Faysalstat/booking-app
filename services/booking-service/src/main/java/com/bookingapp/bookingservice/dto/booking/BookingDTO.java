package com.bookingapp.bookingservice.dto.booking;

import java.time.LocalDateTime;

public class BookingDTO {
    private Long id;
    private Long userId;
    private Long ambulanceDriverId;
    private Long ambulanceBookingId;

    private Long hospitalBookingId;
    private Long hospitalId;
    private LocalDateTime bookingDateTime;
    private String pickupLocation;
    private String status;

    public BookingDTO() {
    }

    public BookingDTO(Long id, Long userId, Long ambulanceDriverId, Long ambulanceBookingId, Long hospitalBookingId, Long hospitalId, LocalDateTime bookingDateTime, String pickupLocation, String status) {
        this.id = id;
        this.userId = userId;
        this.ambulanceDriverId = ambulanceDriverId;
        this.ambulanceBookingId = ambulanceBookingId;
        this.hospitalBookingId = hospitalBookingId;
        this.hospitalId = hospitalId;
        this.bookingDateTime = bookingDateTime;
        this.pickupLocation = pickupLocation;
        this.status = status;
    }

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

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAmbulanceBookingId() {
        return ambulanceBookingId;
    }

    public void setAmbulanceBookingId(Long ambulanceBookingId) {
        this.ambulanceBookingId = ambulanceBookingId;
    }

    public Long getHospitalBookingId() {
        return hospitalBookingId;
    }

    public void setHospitalBookingId(Long hospitalBookingId) {
        this.hospitalBookingId = hospitalBookingId;
    }
}

