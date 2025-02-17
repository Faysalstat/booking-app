package com.bookingapp.bookingservice.serviceImp;

import com.bookingapp.bookingservice.dto.Distance;
import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.entity.AmbulanceDriver;
import com.bookingapp.bookingservice.enums.AvailabilityStatus;
import com.bookingapp.bookingservice.mapper.AmbulanceMapper;
import com.bookingapp.bookingservice.repository.AmbulanceRepository;
import com.bookingapp.bookingservice.service.AmbulanceService;
import com.bookingapp.bookingservice.service.CityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AmbulanceServiceImp implements AmbulanceService {

    private  final AmbulanceRepository ambulanceRepository;

    private final CityService cityService;

    public AmbulanceServiceImp(AmbulanceRepository ambulanceRepository, CityService cityService) {
        this.ambulanceRepository = ambulanceRepository;
        this.cityService = cityService;
    }

    @Override
    public List<AmbulanceDriverDTO> getNearestAmbulanceList(String location) {
        List<AmbulanceDriverDTO> ambulanceDriverDTOList = new ArrayList();
        List<Distance> distanceList = cityService.getCitiesOrderedByDistance(location);
        distanceList.forEach(distance -> {
            if(!ambulanceRepository.findAllByUserLocationAndStatus(distance.getName(),AvailabilityStatus.AVAILABLE).isEmpty()){
                List<AmbulanceDriver> closestDriversOfOneLocation = ambulanceRepository.findAllByUserLocationAndStatus(distance.getName(),AvailabilityStatus.AVAILABLE);
                closestDriversOfOneLocation.forEach(driver->{
                    AmbulanceDriverDTO ambulanceDriverDTO = AmbulanceMapper.toDTO(driver);
                    ambulanceDriverDTO.setDistance(Math.round(distance.getDistance() * 100.0) / 100.0);
                    ambulanceDriverDTOList.add(ambulanceDriverDTO);
                });
            }
        });
        return ambulanceDriverDTOList;
    }


}
