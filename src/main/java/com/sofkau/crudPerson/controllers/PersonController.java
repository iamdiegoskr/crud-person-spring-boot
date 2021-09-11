package com.sofkau.crudPerson.controllers;

import com.sofkau.crudPerson.entities.PersonEntity;
import com.sofkau.crudPerson.services.InterfacePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PersonController {

    @Autowired
    private InterfacePersonService servicePerson;

    @GetMapping(value = "listPersons")
    public Iterable<PersonEntity> listPersons(){
        return servicePerson.listPersons();
    }

}
