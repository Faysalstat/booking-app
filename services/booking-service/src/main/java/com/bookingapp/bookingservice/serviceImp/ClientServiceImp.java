package com.bookingapp.bookingservice.serviceImp;

import com.bookingapp.bookingservice.dto.client.AmbulanceDriverDTO;
import com.bookingapp.bookingservice.dto.client.HospitalDTO;
import com.bookingapp.bookingservice.entity.Hospital;
import com.bookingapp.bookingservice.entity.UserDetails;
import com.bookingapp.bookingservice.mapper.HospitalMapper;
import com.bookingapp.bookingservice.repository.AmbulanceRepository;
import com.bookingapp.bookingservice.repository.HospitalRepository;
import com.bookingapp.bookingservice.repository.UserDetailsRepository;
import com.bookingapp.bookingservice.service.ClientService;
import org.springframework.stereotype.Service;


@Service
public class ClientServiceImp implements ClientService {

    private final AmbulanceRepository ambulanceRepository;
    private final HospitalRepository hospitalRepository;

    private final UserDetailsRepository userDetailsRepository;

    public ClientServiceImp(AmbulanceRepository ambulanceRepository, HospitalRepository hospitalRepository, UserDetailsRepository userDetailsRepository) {
        this.ambulanceRepository = ambulanceRepository;
        this.hospitalRepository = hospitalRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public HospitalDTO saveHospital(HospitalDTO hospitalDTO) {
//        UserDetails user = userDetailsRepository.findById(hospitalDTO.getUser().getId()).orElseThrow();
//        Hospital hospital = HospitalMapper.t(hospitalDTO,user);
//        hospital.setUser(user);
//        Hospital createdHospital  = hospitalRepository.save(hospital);
//        user.setProfileReady(true);
//        userDetailsRepository.save(user);
//        return HospitalMapper.toDTO(createdHospital);
        return null;
    }
    @Override
    public AmbulanceDriverDTO saveAmbulance(AmbulanceDriverDTO ambulanceDriverDTO) {
//        UserDetails user = userDetailsRepository.findById(ambulanceDriverDTO.getUserId()).orElseThrow();
//        AmbulanceDriver ambulanceDriver = AmbulanceDriverMapper.toEntity(ambulanceDriverDTO,user);
//        ambulanceDriver.setUser(user);
//        AmbulanceDriver createdDriver  = ambulanceRepository.save(ambulanceDriver);
//        user.setProfileReady(true);
//        userDetailsRepository.save(user);
//        return AmbulanceDriverMapper.toDTO(createdDriver);
        return null;
    }
}
