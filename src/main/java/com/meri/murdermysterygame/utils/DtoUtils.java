package com.meri.murdermysterygame.utils;

import com.meri.murdermysterygame.dto.PersonDto;
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
}
