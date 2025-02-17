package com.bookingapp.ambulanceservice.controller;

import com.bookingapp.ambulanceservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.ambulanceservice.dto.booking.BookingDTO;
import com.bookingapp.ambulanceservice.dto.booking.BookingRequestDTO;
import com.bookingapp.ambulanceservice.service.AmbulanceBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/ambulance/booking")
public class AmbulanceBookingController {
    private final AmbulanceBookingService ambulanceBookingService;

    public AmbulanceBookingController(AmbulanceBookingService ambulanceBookingService) {
        this.ambulanceBookingService = ambulanceBookingService;
    }

    @PostMapping
    public ResponseEntity<BookingDTO> bookAmbulance(@RequestBody BookingDTO bookingRequestDTO) {
        return ResponseEntity.ok().body(ambulanceBookingService.bookAmbulance(bookingRequestDTO));
    }
    @PutMapping("/get-all")
    public ResponseEntity<List<AmbulanceBookingDTO>> getAmbulanceBookingList(@RequestBody BookingRequestDTO bookingRequestDTO) {
        return ResponseEntity.ok().body(ambulanceBookingService.getAllAmbulanceBookingListByDriver(bookingRequestDTO));
    }
}
