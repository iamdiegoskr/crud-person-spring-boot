package com.sofkau.crudPerson.services;

import com.sofkau.crudPerson.dtos.PersonDto;

import java.util.List;
import java.util.Optional;

public interface InterfacePersonService {

    public List<PersonDto> listPersons();
    public Optional<PersonDto> personById(int id);
    public PersonDto save(PersonDto personDto);
    public boolean delete(int id);
    public Optional<PersonDto> update(PersonDto personDto);
}
