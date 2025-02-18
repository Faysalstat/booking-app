package com.bookingapp.ambulanceservice.service;

import com.bookingapp.ambulanceservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.ambulanceservice.dto.booking.BookingDTO;
import com.bookingapp.ambulanceservice.dto.booking.BookingRequestDTO;

import java.util.List;

public interface AmbulanceBookingService {
    BookingDTO bookAmbulance(BookingDTO bookingDTO);
    List<AmbulanceBookingDTO> getAllAmbulanceBookingListByDriver(BookingRequestDTO bookingRequestDTO);
    AmbulanceBookingDTO updateStatus(AmbulanceBookingDTO request);
}

