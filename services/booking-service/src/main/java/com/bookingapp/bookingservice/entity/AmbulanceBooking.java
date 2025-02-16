package com.bookingapp.bookingservice.entity;


import com.bookingapp.bookingservice.enums.BookingStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "hospital_bookings")
public class AmbulanceBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetails user;

    @ManyToOne
    @JoinColumn(name = "ambulance_id")
    private AmbulanceDriver ambulanceDriver;

    @Column
    private LocalDateTime bookingDateTime;
    @Enumerated(EnumType.STRING)
    private BookingStatus status; // PENDING, CONFIRMED, COMPLETED




    public AmbulanceBooking() {
    }

    public AmbulanceBooking(Long id, UserDetails user, AmbulanceDriver ambulanceDriver, LocalDateTime bookingDateTime,BookingStatus status) {
        this.id = id;
        this.user = user;
        this.ambulanceDriver = ambulanceDriver;
        this.bookingDateTime = bookingDateTime;
        this.status = status;
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

    public AmbulanceDriver getAmbulanceDriver() {
        return ambulanceDriver;
    }

    public void setAmbulanceDriver(AmbulanceDriver ambulanceDriver) {
        this.ambulanceDriver = ambulanceDriver;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
