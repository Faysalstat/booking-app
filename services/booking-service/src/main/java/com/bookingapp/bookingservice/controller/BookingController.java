package com.bookingapp.bookingservice.controller;

import com.bookingapp.bookingservice.dto.CityDto;
import com.bookingapp.bookingservice.dto.Distance;
import com.bookingapp.bookingservice.dto.ResponseDTO;
import com.bookingapp.bookingservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingRequestDTO;
import com.bookingapp.bookingservice.dto.booking.HospitalBookingDTO;
import com.bookingapp.bookingservice.serviceImp.CityServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking-service/booking")
public class BookingController {

    private final CityServiceImp cityServiceImp;
    public BookingController(CityServiceImp cityServiceImp) {
        this.cityServiceImp = cityServiceImp;
    }


    @PutMapping("/ambulance/get-all")
    public ResponseEntity<List<AmbulanceBookingDTO>> getAmbulanceBookingList(@RequestBody BookingRequestDTO bookingRequestDTO) {
        return null;
    }

    @PutMapping("/hospital/get-all")
    public ResponseEntity<List<HospitalBookingDTO>> getHospitalBookingList(@RequestBody BookingRequestDTO bookingRequestDTO) {
        return null;
    }
}
