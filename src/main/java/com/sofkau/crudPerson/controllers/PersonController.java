package com.sofkau.crudPerson.controllers;

import com.sofkau.crudPerson.entities.PersonEntity;
import com.sofkau.crudPerson.services.InterfacePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class PersonController {

    @Autowired
    private InterfacePersonService servicePerson;

    @GetMapping(value = "listPersons")
    public Iterable<PersonEntity> listPersons(){
        return servicePerson.listPersons();
    }

    @PostMapping(value = "createPerson")
    public PersonEntity createPerson(@RequestBody PersonEntity personEntity){
        return servicePerson.save(personEntity);
    }

}
