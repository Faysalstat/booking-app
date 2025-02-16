package com.bookingapp.bookingservice.dto.booking;

import com.bookingapp.bookingservice.enums.BookingStatus;

public class BookingRequestDTO {
    private BookingStatus bookingStatus;

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
