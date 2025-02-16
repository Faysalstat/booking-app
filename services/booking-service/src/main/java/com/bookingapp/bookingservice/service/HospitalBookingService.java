package com.bookingapp.bookingservice.service;

import com.bookingapp.bookingservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingRequestDTO;
import com.bookingapp.bookingservice.dto.booking.HospitalBookingDTO;
import com.bookingapp.bookingservice.entity.AmbulanceBooking;

import java.util.List;

public interface HospitalBookingService {
    HospitalBookingDTO bookHospital(HospitalBookingDTO hospitalBookingDTO);
    List<HospitalBookingDTO> getAllHospitalBookingList(BookingRequestDTO requestDTO);
}
