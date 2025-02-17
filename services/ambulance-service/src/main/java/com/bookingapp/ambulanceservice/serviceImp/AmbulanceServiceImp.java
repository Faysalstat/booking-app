package com.bookingapp.ambulanceservice.serviceImp;

import com.bookingapp.ambulanceservice.dto.Distance;
import com.bookingapp.ambulanceservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.ambulanceservice.entity.AmbulanceDriver;
import com.bookingapp.ambulanceservice.enums.AvailabilityStatus;
import com.bookingapp.ambulanceservice.mapper.AmbulanceMapper;
import com.bookingapp.ambulanceservice.repository.AmbulanceRepository;
import com.bookingapp.ambulanceservice.service.AmbulanceService;
import com.bookingapp.ambulanceservice.service.CityService;
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
            if(!ambulanceRepository.findAllByUserLocationAndStatus(distance.getName(), AvailabilityStatus.AVAILABLE).isEmpty()){
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
