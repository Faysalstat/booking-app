package com.bookingapp.bookingservice.service;

import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.dto.client.HospitalDTO;

public interface ClientService {
    HospitalDTO saveHospital(HospitalDTO hospitalDTO);
    AmbulanceDriverDTO saveAmbulance(AmbulanceDriverDTO ambulanceDriverDTO);

//    HospitalDTO updateClient(HospitalDTO hospitalDTO);
}
