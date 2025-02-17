package com.bookingapp.bookingservice.repository;

import com.bookingapp.bookingservice.entity.AmbulanceDriver;
import com.bookingapp.bookingservice.enums.AvailabilityStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AmbulanceRepository extends JpaRepository<AmbulanceDriver, Long> {
    List<AmbulanceDriver> findAllByUserLocationAndStatus(String location, AvailabilityStatus status);
}
