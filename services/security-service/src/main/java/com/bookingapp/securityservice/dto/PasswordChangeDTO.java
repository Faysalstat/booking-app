package com.bookingapp.securityservice.dto;

public class PasswordChangeDTO {
    private String userName;
    private String previousPassword;
    private String newPassword;

    public PasswordChangeDTO(String userName, String previousPassword, String newPassword) {
        this.userName = userName;
        this.previousPassword = previousPassword;
        this.newPassword = newPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPreviousPassword() {
        return previousPassword;
    }

    public void setPreviousPassword(String previousPassword) {
        this.previousPassword = previousPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
