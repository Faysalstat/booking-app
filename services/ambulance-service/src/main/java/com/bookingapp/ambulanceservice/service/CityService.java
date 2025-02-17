package com.bookingapp.ambulanceservice.service;

import com.bookingapp.ambulanceservice.dto.Distance;

import java.util.List;

public interface CityService {
    List<Distance> getCitiesOrderedByDistance(String cityName);
    List<String> getAllCities();
}
