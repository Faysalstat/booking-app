package com.bookingapp.securityservice.controller;

import com.bookingapp.securityservice.dto.*;
import com.bookingapp.securityservice.exception.OperationFailedException;
import com.bookingapp.securityservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO<UserDetailsDTO>> addNewUser(@RequestBody UserRegistrationDto user) {
        return ResponseEntity.ok().body(authService.saveUser(user));
    }

//    Login api
    @PostMapping("/token")
    public ResponseEntity<LoginResponse> getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return ResponseEntity.ok(authService.generateToken(authRequest.getUsername()));
        } else {
            throw new RuntimeException("invalid access");
        }
    }


//    is logged in
    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestParam("token") String token) {
        return ResponseEntity.ok(authService.validateToken(token));
    }

    @PostMapping("/change")
    public ResponseEntity<ResponseDTO<UserCredentialDto>> changePassword(@RequestBody PasswordChangeDTO passwordChangeDTO) {
        return ResponseEntity.ok().body(authService.changePassword(passwordChangeDTO));
    }
}
