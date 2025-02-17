package com.bookingapp.bookingservice.controller;

import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.dto.client.HospitalDTO;
import com.bookingapp.bookingservice.repository.HospitalRepository;
import com.bookingapp.bookingservice.service.AmbulanceService;
import com.bookingapp.bookingservice.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/booking-service/hospital")
public class HospitalController {
    private  final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/nearest")
    public ResponseEntity<List<HospitalDTO>> getNearestAmbulances(@RequestParam("location") String location) {
        return ResponseEntity.ok().body(hospitalService.getNearestHospitalList(location));
    }
}
