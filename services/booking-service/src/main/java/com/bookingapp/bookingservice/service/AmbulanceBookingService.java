package com.bookingapp.bookingservice.service;

import com.bookingapp.bookingservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingRequestDTO;
import com.bookingapp.bookingservice.entity.AmbulanceBooking;

import java.util.List;

public interface AmbulanceBookingService {
    AmbulanceBookingDTO bookAmbulance(AmbulanceBookingDTO ambulanceBookingDTO);
    List<AmbulanceBooking> getAllAmbulanceBookingList(BookingRequestDTO requestDTO);
}
