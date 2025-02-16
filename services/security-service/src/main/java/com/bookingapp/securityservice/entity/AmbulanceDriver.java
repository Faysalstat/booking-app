package com.bookingapp.securityservice.entity;

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
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserCredential user;

    public AmbulanceDriver() {
    }

    public AmbulanceDriver(Long id, String driverName, String ambulanceNumber, UserCredential user) {
        this.id = id;
        this.driverName = driverName;
        this.ambulanceNumber = ambulanceNumber;
        this.user = user;
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



    public UserCredential getUser() {
        return user;
    }

    public void setUser(UserCredential user) {
        this.user = user;
    }
}
