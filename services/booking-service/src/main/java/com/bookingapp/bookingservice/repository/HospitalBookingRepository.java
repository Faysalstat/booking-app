package com.bookingapp.bookingservice.repository;

import com.bookingapp.bookingservice.entity.HospitalBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalBookingRepository extends JpaRepository<HospitalBooking, Long> {
    List<HospitalBooking> findAllByUserId(Long id);
    List<HospitalBooking> findAllByHospitalUserId(Long id);
}
