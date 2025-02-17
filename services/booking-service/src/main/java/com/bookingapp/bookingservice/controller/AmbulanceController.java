package com.bookingapp.bookingservice.controller;


import com.bookingapp.bookingservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.enums.AvailabilityStatus;
import com.bookingapp.bookingservice.enums.BookingStatus;
import com.bookingapp.bookingservice.service.AmbulanceBookingService;
import com.bookingapp.bookingservice.service.AmbulanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking-service/ambulance")
public class AmbulanceController {
    private  final AmbulanceService ambulanceService;
    private  final AmbulanceBookingService ambulanceBookingService;


    public AmbulanceController(AmbulanceService ambulanceService, AmbulanceBookingService ambulanceBookingService) {
        this.ambulanceService = ambulanceService;
        this.ambulanceBookingService = ambulanceBookingService;
    }

    @GetMapping("/nearest")
    public ResponseEntity<List<AmbulanceDriverDTO>> getNearestAmbulances(@RequestParam("location") String location) {
        return ResponseEntity.ok().body(ambulanceService.getNearestAmbulanceList(location));
    }

    @PutMapping("/update")
    public ResponseEntity<AmbulanceBookingDTO> updateAmbulanceBookingStatus(@RequestParam("bookingId") Long bookingId, @RequestParam("status") BookingStatus status){
        return ResponseEntity.ok().body(ambulanceBookingService.updateStatus(bookingId,status));
    }


}
