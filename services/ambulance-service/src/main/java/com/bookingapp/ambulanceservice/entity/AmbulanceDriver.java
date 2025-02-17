package com.bookingapp.ambulanceservice.entity;

import com.bookingapp.ambulanceservice.enums.AvailabilityStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "ambulance")
public class AmbulanceDriver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String driverName;
    @Column
    private String ambulanceNumber;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDetails user;

    @Column
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus status = AvailabilityStatus.AVAILABLE;

    public AmbulanceDriver() {
    }

    public AmbulanceDriver(Long id, String driverName, String ambulanceNumber, UserDetails user, AvailabilityStatus status) {
        this.id = id;
        this.driverName = driverName;
        this.ambulanceNumber = ambulanceNumber;
        this.user = user;
        this.status = status;
    }

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



    public String getAmbulanceNumber() {
        return ambulanceNumber;
    }

    public void setAmbulanceNumber(String ambulanceNumber) {
        this.ambulanceNumber = ambulanceNumber;
    }



    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public AvailabilityStatus getStatus() {
        return status;
    }

    public void setStatus(AvailabilityStatus status) {
        this.status = status;
    }
}
