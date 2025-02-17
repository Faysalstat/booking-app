package com.bookingapp.securityservice.mapper;

import com.bookingapp.securityservice.dto.UserCredentialDto;
import com.bookingapp.securityservice.dto.UserDetailsDTO;
import com.bookingapp.securityservice.dto.UserRegistrationDto;
import com.bookingapp.securityservice.entity.AmbulanceDriver;
import com.bookingapp.securityservice.entity.Hospital;
import com.bookingapp.securityservice.entity.UserCredential;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserCredentialMapper {
    public static UserCredentialDto toDto(UserCredential entity) {
        if (entity == null) {
            return null;
        }

        UserCredentialDto dto = new UserCredentialDto();
        dto.setId(entity.getId());
        dto.setUserName(entity.getUsername());
        dto.setUserType(entity.getUserType());
        dto.setPassword(entity.getPassword());

        return dto;
    }

    public static UserCredential toEntity(UserRegistrationDto dto, PasswordEncoder passwordEncoder) {
        if (dto == null) {
            return null;
        }
        UserCredential entity = new UserCredential();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUserName());
        entity.setPhone(dto.getPhone());
        entity.setLocation(dto.getLocation());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setUserType(dto.getUserType());
        return entity;
    }


//    public static UserRegistrationDto toRegistrationDto(UserDetails entity) {
//        if (entity == null) {
//            return null;
//        }
//
//        UserRegistrationDto dto = new UserRegistrationDto();
//        dto.setId(entity.getId());
//        dto.setUserName(entity.getUsername());
//        dto.setUserType(entity.getUserType());
//        dto.setAmbulanceNumber(entity.getAmbulanceNumber());
//        dto.setDriverName(entity.getDriverName());
//        dto.setHospitalName(entity.getHospitalName());
//        dto.setPhone(entity.getPhone());
//        dto.setLocation(entity.getLocation());
//
//        return dto;
//    }

    public static UserDetailsDTO toUserDetailsDto(UserCredential entity, Hospital hospital, AmbulanceDriver ambulanceDriver) {
        if (entity == null) {
            return null;
        }
        UserDetailsDTO dto = new UserDetailsDTO();
        dto.setId(entity.getId());
        dto.setUserName(entity.getUsername());
        dto.setUserType(entity.getUserType());
        dto.setAmbulanceNumber(ambulanceDriver.getAmbulanceNumber());
        dto.setDriverName(ambulanceDriver.getDriverName());
        dto.setHospitalName(hospital.getHospitalName());
        dto.setPhone(entity.getPhone());
        dto.setLocation(entity.getLocation());
        return dto;
    }

}
