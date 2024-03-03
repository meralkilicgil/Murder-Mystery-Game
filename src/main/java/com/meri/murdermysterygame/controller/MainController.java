package com.meri.murdermysterygame.controller;


import com.meri.murdermysterygame.dto.MainDto;
import com.meri.murdermysterygame.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    PersonService personService;

    @GetMapping("/")
    public String index(){
        return "Welcome Murder Mystery Game!";
    }

    @GetMapping("/getAllPeople")
    public List<MainDto> getAllPeople(){
        return personService.getAll();
    }
}
