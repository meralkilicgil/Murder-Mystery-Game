package com.meri.murdermysterygame.controller;


import com.meri.murdermysterygame.dto.PersonDto;
import com.meri.murdermysterygame.exception.ObjectNotFoundException;
import com.meri.murdermysterygame.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String index(){
        return "Welcome Murder Mystery Game!";
    }

    @GetMapping("/getAllPeople")
    public List<PersonDto> getAllPeople(){
        return personService.getPersonDtoList();
    }

    @GetMapping("/getPerson")
    public PersonDto getPerson(@RequestParam("id") Long id){
        PersonDto personDto = null;
        try {
            personDto = personService.getPersonById(id);
        } catch (ObjectNotFoundException e) {
            System.out.println("not found");
        }
        return personDto;
    }

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody PersonDto personDto){
        personService.createPerson(personDto);
    }

    @PutMapping("/updatePerson")
    public void updatePerson(@RequestBody PersonDto personDto, @RequestParam("id") Long id){
        personService.updatePerson(personDto, id);
    }

    @DeleteMapping("/deletePerson")
    public void deletePerson(@RequestParam("id") Long id){
        try {
            PersonDto personDto = personService.getPersonById(id);
            personService.deletePerson(personDto);
        } catch (ObjectNotFoundException e) {
            System.out.println("Person cannot be found to delete.");
        }
    }
}
