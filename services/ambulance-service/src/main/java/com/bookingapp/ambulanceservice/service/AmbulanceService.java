package com.bookingapp.ambulanceservice.service;

import com.bookingapp.ambulanceservice.dto.client.AmbulanceDriverDTO;

import java.util.List;

public interface AmbulanceService {
    List<AmbulanceDriverDTO> getNearestAmbulanceList(String location);


}
