package com.bookingapp.bookingservice.serviceImp;

import com.bookingapp.bookingservice.dto.CityData;
import com.bookingapp.bookingservice.dto.CityDto;
import com.bookingapp.bookingservice.dto.Distance;
import com.bookingapp.bookingservice.service.CityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImp implements CityService {


    public CityServiceImp() {

    }

    private CityData loadCityData() {
        try {
            // Locate the file in src/main/resources
            ClassPathResource resource = new ClassPathResource("cityData.json");
            // Get InputStream
            InputStream inputStream = resource.getInputStream();
            // Parse JSON using Jackson
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(inputStream, CityData.class);
        } catch (IOException e) {
            // Handle the exception properly in production code
            e.printStackTrace();
            return null;
        }
    }
    // Helper method to search a city in the loaded data
    private CityDto findCityByName(String cityName,CityData cityData) {
        return cityData.getCities().stream()
                .filter(city -> city.getName().equalsIgnoreCase(cityName))
                .findFirst()
                .orElse(null);
    }

    // Haversine formula implementation

    private double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371; // Earth radius in kilometers

        // Convert degrees to radians
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // Haversine formula
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distance in km
        return R * c;
    }

    @Override
    public List<Distance> getCitiesOrderedByDistance(String cityName) {
        CityData cityData = loadCityData();

        List<Distance> cityDistance = new ArrayList<>();
        // 1. Find the reference city
        CityDto referenceCity = findCityByName(cityName,cityData);
        if (referenceCity == null) {
            throw new IllegalArgumentException("City not found: " + cityName);
        }
        List<CityDto> filteredCities = cityData.getCities().stream()
                .filter(city -> !city.getName().equalsIgnoreCase(cityName))
                .collect(Collectors.toList());
        for (CityDto c : filteredCities) {
            double distance = calculateHaversineDistance(referenceCity.getLatitude(), referenceCity.getLongitude(), c.getLatitude(), c.getLongitude());
            System.out.println(c.getName() + " => " + distance);
            cityDistance.add(new Distance(c.getName(),distance));
        }

        // 3. Sort the list by ascending distance using the Haversine formula
        cityDistance.sort((c1, c2) -> {
            return Double.compare(c1.getDistance(), c2.getDistance());  // ascending order
        });

        return cityDistance;
    }

    @Override
    public List<String> getAllCities() {
        CityData cityData = loadCityData();
        return cityData.getCities().stream()
                .map(item-> item.getName())
                .collect(Collectors.toList());
    }

}
