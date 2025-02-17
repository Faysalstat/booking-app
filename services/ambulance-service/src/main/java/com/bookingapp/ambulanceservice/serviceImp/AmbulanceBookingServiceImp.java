package com.bookingapp.ambulanceservice.serviceImp;

import com.bookingapp.ambulanceservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.ambulanceservice.dto.booking.BookingDTO;
import com.bookingapp.ambulanceservice.dto.booking.BookingRequestDTO;
import com.bookingapp.ambulanceservice.entity.AmbulanceBooking;
import com.bookingapp.ambulanceservice.entity.AmbulanceDriver;
import com.bookingapp.ambulanceservice.entity.UserDetails;
import com.bookingapp.ambulanceservice.enums.AvailabilityStatus;
import com.bookingapp.ambulanceservice.enums.BookingStatus;
import com.bookingapp.ambulanceservice.mapper.AmbulanceBookingMapper;
import com.bookingapp.ambulanceservice.repository.AmbulanceBookingRepository;
import com.bookingapp.ambulanceservice.repository.AmbulanceRepository;
import com.bookingapp.ambulanceservice.repository.UserDetailsRepository;
import com.bookingapp.ambulanceservice.service.AmbulanceBookingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class AmbulanceBookingServiceImp implements AmbulanceBookingService {
    private  final UserDetailsRepository userDetailsRepository;
    private  final AmbulanceRepository ambulanceRepository;
    private  final AmbulanceBookingRepository ambulanceBookingRepository;

    public AmbulanceBookingServiceImp(UserDetailsRepository userDetailsRepository, AmbulanceRepository ambulanceRepository, AmbulanceBookingRepository ambulanceBookingRepository) {
        this.userDetailsRepository = userDetailsRepository;
        this.ambulanceRepository = ambulanceRepository;
        this.ambulanceBookingRepository = ambulanceBookingRepository;
    }


    @Override
    @Transactional
    public BookingDTO bookAmbulance(BookingDTO bookingDTO) {
        UserDetails userDetails = userDetailsRepository.findById(bookingDTO.getUserId()).orElseThrow();
        AmbulanceDriver ambulanceDriver = ambulanceRepository.findById(bookingDTO.getAmbulanceDriverId()).orElseThrow();
        AmbulanceBooking ambulanceBooking = AmbulanceBookingMapper.toEntity(bookingDTO,userDetails,ambulanceDriver);
        ambulanceDriver.setStatus(AvailabilityStatus.BOOKED);
        ambulanceBooking.setStatus(BookingStatus.PENDING);
        AmbulanceBooking createdBooking = ambulanceBookingRepository.saveAndFlush(ambulanceBooking);
        return  AmbulanceBookingMapper.toDTO(createdBooking);

    }

    @Override
    public List<AmbulanceBookingDTO> getAllAmbulanceBookingListByDriver(BookingRequestDTO bookingRequestDTO) {
        List<AmbulanceBookingDTO> ambulanceBookingDTOS = new ArrayList();
        List<AmbulanceBooking> ambulanceBookingList = ambulanceBookingRepository.findAllByAmbulanceDriverUserId(bookingRequestDTO.getUserId());
        if(!ambulanceBookingList.isEmpty()){
            for (AmbulanceBooking ambulanceBooking:ambulanceBookingList) {
                ambulanceBookingDTOS.add(AmbulanceBookingMapper.toAmbulanceBookingDTO(ambulanceBooking));
            }
        }
        return  ambulanceBookingDTOS;
    }

    @Override
    public AmbulanceBookingDTO updateStatus(AmbulanceBookingDTO ambulanceBookingDTO) {
        AmbulanceBooking ambulanceBooking = ambulanceBookingRepository.findById(ambulanceBookingDTO.getId()).orElseThrow();
        ambulanceBooking.setStatus(ambulanceBookingDTO.getStatus());
        if(ambulanceBookingDTO.getStatus().equals(BookingStatus.COMPLETED)){
            AmbulanceDriver ambulanceDriver = ambulanceRepository.findById(ambulanceBooking.getAmbulanceDriver().getId()).orElseThrow();
            ambulanceDriver.setStatus(AvailabilityStatus.AVAILABLE);
            ambulanceRepository.save(ambulanceDriver);
        }
        return  AmbulanceBookingMapper.toAmbulanceBookingDTO(ambulanceBookingRepository.save(ambulanceBooking));
    }

}
