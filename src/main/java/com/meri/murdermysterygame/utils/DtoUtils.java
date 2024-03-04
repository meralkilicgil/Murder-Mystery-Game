package com.meri.murdermysterygame.utils;

import com.meri.murdermysterygame.dto.DriversLicenseDto;
import com.meri.murdermysterygame.dto.InterviewDto;
import com.meri.murdermysterygame.dto.PersonDto;
import com.meri.murdermysterygame.entity.DriversLicense;
import com.meri.murdermysterygame.entity.Interview;
import com.meri.murdermysterygame.entity.Person;
import org.springframework.beans.BeanUtils;

public class DtoUtils {

    public static PersonDto convertPersonEntityToPersonDto(Person entity) {
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(entity, personDto);
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
        return interviewDto;
    }

    public static Interview convertInterviewDtoToInterviewEntity(InterviewDto dto) {
        Interview interview = new Interview();
        BeanUtils.copyProperties(dto, interview);
        return interview;
    }
}
