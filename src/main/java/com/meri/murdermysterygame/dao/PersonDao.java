package com.meri.murdermysterygame.dao;

import com.meri.murdermysterygame.entity.Person;
import com.meri.murdermysterygame.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonDao {

    private final PersonRepository personRepository;

    public PersonDao(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.findAllByOrderByName();
    }

    public Optional<Person> getById(Long id) {
        return personRepository.findById(id);
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
