package com.bookingapp.bookingservice.dto.client;

public class HospitalDTO {
    private Long id;
    private String hospitalName;

    private String phone;

    private UserDetailsDTO userDetailsDTO;
    private Double distance;
    private String location;


    public HospitalDTO() {
    }

    public HospitalDTO(Long id, String hospitalName, String phone, UserDetailsDTO userDetailsDTO, Double distance, String location) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.phone = phone;
        this.userDetailsDTO = userDetailsDTO;
        this.distance = distance;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }


    public UserDetailsDTO getUserDetailsDTO() {
        return userDetailsDTO;
    }

    public void setUserDetailsDTO(UserDetailsDTO userDetailsDTO) {
        this.userDetailsDTO = userDetailsDTO;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
