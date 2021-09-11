package com.sofkau.crudPerson.controllers;

import com.sofkau.crudPerson.entities.PersonEntity;
import com.sofkau.crudPerson.services.InterfacePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "listPersons/{id}")
    public ResponseEntity<PersonEntity> litPersonById(@PathVariable() int id){
        return servicePerson.personById(id)
                .map(personEntity -> new ResponseEntity<>(personEntity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "createPerson")
    public PersonEntity createPerson(@RequestBody PersonEntity personEntity){
        return servicePerson.save(personEntity);
    }


    @DeleteMapping(value = "removePerson/{id}")
    public ResponseEntity<HttpStatus> removePerson(@PathVariable() int id){
        if (servicePerson.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "updatePerson")
    public ResponseEntity<PersonEntity> updatePerson(@RequestBody PersonEntity personEntity){

        return servicePerson.update(personEntity)
                .map(personUpdate -> new ResponseEntity<>(personUpdate,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
