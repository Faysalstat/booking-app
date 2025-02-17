package com.bookingapp.bookingservice.dto.client;

import com.bookingapp.bookingservice.entity.Hospital;
import com.bookingapp.bookingservice.entity.UserDetails;

public class ClientDTO {
    private UserDetails userDetails;
    private AmbulanceDriverDTO ambulanceDriverDTO;
    private Hospital hospital;

    public ClientDTO(UserDetails userDetails, AmbulanceDriverDTO ambulanceDriverDTO, Hospital hospital) {
        this.userDetails = userDetails;
        this.ambulanceDriverDTO = ambulanceDriverDTO;
        this.hospital = hospital;
    }

    public ClientDTO() {
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public AmbulanceDriverDTO getAmbulanceDriverDTO() {
        return ambulanceDriverDTO;
    }

    public void setAmbulanceDriverDTO(AmbulanceDriverDTO ambulanceDriverDTO) {
        this.ambulanceDriverDTO = ambulanceDriverDTO;
    }

    public Hospital getHospitalDTO() {
        return hospital;
    }

    public void setHospitalDTO(Hospital hospital) {
        this.hospital = hospital;
    }
}
