package com.bookingapp.bookingservice.service;

import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.enums.AvailabilityStatus;

import java.util.List;

public interface AmbulanceService {
    List<AmbulanceDriverDTO> getNearestAmbulanceList(String location);


}
