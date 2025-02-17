package com.bookingapp.ambulanceservice.repository;

import com.bookingapp.ambulanceservice.entity.AmbulanceDriver;
import com.bookingapp.ambulanceservice.enums.AvailabilityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmbulanceRepository extends JpaRepository<AmbulanceDriver, Long> {
    List<AmbulanceDriver> findAllByUserLocationAndStatus(String location, AvailabilityStatus status);
}
