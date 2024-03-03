package com.meri.murdermysterygame.service;

import com.meri.murdermysterygame.ObjectNotFoundException;
import com.meri.murdermysterygame.dao.PersonDao;
import com.meri.murdermysterygame.dto.MainDto;
import com.meri.murdermysterygame.dto.PersonDto;
import com.meri.murdermysterygame.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements RepositoryService{

    @Autowired
    PersonDao personDao;

    @Override
    public List<MainDto> getAll() {
        List<Person> personList = personDao.findAllByOrderByName();
        List<MainDto> personDtoList = new ArrayList<>();
        for(Person person: personList){
            personDtoList.add(convertToDto(person));
        }
        return personDtoList;
    }

    @Override
    public MainDto getById(Long id) throws ObjectNotFoundException {
        Optional<Person> result = personDao.findById(id);
        MainDto personDto;
        if(result.isPresent()){
            Person person = result.get();
            personDto = convertToDto(person);
            return personDto;
        }
        else {
            throw new ObjectNotFoundException("Person cannot be found with Id: " + id, HttpStatusCode.valueOf(404));
        }
    }

    @Override
    public void create(MainDto object) {
        Person person = convertToDao((PersonDto) object);
        personDao.save(person);
    }

    @Override
    public void update(MainDto updatedPerson, Long id) throws ObjectNotFoundException {
        PersonDto personDto = (PersonDto) updatedPerson;
        personDto.setId(id);
        Person person = convertToDao(personDto);
        personDao.save(person);
    }

    @Override
    public void delete(Long id) throws ObjectNotFoundException {
        MainDto personDto = getById(id);
        Person person = convertToDao((PersonDto) personDto);
        personDao.delete(person);
    }

    private PersonDto convertToDto(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setLicenseId(person.getLicense_id());
        personDto.setAddressNumber(person.getAddress_number());
        personDto.setAddressStreetName(person.getAddress_street_name());

        return personDto;
    }

    private Person convertToDao(PersonDto personDto){
        Person person = new Person();
        person.setId(personDto.getId());
        person.setName(personDto.getName());
        person.setLicense_id(personDto.getLicenseId());
        person.setAddress_number(personDto.getAddressNumber());
        person.setAddress_street_name(personDto.getAddressStreetName());

        return person;
    }
}
