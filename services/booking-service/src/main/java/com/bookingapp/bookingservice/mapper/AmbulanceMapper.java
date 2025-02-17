package com.bookingapp.bookingservice.mapper;

import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.dto.client.HospitalDTO;
import com.bookingapp.bookingservice.entity.AmbulanceDriver;
import com.bookingapp.bookingservice.entity.Hospital;

public class AmbulanceMapper {
    public static AmbulanceDriverDTO toDTO(AmbulanceDriver entity) {
        if (entity == null) {
            return null;
        }
        AmbulanceDriverDTO dto = new AmbulanceDriverDTO();
        dto.setId(entity.getId());
        dto.setDriverName(entity.getDriverName());
        dto.setPhone(entity.getUser().getPhone());
        dto.setAmbulanceNumber(entity.getAmbulanceNumber());
        dto.setLocation(entity.getUser().getLocation());
        return dto;
    }
}
