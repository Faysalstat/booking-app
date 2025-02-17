package com.bookingapp.bookingservice.dto.booking;

import com.bookingapp.bookingservice.entity.AmbulanceDriver;
import com.bookingapp.bookingservice.entity.Hospital;
import com.bookingapp.bookingservice.entity.UserDetails;
import com.bookingapp.bookingservice.enums.BookingStatus;
import jakarta.persistence.*;

public class AmbulanceBookingDTO {
    private Long id;
    private Long driverId;
    private String passengerName;
    private String passengerPhone;
    private String pickupPoint;
    private String hospitalName;
    private String hospitalLocation;
    private BookingStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public String getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(String pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalLocation() {
        return hospitalLocation;
    }

    public void setHospitalLocation(String hospitalLocation) {
        this.hospitalLocation = hospitalLocation;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public AmbulanceDriver getAmbulanceDriver() {
        return ambulanceDriver;
    }

    public void setAmbulanceDriver(AmbulanceDriver ambulanceDriver) {
        this.ambulanceDriver = ambulanceDriver;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @ManyToOne
    @JoinColumn(name = "ambulance_id")
    private AmbulanceDriver ambulanceDriver;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
