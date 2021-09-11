package com.sofkau.crudPerson.services;

import com.sofkau.crudPerson.entities.PersonEntity;

import java.util.List;
import java.util.Optional;

public interface InterfacePersonService {

    public List<PersonEntity> listPersons();
    public Optional<PersonEntity> personById(int id);
    public PersonEntity save(PersonEntity personEntity);
    public void delete(int id);
    public PersonEntity update(PersonEntity personEntity);
}
