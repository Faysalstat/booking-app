package com.bookingapp.bookingservice.entity;

import com.bookingapp.bookingservice.enums.BookingStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hospital_booking")
public class HospitalBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Which user booked the hospital
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetails user;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToOne
    @JoinColumn(name = "ambulance_booking_id")
    private AmbulanceBooking ambulanceBooking;

    @Column
    private LocalDateTime bookingDateTime = LocalDateTime.now();

    public HospitalBooking() {
    }

    public HospitalBooking(Long id, UserDetails user, Hospital hospital, AmbulanceBooking ambulanceBooking, LocalDateTime bookingDateTime) {
        this.id = id;
        this.user = user;
        this.hospital = hospital;
        this.ambulanceBooking = ambulanceBooking;
        this.bookingDateTime = bookingDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public AmbulanceBooking getAmbulanceBooking() {
        return ambulanceBooking;
    }

    public void setAmbulanceBooking(AmbulanceBooking ambulanceBooking) {
        this.ambulanceBooking = ambulanceBooking;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }
}
