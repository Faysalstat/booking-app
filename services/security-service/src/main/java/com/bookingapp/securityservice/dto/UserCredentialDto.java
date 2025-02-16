package com.bookingapp.securityservice.dto;


import com.bookingapp.securityservice.enums.UserType;


public class UserCredentialDto {
    private  Long id;
    private String userName;
    private UserType userType;
    private String password;

    public UserCredentialDto() {
    }

    public UserCredentialDto(Long id,String email, UserType userType, String password) {
        this.id = id;
        this.userName = email;
        this.userType = userType;
        this.password = password;
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


    public void setEmail(String email) {
        this.userName = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
