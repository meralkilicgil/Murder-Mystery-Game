package com.meri.murdermysterygame.utils;

import com.meri.murdermysterygame.dto.DriversLicenseDto;
import com.meri.murdermysterygame.dto.InterviewDto;
import com.meri.murdermysterygame.dto.PersonDto;
import com.meri.murdermysterygame.entity.DriversLicense;
import com.meri.murdermysterygame.entity.Interview;
import com.meri.murdermysterygame.entity.Person;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class DtoUtils {

    public static PersonDto convertPersonEntityToPersonDto(Person entity) {
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(entity, personDto);
        DriversLicenseDto driversLicenseDto = new DriversLicenseDto();
        BeanUtils.copyProperties(entity.getDriversLicense(), driversLicenseDto);
        personDto.setDriversLicense(driversLicenseDto);
        List<Interview> interviewList = entity.getInterviews();
        List<InterviewDto> interviewDtoList = interviewList.stream().map(DtoUtils::convertInterviewEntityToInterviewDto).toList();
        personDto.setInterviewDtoList(interviewDtoList);
        return personDto;
    }

    public static Person convertPersonDtoToPersonEntity(PersonDto dto) {
        Person personEntity = new Person();
        BeanUtils.copyProperties(dto, personEntity);
        return personEntity;
    }

    public static DriversLicenseDto convertDriverLicenseEntityToDriversLicenseDto(DriversLicense entity) {
        DriversLicenseDto driversLicenseDto = new DriversLicenseDto();
        BeanUtils.copyProperties(entity, driversLicenseDto);
        return driversLicenseDto;
    }

    public static DriversLicense convertDriversLicenseDtoToDriversLicenseEntity(DriversLicenseDto dto) {
        DriversLicense driversLicense = new DriversLicense();
        BeanUtils.copyProperties(dto, driversLicense);
        return driversLicense;
    }

    public static InterviewDto convertInterviewEntityToInterviewDto(Interview entity) {
        InterviewDto interviewDto = new InterviewDto();
        BeanUtils.copyProperties(entity, interviewDto);
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(entity.getPerson(), personDto);
        interviewDto.setPerson(personDto);
        return interviewDto;
    }

    public static Interview convertInterviewDtoToInterviewEntity(InterviewDto dto) {
        Interview interview = new Interview();
        BeanUtils.copyProperties(dto, interview);
        return interview;
    }
}