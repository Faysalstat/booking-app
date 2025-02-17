package com.bookingapp.bookingservice.service;

import com.bookingapp.bookingservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingRequestDTO;
import com.bookingapp.bookingservice.dto.booking.HospitalBookingResponseDTO;
import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.entity.AmbulanceBooking;
import com.bookingapp.bookingservice.enums.AvailabilityStatus;
import com.bookingapp.bookingservice.enums.BookingStatus;

import java.util.List;

public interface AmbulanceBookingService {
    BookingDTO bookAmbulance(BookingDTO bookingDTO);
    List<AmbulanceBookingDTO> getAllAmbulanceBookingListByDriver(BookingRequestDTO bookingRequestDTO);

    List<HospitalBookingResponseDTO> getAllBookingListByUserAndType(BookingRequestDTO bookingRequestDTO);
    AmbulanceBookingDTO updateStatus(AmbulanceBookingDTO request);
}

