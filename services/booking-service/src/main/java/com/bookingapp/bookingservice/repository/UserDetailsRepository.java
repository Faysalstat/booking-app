package com.bookingapp.bookingservice.repository;

import com.bookingapp.bookingservice.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
