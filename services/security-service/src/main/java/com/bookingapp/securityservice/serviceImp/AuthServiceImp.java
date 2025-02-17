package com.bookingapp.securityservice.serviceImp;

import com.bookingapp.securityservice.dto.*;
import com.bookingapp.securityservice.entity.AmbulanceDriver;
import com.bookingapp.securityservice.entity.Hospital;
import com.bookingapp.securityservice.entity.UserCredential;
import com.bookingapp.securityservice.enums.UserType;
import com.bookingapp.securityservice.exception.OperationFailedException;
import com.bookingapp.securityservice.mapper.UserCredentialMapper;
import com.bookingapp.securityservice.repository.AmbulanceRepository;
import com.bookingapp.securityservice.repository.HospitalRepository;
import com.bookingapp.securityservice.repository.UserCredentialRepository;
import com.bookingapp.securityservice.service.AuthService;
import com.bookingapp.securityservice.service.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserCredentialMapper userCredentialMapper;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AmbulanceRepository ambulanceRepository;

    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    @Transactional
    public ResponseDTO<UserDetailsDTO> saveUser(UserRegistrationDto userRegistrationDto){
        if(userCredentialRepository.findByUsername(userRegistrationDto.getUserName()).isPresent()){
            return new ResponseDTO(false,"User Already Exits",null);
        }
        Hospital hospital = new Hospital();
        AmbulanceDriver ambulanceDriver = new AmbulanceDriver();
//        ResponseDTO<UserRegistrationDto>
        UserCredential userCredential = UserCredentialMapper.toEntity(userRegistrationDto,passwordEncoder);
        UserCredential createdUser = userCredentialRepository.saveAndFlush(userCredential);
        if(createdUser.getUserType().equals(UserType.HOSPITAL)){
            hospital.setHospitalName(userRegistrationDto.getHospitalName());
            hospital.setUser(createdUser);
            hospitalRepository.save(hospital);
        }else if(createdUser.getUserType().equals(UserType.AMBULANCE)){
            ambulanceDriver.setAmbulanceNumber(userRegistrationDto.getAmbulanceNumber());
            ambulanceDriver.setDriverName(userRegistrationDto.getDriverName());
            ambulanceDriver.setUser(createdUser);
            ambulanceRepository.save(ambulanceDriver);
        }
        return new ResponseDTO(true,"User Created",UserCredentialMapper.toUserDetailsDto(createdUser,hospital,ambulanceDriver));
    }

    @Override
    public LoginResponse generateToken(String username) {
        UserCredential userCredential = userCredentialRepository.findByUsername(username).orElseThrow();
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtService.generateToken(userCredential));
        loginResponse.setUserName(userCredential.getUsername());
        loginResponse.setUserType(userCredential.getUserType());
        loginResponse.setUserId(userCredential.getId());
        return loginResponse;
    }

    @Override
    public Boolean validateToken(String token) {
        try{
            jwtService.validateToken(token);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public UserCredentialDto getUserByUserName(String username) {
        return userCredentialMapper.toDto(userCredentialRepository.findByUsername(username).orElseThrow());
    }

    @Override
    public ResponseDTO<UserCredentialDto> changePassword(PasswordChangeDTO passwordChangeDTO) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(passwordChangeDTO.getUserName(), passwordChangeDTO.getPreviousPassword()));
        if (authenticate.isAuthenticated()) {
            UserCredential userCredential = userCredentialRepository.findByUsername(passwordChangeDTO.getUserName()).orElseThrow();
            userCredential.setPassword(passwordEncoder.encode(passwordChangeDTO.getNewPassword()));
            return new ResponseDTO<UserCredentialDto>(true,"Password Changed",UserCredentialMapper.toDto(userCredentialRepository.saveAndFlush(userCredential))) ;
        }
        return new ResponseDTO<UserCredentialDto>(true,"Wrong Credential",null) ;
    }

    private UserRegistrationDto toClientDto(UserRegistrationDto userRegistrationDto){
            if (userRegistrationDto == null) {
                return null;
            }

        UserRegistrationDto userClientDto = new UserRegistrationDto();
            userClientDto.setId(userRegistrationDto.getId());

            // Assuming other fields are not applicable or omitted for CustomerDTO

            return userClientDto;
        }

}
