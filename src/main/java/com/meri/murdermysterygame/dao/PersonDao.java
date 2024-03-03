package com.meri.murdermysterygame.dao;

import com.meri.murdermysterygame.exception.ObjectNotFoundException;
import com.meri.murdermysterygame.repository.PersonRepository;
import com.meri.murdermysterygame.dto.PersonDto;
import com.meri.murdermysterygame.entity.Person;
import com.meri.murdermysterygame.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonDao {

    @Autowired
    PersonRepository personRepository;

    PersonDto personDto = new PersonDto();

    public List<Person> getAll() {
        return personRepository.findAllByOrderByName();
    }

    public Optional<Person> getById(Long id) {
        Optional<Person> result = personRepository.findById(id);
        return result;
    }

    public void create(Person person) {
        personRepository.save(person);
    }

    public void update(Person updatedPerson) {
        personRepository.save(updatedPerson);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
