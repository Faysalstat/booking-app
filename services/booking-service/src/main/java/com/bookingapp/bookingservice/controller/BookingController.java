package com.bookingapp.bookingservice.controller;

import com.bookingapp.bookingservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingRequestDTO;
import com.bookingapp.bookingservice.dto.booking.HospitalBookingDTO;
import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.entity.AmbulanceBooking;
import com.bookingapp.bookingservice.service.AmbulanceBookingService;
import com.bookingapp.bookingservice.service.HospitalBookingService;
import com.bookingapp.bookingservice.serviceImp.CityServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking-service/booking")
public class BookingController {
    private final HospitalBookingService hospitalBookingService;
    private final AmbulanceBookingService ambulanceBookingService;
    private final CityServiceImp cityServiceImp;
    public BookingController(HospitalBookingService hospitalBookingService, AmbulanceBookingService ambulanceBookingService, CityServiceImp cityServiceImp) {
        this.hospitalBookingService = hospitalBookingService;
        this.ambulanceBookingService = ambulanceBookingService;
        this.cityServiceImp = cityServiceImp;
    }

    @PostMapping
    public ResponseEntity<BookingDTO> bookAmbulanceAndHospital(@RequestBody BookingDTO bookingRequestDTO) {
        return ResponseEntity.ok().body(hospitalBookingService.bookHospital(bookingRequestDTO));
    }
    @PutMapping("/ambulance/get-all")
    public ResponseEntity<List<AmbulanceBookingDTO>> getAmbulanceBookingList(@RequestBody BookingRequestDTO bookingRequestDTO) {
        return ResponseEntity.ok().body(ambulanceBookingService.getAllAmbulanceBookingListByDriver(bookingRequestDTO));
    }

    @PutMapping("/hospital/get-all")
    public ResponseEntity<List<HospitalBookingDTO>> getHospitalBookingList(@RequestBody BookingRequestDTO bookingRequestDTO) {
        return null;
    }

//    @GetMapping("/get-all-booking")
//    public ResponseEntity<List<AmbulanceDriverDTO>> getAllBookingByDriverId(@RequestParam("id") Long id) {
//        return ResponseEntity.ok().body(ambulanceBookingService.getAllAmbulanceBookingListByDriver(id));
//    }
}
