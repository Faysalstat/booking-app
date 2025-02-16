package com.bookingapp.bookingservice.mapper;

import com.bookingapp.bookingservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.bookingservice.entity.AmbulanceBooking;
import com.bookingapp.bookingservice.entity.AmbulanceDriver;
import com.bookingapp.bookingservice.entity.UserDetails;
import com.bookingapp.bookingservice.enums.BookingStatus;

public class AmbulanceBookingMapper {
    public static AmbulanceBookingDTO toDTO(AmbulanceBooking booking) {
        if (booking == null) {
            return null;
        }
        return new AmbulanceBookingDTO(
                booking.getId(),
                booking.getUser() != null ? booking.getUser().getId() : null,
                booking.getAmbulanceDriver() != null ? booking.getAmbulanceDriver().getId() : null,
                booking.getBookingDateTime(),
                booking.getStatus() != null ? booking.getStatus().name() : null
        );
    }

    public static AmbulanceBooking toEntity(AmbulanceBookingDTO bookingDTO, UserDetails user, AmbulanceDriver driver) {
        if (bookingDTO == null) {
            return null;
        }
        AmbulanceBooking booking = new AmbulanceBooking();
        booking.setId(bookingDTO.getId());
        booking.setUser(user);
        booking.setAmbulanceDriver(driver);
        booking.setBookingDateTime(bookingDTO.getBookingDateTime());
        booking.setStatus(BookingStatus.valueOf(bookingDTO.getStatus()));
        return booking;
    }
}
