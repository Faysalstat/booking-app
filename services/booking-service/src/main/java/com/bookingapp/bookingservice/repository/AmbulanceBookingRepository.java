package com.bookingapp.bookingservice.repository;

import com.bookingapp.bookingservice.entity.AmbulanceBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbulanceBookingRepository extends JpaRepository<AmbulanceBooking, Long> {
}
