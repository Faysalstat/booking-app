package com.bookingapp.securityservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String hospitalName;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserCredential user;


    public Hospital() {
    }

    public Hospital(Long id, String hospital, UserCredential user) {
        this.id = id;
        this.hospitalName = hospital;
        this.user = user;
    }

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

    public UserCredential getUser() {
        return user;
    }

    public void setUser(UserCredential user) {
        this.user = user;
    }
}
