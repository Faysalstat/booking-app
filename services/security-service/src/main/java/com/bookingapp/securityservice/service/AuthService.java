package com.bookingapp.securityservice.service;

import com.bookingapp.securityservice.dto.*;
import com.bookingapp.securityservice.exception.OperationFailedException;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    ResponseDTO<UserDetailsDTO> saveUser(UserRegistrationDto credential);
    LoginResponse generateToken(String username);
    Boolean validateToken(String token);
    UserCredentialDto getUserByUserName(String username);
}
