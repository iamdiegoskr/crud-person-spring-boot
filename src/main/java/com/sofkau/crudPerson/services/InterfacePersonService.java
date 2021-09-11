package com.sofkau.crudPerson.services;

import com.sofkau.crudPerson.entities.PersonEntity;

import java.util.List;

public interface InterfacePersonService {

    public List<PersonEntity> listPersons();
    public PersonEntity personById(int id);
    public PersonEntity save(PersonEntity personEntity);
    public void delete(int id);
    public PersonEntity update(PersonEntity personEntity);
}
