package com.bookingapp.bookingservice.serviceImp;

import com.bookingapp.bookingservice.dto.Distance;
import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.dto.client.HospitalDTO;
import com.bookingapp.bookingservice.entity.AmbulanceDriver;
import com.bookingapp.bookingservice.entity.Hospital;
import com.bookingapp.bookingservice.mapper.AmbulanceMapper;
import com.bookingapp.bookingservice.mapper.HospitalMapper;
import com.bookingapp.bookingservice.repository.HospitalRepository;
import com.bookingapp.bookingservice.service.CityService;
import com.bookingapp.bookingservice.service.HospitalService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalServiceImp implements HospitalService {

    private  final HospitalRepository hospitalRepository;

    private final CityService cityService;

    public HospitalServiceImp(HospitalRepository hospitalRepository, CityService cityService) {
        this.hospitalRepository = hospitalRepository;
        this.cityService = cityService;
    }

    @Override
    public List<HospitalDTO> getNearestHospitalList(String location) {
        List<HospitalDTO> hospitalDTOList = new ArrayList();
        List<Distance> distanceList = cityService.getCitiesOrderedByDistance(location);
        distanceList.forEach(distance -> {
            if(!hospitalRepository.findAllByUserLocation(distance.getName()).isEmpty()){
                List<Hospital> closestHospitalListOfOneLocation = hospitalRepository.findAllByUserLocation(distance.getName());
                closestHospitalListOfOneLocation.forEach(hospital->{
                    HospitalDTO hospitalDTO = HospitalMapper.toDTO(hospital);
                    hospitalDTO.setDistance(Math.round(distance.getDistance() * 100.0) / 100.0);
                    hospitalDTOList.add(hospitalDTO);
                });
            }
        });
        return hospitalDTOList;
    }
}
