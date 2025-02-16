package com.bookingapp.bookingservice.dto.client;

import com.bookingapp.bookingservice.entity.UserDetails;

public class ClientDTO {
    private UserDetails userDetails;
    private AmbulanceDriverDTO ambulanceDriverDTO;
    private HospitalDTO hospitalDTO;

    public ClientDTO(UserDetails userDetails, AmbulanceDriverDTO ambulanceDriverDTO, HospitalDTO hospitalDTO) {
        this.userDetails = userDetails;
        this.ambulanceDriverDTO = ambulanceDriverDTO;
        this.hospitalDTO = hospitalDTO;
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

    public HospitalDTO getHospitalDTO() {
        return hospitalDTO;
    }

    public void setHospitalDTO(HospitalDTO hospitalDTO) {
        this.hospitalDTO = hospitalDTO;
    }
}
