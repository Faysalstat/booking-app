package com.bookingapp.bookingservice.controller;

import com.bookingapp.bookingservice.dto.ResponseDTO;
import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.dto.client.HospitalDTO;
import com.bookingapp.bookingservice.entity.Hospital;
import com.bookingapp.bookingservice.service.ClientService;
import jakarta.ws.rs.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking-service/client")
public class ClientController {
    private  final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("hospital")
    public ResponseEntity<HospitalDTO > saveHospital(@RequestBody HospitalDTO hospitalDTO){
        try {
            return ResponseEntity.ok().body(clientService.saveHospital(hospitalDTO));
        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }
    }

    @PostMapping("ambulance")
    public ResponseEntity<AmbulanceDriverDTO> saveAmbulance(@RequestBody AmbulanceDriverDTO ambulanceDriverDTO){
        try {
            return ResponseEntity.ok().body(clientService.saveAmbulance(ambulanceDriverDTO));
        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }
    }



}
