package com.bookingapp.bookingservice.controller;

import com.bookingapp.bookingservice.dto.booking.*;
import com.bookingapp.bookingservice.service.HospitalBookingService;
import com.bookingapp.bookingservice.serviceImp.CityServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking-service/booking")
public class BookingController {
    private final HospitalBookingService hospitalBookingService;
    private final CityServiceImp cityServiceImp;
    public BookingController(HospitalBookingService hospitalBookingService, CityServiceImp cityServiceImp) {
        this.hospitalBookingService = hospitalBookingService;
        this.cityServiceImp = cityServiceImp;
    }

    @PostMapping
    public ResponseEntity<BookingDTO> bookAmbulanceAndHospital(@RequestBody BookingDTO bookingRequestDTO) {
        return ResponseEntity.ok().body(hospitalBookingService.bookHospital(bookingRequestDTO));
    }

    @PutMapping("/hospital/get-all")
    public ResponseEntity<List<HospitalBookingResponseDTO>> getHospitalBookingList(@RequestBody BookingRequestDTO bookingRequestDTO) {
        return ResponseEntity.ok().body(hospitalBookingService.getAllHospitalBookingList(bookingRequestDTO));
    }

}
