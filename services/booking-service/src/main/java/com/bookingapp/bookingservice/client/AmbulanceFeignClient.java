package com.bookingapp.bookingservice.client;

import com.bookingapp.bookingservice.dto.booking.BookingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "api-gateway")
public interface AmbulanceFeignClient {
    @PostMapping("/api/ambulance/booking")
    ResponseEntity<BookingDTO> bookAmbulance(@RequestBody BookingDTO bookingDTO);
}
