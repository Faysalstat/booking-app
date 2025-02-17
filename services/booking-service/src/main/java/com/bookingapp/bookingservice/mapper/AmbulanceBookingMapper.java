package com.bookingapp.bookingservice.mapper;

import com.bookingapp.bookingservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingDTO;
import com.bookingapp.bookingservice.entity.AmbulanceBooking;
import com.bookingapp.bookingservice.entity.AmbulanceDriver;
import com.bookingapp.bookingservice.entity.Hospital;
import com.bookingapp.bookingservice.entity.UserDetails;
import com.bookingapp.bookingservice.enums.BookingStatus;

import java.time.LocalDateTime;

public class AmbulanceBookingMapper {
    public static BookingDTO toDTO(AmbulanceBooking booking) {
        if (booking == null) {
            return null;
        }
        BookingDTO dto = new BookingDTO();
        dto.setAmbulanceBookingId(booking.getId());
        dto.setAmbulanceDriverId(booking.getAmbulanceDriver() != null ? booking.getAmbulanceDriver().getId() : null);
        dto.setHospitalId(booking.getHospital() != null ? booking.getHospital().getId() : null);
        dto.setBookingDateTime(booking.getBookingDateTime());
        dto.setPickupLocation(booking.getPickupLocation());
        return dto;
    }
    public static AmbulanceBooking toEntity(BookingDTO bookingDTO, UserDetails user, AmbulanceDriver driver) {
        if (bookingDTO == null) {
            return null;
        }
        AmbulanceBooking booking = new AmbulanceBooking();
        booking.setId(bookingDTO.getId());
        booking.setUser(user);
        booking.setAmbulanceDriver(driver);
        booking.setHospital(new Hospital(bookingDTO.getHospitalId()));
        booking.setBookingDateTime(LocalDateTime.now());
        booking.setPickupLocation(bookingDTO.getPickupLocation());
        return booking;
    }

    public static AmbulanceBookingDTO toAmbulanceBookingDTO(AmbulanceBooking entity) {
        if (entity == null) {
            return null;
        }
        AmbulanceBookingDTO dto = new AmbulanceBookingDTO();
        dto.setId(entity.getId());
        dto.setDriverId(entity.getAmbulanceDriver().getId());
        dto.setPassengerPhone(entity.getUser().getPhone());
        dto.setPickupPoint(entity.getPickupLocation());
        dto.setHospitalName(entity.getHospital().getHospitalName());
        dto.setHospitalLocation(entity.getHospital().getUser().getLocation());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
