package com.bookingapp.bookingservice.controller;

import com.bookingapp.bookingservice.dto.Distance;
import com.bookingapp.bookingservice.dto.ResponseDTO;
import com.bookingapp.bookingservice.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/booking-service/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/closest-list")
    public ResponseEntity<ResponseDTO<List<Distance>>> getClosestCity(@RequestParam String city) {
        List<Distance> closestCityList = cityService.getCitiesOrderedByDistance(city);
        return ResponseEntity.ok().body(new ResponseDTO<List<Distance>>(true,"Successful",closestCityList));
    }

    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO<List<String>>> getClosestCity() {
        return ResponseEntity.ok().body(new ResponseDTO<List<String>>(true,"Successful",cityService.getAllCities()));
    }
}
