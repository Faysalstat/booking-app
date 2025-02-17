package com.bookingapp.bookingservice.serviceImp;

import com.bookingapp.bookingservice.client.AmbulanceFeignClient;
import com.bookingapp.bookingservice.dto.booking.BookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingRequestDTO;
import com.bookingapp.bookingservice.dto.booking.HospitalBookingResponseDTO;
import com.bookingapp.bookingservice.entity.*;
import com.bookingapp.bookingservice.enums.UserType;
import com.bookingapp.bookingservice.mapper.HospitalBookingMapper;
import com.bookingapp.bookingservice.repository.*;
import com.bookingapp.bookingservice.service.HospitalBookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalBookingServiceImp implements HospitalBookingService {
    private final UserDetailsRepository userDetailsRepository;
    private final HospitalRepository hospitalRepository;
    private final HospitalBookingRepository hospitalBookingRepository;
    private final AmbulanceFeignClient ambulanceFeignClient;

    public HospitalBookingServiceImp(UserDetailsRepository userDetailsRepository, HospitalRepository hospitalRepository, HospitalBookingRepository hospitalBookingRepository, AmbulanceFeignClient ambulanceFeignClient) {
        this.userDetailsRepository = userDetailsRepository;
        this.hospitalRepository = hospitalRepository;
        this.hospitalBookingRepository = hospitalBookingRepository;
        this.ambulanceFeignClient = ambulanceFeignClient;
    }

    @Override
    public BookingDTO bookHospital(BookingDTO bookingDTO) {
        BookingDTO createdBooking = ambulanceFeignClient.bookAmbulance(bookingDTO).getBody();
        UserDetails userDetails = userDetailsRepository.findById(bookingDTO.getUserId()).orElseThrow();
        Hospital hospital = hospitalRepository.findById(bookingDTO.getHospitalId()).orElseThrow();
        AmbulanceBooking ambulanceBooking = new AmbulanceBooking(createdBooking.getAmbulanceBookingId());
        HospitalBooking createdHospitalBooking = hospitalBookingRepository.save(HospitalBookingMapper.toEntity(bookingDTO, userDetails, hospital, ambulanceBooking));
        return HospitalBookingMapper.toDTO(createdHospitalBooking);
    }

    @Override
    public List<HospitalBookingResponseDTO> getAllHospitalBookingList(BookingRequestDTO requestDTO) {
        List<HospitalBookingResponseDTO> bookingDTOS = new ArrayList<>();
        List<HospitalBooking> hospitalBookings = new ArrayList();
        if (requestDTO.getUserType().equals(UserType.USER)) {
            hospitalBookings = hospitalBookingRepository.findAllByUserId(requestDTO.getUserId());
        } else if (requestDTO.getUserType().equals(UserType.HOSPITAL)) {
            hospitalBookings = hospitalBookingRepository.findAllByHospitalUserId(requestDTO.getUserId());
        }

        if (!hospitalBookings.isEmpty()) {
            for (HospitalBooking booking : hospitalBookings) {
                bookingDTOS.add(HospitalBookingMapper.toBookingDTO(booking, requestDTO.getUserType()));
            }
        }
        return bookingDTOS;
    }
}
