package com.meri.murdermysterygame.service;

import com.meri.murdermysterygame.exception.ObjectNotFoundException;
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

    PersonDto personDto = new PersonDto();

    @Override
    public List<MainDto> getAll() {
        List<Person> personList = personDao.findAllByOrderByName();
        List<MainDto> personDtoList = new ArrayList<>();
        for(Person person: personList){
            personDtoList.add(personDto.convertToDto(person));
        }
        return personDtoList;
    }

    @Override
    public MainDto getById(Long id) throws ObjectNotFoundException {
        Optional<Person> result = personDao.findById(id);
        if(result.isPresent()){
            Person person = result.get();
            return personDto.convertToDto(person);
        }
        else {
            throw new ObjectNotFoundException("Person cannot be found with Id: " + id, HttpStatusCode.valueOf(404));
        }
    }

    @Override
    public void create(MainDto object) {
        Person person = (Person) personDto.convertToEntity(object);
        personDao.save(person);
    }

    @Override
    public void update(MainDto updatedPerson, Long id) {
        PersonDto personDto = (PersonDto) updatedPerson;
        personDto.setId(id);
        Person person = (Person) personDto.convertToEntity(personDto);
        personDao.save(person);
    }

    @Override
    public void delete(Long id) throws ObjectNotFoundException {
        MainDto personDto = getById(id);
        Person person = (Person) personDto.convertToEntity(personDto);
        personDao.delete(person);
    }
}
