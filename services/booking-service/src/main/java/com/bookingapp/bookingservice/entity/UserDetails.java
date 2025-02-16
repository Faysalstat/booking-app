package com.bookingapp.bookingservice.entity;


import com.bookingapp.bookingservice.enums.UserType;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String location;
    @Column
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public UserDetails() {
    }

    public UserDetails(Long id, String username, String password, String location, String phone, UserType userType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.location = location;
        this.phone = phone;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}