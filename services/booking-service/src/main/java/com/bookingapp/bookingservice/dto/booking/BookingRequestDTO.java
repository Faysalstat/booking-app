package com.bookingapp.bookingservice.dto.booking;

import com.bookingapp.bookingservice.enums.BookingStatus;

public class BookingRequestDTO {

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
}
