package com.bookingapp.securityservice.dto;

import com.bookingapp.securityservice.enums.UserType;


public class LoginResponse {

    private String token;
    private String userName;

    private UserType userType;
    private long userId;

    public LoginResponse() {
    }

    public LoginResponse(String token, String userName,UserType userType, long userId) {
        this.token = token;
        this.userName = userName;
        this.userType = userType;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
