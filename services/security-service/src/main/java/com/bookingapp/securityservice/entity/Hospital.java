package com.bookingapp.bookingservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String hospital;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserDetails user;


    public Hospital() {
    }

    public Hospital(Long id, String hospital, UserDetails user) {
        this.id = id;
        this.hospital = hospital;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }
}
