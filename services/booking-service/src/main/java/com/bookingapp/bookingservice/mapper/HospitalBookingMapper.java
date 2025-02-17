package com.bookingapp.bookingservice.mapper;

import com.bookingapp.bookingservice.dto.booking.BookingDTO;
import com.bookingapp.bookingservice.dto.booking.HospitalBookingDTO;
import com.bookingapp.bookingservice.dto.booking.HospitalBookingResponseDTO;
import com.bookingapp.bookingservice.entity.AmbulanceBooking;
import com.bookingapp.bookingservice.entity.Hospital;
import com.bookingapp.bookingservice.entity.HospitalBooking;
import com.bookingapp.bookingservice.entity.UserDetails;
import com.bookingapp.bookingservice.enums.BookingStatus;
import com.bookingapp.bookingservice.enums.UserType;

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
    public static HospitalBookingResponseDTO toBookingDTO(HospitalBooking booking,UserType userType) {
        if (booking == null) {
            return null;
        }
        HospitalBookingResponseDTO dto = new HospitalBookingResponseDTO();
        dto.setUserType(userType);
        if(userType.equals(UserType.USER)){
            dto.setUserId(booking.getUser().getId());
        }else if(userType.equals(UserType.HOSPITAL)){
            dto.setUserId(booking.getHospital().getUser().getId());
        }
        dto.setDriverName(booking.getAmbulanceBooking().getAmbulanceDriver().getDriverName());
        dto.setDriverPhone(booking.getAmbulanceBooking().getAmbulanceDriver().getUser().getPhone());
        dto.setAmbulanceNumber(booking.getAmbulanceBooking().getAmbulanceDriver().getAmbulanceNumber());
        dto.setHospitalName(booking.getHospital() != null ? booking.getHospital().getHospitalName() : null);
        dto.setHospitalLocation(booking.getHospital().getUser().getLocation());
        dto.setHospitalPhone(booking.getHospital().getUser().getPhone());
        dto.setPickupPoint(booking.getAmbulanceBooking().getPickupLocation());
        dto.setStatus(booking.getAmbulanceBooking().getStatus());
        return dto;
    }



}
