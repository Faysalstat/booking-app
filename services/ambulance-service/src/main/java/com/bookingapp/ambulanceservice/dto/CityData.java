package com.bookingapp.ambulanceservice.dto;
// CityData.java
import java.util.List;

public class CityData {
    private List<CityDto> cities;

    // getters and setters

    public List<CityDto> getCities() {
        return cities;
    }

    public void setCities(List<CityDto> cities) {
        this.cities = cities;
    }
}
