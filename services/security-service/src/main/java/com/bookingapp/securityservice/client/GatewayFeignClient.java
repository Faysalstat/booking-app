package com.bookingapp.securityservice.client;

import com.bookingapp.securityservice.dto.UserRegistrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "client-service")
//public interface GatewayFeignClient {
//    @PostMapping("/client/create")
//    public UserRegistrationDto create(@RequestBody UserRegistrationDto userClientDTO);
//}
