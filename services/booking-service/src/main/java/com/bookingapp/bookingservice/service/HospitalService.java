package com.bookingapp.bookingservice.service;

import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.dto.client.HospitalDTO;

import java.util.List;

public interface HospitalService {
    List<HospitalDTO> getNearestHospitalList(String location);
}
