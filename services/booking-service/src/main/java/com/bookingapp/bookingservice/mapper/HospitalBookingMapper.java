package com.bookingapp.bookingservice.mapper;

import com.bookingapp.bookingservice.dto.booking.BookingDTO;
import com.bookingapp.bookingservice.dto.booking.HospitalBookingDTO;
import com.bookingapp.bookingservice.entity.AmbulanceBooking;
import com.bookingapp.bookingservice.entity.Hospital;
import com.bookingapp.bookingservice.entity.HospitalBooking;
import com.bookingapp.bookingservice.entity.UserDetails;
import com.bookingapp.bookingservice.enums.BookingStatus;

import java.time.LocalDateTime;

public class HospitalBookingMapper {
    public static BookingDTO toDTO(HospitalBooking booking) {
        if (booking == null) {
            return null;
        }
        BookingDTO dto = new BookingDTO();
        dto.setHospitalBookingId(booking.getId());
        dto.setAmbulanceBookingId(booking.getAmbulanceBooking().getId());
        dto.setHospitalId(booking.getHospital() != null ? booking.getHospital().getId() : null);
        dto.setBookingDateTime(booking.getBookingDateTime());
        dto.setPickupLocation(booking.getAmbulanceBooking().getPickupLocation());
        return dto;
    }

    public static HospitalBooking toEntity(BookingDTO bookingDTO, UserDetails user, Hospital hospital, AmbulanceBooking ambulanceBooking) {
        if (bookingDTO == null) {
            return null;
        }
        HospitalBooking booking = new HospitalBooking();
        booking.setId(bookingDTO.getId());
        booking.setUser(user);
        booking.setHospital(hospital);
        booking.setAmbulanceBooking(ambulanceBooking);
        booking.setBookingDateTime(LocalDateTime.now());
        return booking;
    }
}
