package com.meri.murdermysterygame.dto;

import com.meri.murdermysterygame.entity.MainEntity;
import com.meri.murdermysterygame.entity.Person;

public class PersonDto implements MainDto{
    private Long id;
    private String name;
    private Long licenseId;
    private int addressNumber;
    private String addressStreetName;

    @Override
    public MainDto convertToDto(MainEntity entity) {
        PersonDto personDto = new PersonDto();
        Person person = (Person) entity;
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setLicenseId(person.getLicense_id());
        personDto.setAddressNumber(person.getAddress_number());
        personDto.setAddressStreetName(person.getAddress_street_name());

        return personDto;
    }

    @Override
    public MainEntity convertToEntity(MainDto dto) {
        PersonDto personDto = (PersonDto) dto;
        Person personEntity = new Person();
        personEntity.setId(personDto.getId());
        personEntity.setName(personDto.getName());
        personEntity.setLicense_id(personDto.getLicenseId());
        personEntity.setAddress_number(personDto.getAddressNumber());
        personEntity.setAddress_street_name(personDto.getAddressStreetName());

        return personEntity;
    }

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

}
