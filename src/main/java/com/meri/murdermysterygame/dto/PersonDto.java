package com.meri.murdermysterygame.dto;

import java.util.List;

public class PersonDto{
    private Long id;
    private String name;
    private Long licenseId;
    private DriversLicenseDto driversLicense;
    private int addressNumber;
    private String addressStreetName;
    private List<InterviewDto> interviewDtoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    public DriversLicenseDto getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(DriversLicenseDto driversLicenseDto) {
        this.driversLicense = driversLicenseDto;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressStreetName() {
        return addressStreetName;
    }

    public void setAddressStreetName(String addressStreetName) {
        this.addressStreetName = addressStreetName;
    }

    public List<InterviewDto> getInterviewDtoList() {
        return interviewDtoList;
    }

    public void setInterviewDtoList(List<InterviewDto> interviewDtoList) {
        this.interviewDtoList = interviewDtoList;
    }
}
