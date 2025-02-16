package com.bookingapp.securityservice.repository;

import com.bookingapp.securityservice.entity.AmbulanceDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbulanceRepository extends JpaRepository<AmbulanceDriver, Long> {
}
