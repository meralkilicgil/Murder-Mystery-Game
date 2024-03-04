package com.meri.murdermysterygame.service;

import com.meri.murdermysterygame.dao.PersonDao;
import com.meri.murdermysterygame.dto.PersonDto;
import com.meri.murdermysterygame.entity.Person;
import com.meri.murdermysterygame.exception.ObjectNotFoundException;
import com.meri.murdermysterygame.utils.DtoUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
        if(result.isPresent()){
            Person person = result.get();
            return DtoUtils.convertPersonEntityToPersonDto(person);
        }
        throw new ObjectNotFoundException("Person cannot be found with Id: " + id, HttpStatusCode.valueOf(404));
    }

    public void createPerson(PersonDto personDto) {
        Person person = DtoUtils.convertPersonDtoToPersonEntity(personDto);
        personDao.create(person);
    }

    public void updatePerson(PersonDto personDto, Long id){
        Person person = DtoUtils.convertPersonDtoToPersonEntity(personDto);
        person.setId(id);
        personDao.update(person);
    }

    public void deletePerson(PersonDto personDto){
        personDao.delete(personDto.getId());
    }
}
