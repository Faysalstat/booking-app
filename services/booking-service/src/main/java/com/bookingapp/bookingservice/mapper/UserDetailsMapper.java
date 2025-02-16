package com.bookingapp.bookingservice.mapper;

import com.bookingapp.bookingservice.dto.client.UserDetailsDTO;
import com.bookingapp.bookingservice.entity.UserDetails;

public class UserDetailsMapper {
    public static UserDetailsDTO toUserDetailsDto(UserDetails entity) {
        if (entity == null) {
            return null;
        }
        UserDetailsDTO dto = new UserDetailsDTO();
        dto.setId(entity.getId());
        dto.setUserName(entity.getUsername());
        dto.setUserType(entity.getUserType());
        dto.setAmbulanceNumber(entity.getAmbulanceNumber());
        dto.setDriverName(entity.getDriverName());
        dto.setHospitalName(entity.getHospitalName());
        dto.setPhone(entity.getPhone());
        dto.setLocation(entity.getLocation());
        return dto;
    }
}
