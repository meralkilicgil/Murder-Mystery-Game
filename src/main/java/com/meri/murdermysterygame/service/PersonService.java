package com.meri.murdermysterygame.service;

import com.meri.murdermysterygame.dao.PersonDao;
import com.meri.murdermysterygame.dto.DriversLicenseDto;
import com.meri.murdermysterygame.dto.PersonDto;
import com.meri.murdermysterygame.entity.Person;
import com.meri.murdermysterygame.exception.ObjectNotFoundException;
import com.meri.murdermysterygame.utils.DtoUtils;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<PersonDto> getPersonDtoList(){
        List<Person> personList = personDao.getAll();
        return personList.stream().map(DtoUtils::convertPersonEntityToPersonDto).toList();
    }

    public PersonDto getPersonById(Long id) throws ObjectNotFoundException {
        Optional<Person> result = personDao.getById(id);
        if(result.isPresent()) {
            return DtoUtils.convertPersonEntityToPersonDto(result.get());
        }
        throw new ObjectNotFoundException("Person cannot be found with Id: " + id, HttpStatusCode.valueOf(404));
    }

    public PersonDto createPerson(PersonDto personDto) throws ObjectNotFoundException {
        Long licenseId = personDto.getLicenseId();
        if( licenseId != null){
            DriversLicenseDto driversLicenseDto= new DriversLicenseDto();
            driversLicenseDto.setId(personDto.getLicenseId());
            personDto.setDriversLicense(driversLicenseDto);
        }
        Person person = DtoUtils.convertPersonDtoToPersonEntity(personDto);
        person = personDao.create(person);
        return getPersonById(person.getId());
    }

    public PersonDto updatePerson(PersonDto personDto, Long id) throws ObjectNotFoundException {
        Long licenseId = personDto.getLicenseId();
        if( licenseId != null){
            DriversLicenseDto driversLicenseDto= new DriversLicenseDto();
            driversLicenseDto.setId(personDto.getLicenseId());
            personDto.setDriversLicense(driversLicenseDto);
        }
        Person person = DtoUtils.convertPersonDtoToPersonEntity(personDto);
        person.setId(id);
        personDao.update(person);
        return getPersonById(id);
    }

    public void deletePerson(PersonDto personDto){
        personDao.delete(personDto.getId());
    }

    public PersonDto getPersonByLicenseId(Long id) throws ObjectNotFoundException {
        Optional<Person> result = personDao.getByLicenseId(id);
        if(result.isPresent())
            return DtoUtils.convertPersonEntityToPersonDto(result.get());

        throw new ObjectNotFoundException("person not found with license id: " + id, HttpStatusCode.valueOf(404));
    }
}
