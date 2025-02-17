package com.assesment.ambulanceservice.repository;

import com.bookingapp.bookingservice.entity.AmbulanceBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmbulanceBookingRepository extends JpaRepository<AmbulanceBooking, Long> {
    List<AmbulanceBooking> findAllByAmbulanceDriverUserId(Long Id);
}
