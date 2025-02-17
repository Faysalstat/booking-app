package com.bookingapp.bookingservice.serviceImp;

import com.bookingapp.bookingservice.dto.booking.AmbulanceBookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingDTO;
import com.bookingapp.bookingservice.dto.booking.BookingRequestDTO;
import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.entity.AmbulanceBooking;
import com.bookingapp.bookingservice.entity.AmbulanceDriver;
import com.bookingapp.bookingservice.entity.UserDetails;
import com.bookingapp.bookingservice.enums.AvailabilityStatus;
import com.bookingapp.bookingservice.enums.BookingStatus;
import com.bookingapp.bookingservice.mapper.AmbulanceBookingMapper;
import com.bookingapp.bookingservice.mapper.AmbulanceMapper;
import com.bookingapp.bookingservice.repository.AmbulanceBookingRepository;
import com.bookingapp.bookingservice.repository.AmbulanceRepository;
import com.bookingapp.bookingservice.repository.UserDetailsRepository;
import com.bookingapp.bookingservice.service.AmbulanceBookingService;
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
        List<AmbulanceBooking> ambulanceBookingList = ambulanceBookingRepository.findAllByAmbulanceDriverId(bookingRequestDTO.getUserId());
        if(!ambulanceBookingList.isEmpty()){
            for (AmbulanceBooking ambulanceBooking:ambulanceBookingList) {
                ambulanceBookingDTOS.add(AmbulanceBookingMapper.toAmbulanceBookingDTO(ambulanceBooking));
            }
        }
        return  ambulanceBookingDTOS;
    }
    @Override
    public AmbulanceBookingDTO updateStatus(Long bookingId, BookingStatus status) {
        AmbulanceBooking ambulanceBooking = ambulanceBookingRepository.findById(bookingId).orElseThrow();
        ambulanceBooking.setStatus(status);
        if(status.equals(BookingStatus.COMPLETED)){
            AmbulanceDriver ambulanceDriver = ambulanceRepository.findById(ambulanceBooking.getAmbulanceDriver().getId()).orElseThrow();
            ambulanceDriver.setStatus(AvailabilityStatus.AVAILABLE);
            ambulanceRepository.save(ambulanceDriver);
        }
        return  AmbulanceBookingMapper.toAmbulanceBookingDTO(ambulanceBookingRepository.save(ambulanceBooking));
    }

}
