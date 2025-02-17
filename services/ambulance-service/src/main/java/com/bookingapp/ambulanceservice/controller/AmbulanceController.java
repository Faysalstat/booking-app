package com.bookingapp.ambulanceservice.controller;


import com.bookingapp.ambulanceservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.ambulanceservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.ambulanceservice.service.AmbulanceBookingService;
import com.bookingapp.ambulanceservice.service.AmbulanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ambulance")
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
    public ResponseEntity<AmbulanceBookingDTO> updateAmbulanceBookingStatus(@RequestBody AmbulanceBookingDTO request){
        return ResponseEntity.ok().body(ambulanceBookingService.updateStatus(request));
    }


}

