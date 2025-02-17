package com.bookingapp.bookingservice.service;

import com.bookingapp.bookingservice.dto.booking.BookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingRequestDTO;
import com.bookingapp.bookingservice.dto.booking.HospitalBookingDTO;
import com.bookingapp.bookingservice.dto.booking.HospitalBookingResponseDTO;

import java.util.List;

public interface HospitalBookingService {
    BookingDTO bookHospital(BookingDTO bookingDTO);
    List<HospitalBookingResponseDTO> getAllHospitalBookingList(BookingRequestDTO requestDTO);
}
