package com.bookingapp.bookingservice.mapper;

import com.bookingapp.bookingservice.dto.booking.HospitalBookingDTO;
import com.bookingapp.bookingservice.entity.AmbulanceBooking;
import com.bookingapp.bookingservice.entity.Hospital;
import com.bookingapp.bookingservice.entity.HospitalBooking;
import com.bookingapp.bookingservice.entity.UserDetails;
import com.bookingapp.bookingservice.enums.BookingStatus;

public class HospitalBookingMapper {
    public static HospitalBookingDTO toDTO(HospitalBooking booking) {
        if (booking == null) {
            return null;
        }
        return new HospitalBookingDTO(
                booking.getId(),
                booking.getUser() != null ? booking.getUser().getId() : null,
                booking.getHospital() != null ? booking.getHospital().getId() : null,
                booking.getAmbulanceBooking() != null ? booking.getAmbulanceBooking().getId() : null,
                booking.getBookingDateTime(),
                booking.getStatus() != null ? booking.getStatus().name() : null
        );
    }

    public static HospitalBooking toEntity(HospitalBookingDTO bookingDTO, UserDetails user, Hospital hospital, AmbulanceBooking ambulanceBooking) {
        if (bookingDTO == null) {
            return null;
        }
        HospitalBooking booking = new HospitalBooking();
        booking.setId(bookingDTO.getId());
        booking.setUser(user);
        booking.setHospital(hospital);
        booking.setAmbulanceBooking(ambulanceBooking);
        booking.setBookingDateTime(bookingDTO.getBookingDateTime());
        booking.setStatus(BookingStatus.valueOf(bookingDTO.getStatus()));
        return booking;
    }
}
