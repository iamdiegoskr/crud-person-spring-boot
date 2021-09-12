package com.sofkau.crudPerson.controllers;

import com.sofkau.crudPerson.dtos.PersonDto;
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
    public ResponseEntity<Iterable<PersonDto>> listPersons(){
        return new ResponseEntity<>(servicePerson.listPersons(),HttpStatus.OK);
    }

    @GetMapping(value = "listPersons/{id}")
    public ResponseEntity<PersonDto> litPersonById(@PathVariable() int id){
        return servicePerson.personById(id)
                .map(personDto -> new ResponseEntity<>(personDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "createPerson")
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto){
        return new ResponseEntity<>(servicePerson.save(personDto),HttpStatus.CREATED);
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
    public ResponseEntity<PersonDto> updatePerson(@RequestBody PersonDto personDto){

        return servicePerson.update(personDto)
                .map(personDtoUpdate -> new ResponseEntity<>(personDtoUpdate,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
