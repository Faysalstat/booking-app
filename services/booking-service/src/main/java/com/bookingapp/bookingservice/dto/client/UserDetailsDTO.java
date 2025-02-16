package com.bookingapp.bookingservice.dto.client;


import com.bookingapp.bookingservice.enums.UserType;

public class UserDetailsDTO {
    private Long id;
    private String userName;
    private UserType userType;
    private String phone;
    private String location;

    public UserDetailsDTO() {
    }

    public UserDetailsDTO(Long id, String userName, UserType userType, String phone, String location) {
        this.id = id;
        this.userName = userName;
        this.userType = userType;
        this.phone = phone;
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


    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
