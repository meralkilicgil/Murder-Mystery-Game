package com.meri.murdermysterygame.controller;


import com.meri.murdermysterygame.dto.PersonDto;
import com.meri.murdermysterygame.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
