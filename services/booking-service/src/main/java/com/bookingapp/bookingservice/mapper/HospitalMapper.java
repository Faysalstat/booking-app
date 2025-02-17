package com.bookingapp.bookingservice.mapper;

import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.dto.client.HospitalDTO;
import com.bookingapp.bookingservice.entity.Hospital;

public class HospitalMapper {
    public static HospitalDTO toDTO(Hospital entity) {
        if (entity == null) {
            return null;
        }
        HospitalDTO dto = new HospitalDTO();
        dto.setId(entity.getId());
        dto.setHospitalName(entity.getHospitalName());
        dto.setPhone(entity.getUser().getPhone());
        dto.setLocation(entity.getUser().getLocation());
        return dto;
    }
}
