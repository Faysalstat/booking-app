package com.bookingapp.bookingservice.serviceImp;

import com.bookingapp.bookingservice.dto.booking.BookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingRequestDTO;
import com.bookingapp.bookingservice.dto.booking.HospitalBookingDTO;
import com.bookingapp.bookingservice.entity.*;
import com.bookingapp.bookingservice.mapper.HospitalBookingMapper;
import com.bookingapp.bookingservice.repository.*;
import com.bookingapp.bookingservice.service.AmbulanceBookingService;
import com.bookingapp.bookingservice.service.AmbulanceService;
import com.bookingapp.bookingservice.service.HospitalBookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalBookingServiceImp implements HospitalBookingService {
    private  final UserDetailsRepository userDetailsRepository;
    private  final HospitalRepository hospitalRepository;
    private  final HospitalBookingRepository hospitalBookingRepository;
    private final AmbulanceBookingService ambulanceBookingService;
    public HospitalBookingServiceImp(UserDetailsRepository userDetailsRepository, HospitalRepository hospitalRepository, HospitalBookingRepository hospitalBookingRepository, AmbulanceBookingService ambulanceBookingService) {
        this.userDetailsRepository = userDetailsRepository;
        this.hospitalRepository = hospitalRepository;
        this.hospitalBookingRepository = hospitalBookingRepository;
        this.ambulanceBookingService = ambulanceBookingService;
    }

    @Override
    public BookingDTO bookHospital(BookingDTO bookingDTO) {
        BookingDTO createdBooking = ambulanceBookingService.bookAmbulance(bookingDTO);
        UserDetails userDetails = userDetailsRepository.findById(bookingDTO.getUserId()).orElseThrow();
        Hospital hospital = hospitalRepository.findById(bookingDTO.getHospitalId()).orElseThrow();
        AmbulanceBooking ambulanceBooking = new AmbulanceBooking(createdBooking.getAmbulanceBookingId());
        HospitalBooking createdHospitalBooking = hospitalBookingRepository.save(HospitalBookingMapper.toEntity(bookingDTO,userDetails,hospital,ambulanceBooking));
        return  HospitalBookingMapper.toDTO(createdHospitalBooking);
    }

    @Override
    public List<HospitalBookingDTO> getAllHospitalBookingList(BookingRequestDTO requestDTO) {
        return null;
    }
}
