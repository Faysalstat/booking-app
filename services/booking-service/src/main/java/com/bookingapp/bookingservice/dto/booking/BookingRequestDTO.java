package com.bookingapp.bookingservice.dto.booking;

import com.bookingapp.bookingservice.enums.BookingStatus;
import com.bookingapp.bookingservice.enums.UserType;

public class BookingRequestDTO {

    private UserType userType;

    private BookingStatus bookingStatus;

    private Long userId;

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
