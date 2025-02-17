package com.bookingapp.ambulanceservice.mapper;

import com.bookingapp.ambulanceservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.ambulanceservice.entity.AmbulanceDriver;

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