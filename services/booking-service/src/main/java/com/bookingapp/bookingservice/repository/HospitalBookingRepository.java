package com.bookingapp.bookingservice.repository;

import com.bookingapp.bookingservice.entity.HospitalBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalBookingRepository extends JpaRepository<HospitalBooking, Long> {
}
