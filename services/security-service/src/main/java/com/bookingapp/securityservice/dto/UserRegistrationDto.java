package com.bookingapp.securityservice.dto;

import com.bookingapp.securityservice.enums.UserType;


public class UserRegistrationDto {
    private Long id;
    private String userName;
    private String password;
    private UserType userType;
    private String driverName;
    private String phone;
    private String ambulanceNumber;
    private String hospitalName;
    private String location;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(Long id,String userName, String password, UserType userType, String driverName, String phone, String ambulanceNumber, String hospitalName, String location) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.driverName = driverName;
        this.phone = phone;
        this.ambulanceNumber = ambulanceNumber;
        this.hospitalName = hospitalName;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAmbulanceNumber() {
        return ambulanceNumber;
    }

    public void setAmbulanceNumber(String ambulanceNumber) {
        this.ambulanceNumber = ambulanceNumber;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
