package com.bookingapp.bookingservice.repository;

import com.bookingapp.bookingservice.dto.client.HospitalDTO;
import com.bookingapp.bookingservice.entity.AmbulanceDriver;
import com.bookingapp.bookingservice.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    List<Hospital> findAllByUserLocation(String location);
}
