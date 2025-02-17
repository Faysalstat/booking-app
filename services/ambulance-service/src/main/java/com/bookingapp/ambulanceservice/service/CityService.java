package com.bookingapp.bookingservice.service;

import com.bookingapp.bookingservice.dto.Distance;

import java.util.List;

public interface CityService {
    List<Distance> getCitiesOrderedByDistance(String cityName);
    List<String> getAllCities();
}
