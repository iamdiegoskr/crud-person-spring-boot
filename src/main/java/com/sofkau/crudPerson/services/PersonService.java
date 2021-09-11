package com.sofkau.crudPerson.services;

import com.sofkau.crudPerson.entities.PersonEntity;
import com.sofkau.crudPerson.repositories.InterfaceRepositoryPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements InterfacePersonService {

    @Autowired
    private InterfaceRepositoryPerson repositoryPerson;

    @Override
    public List<PersonEntity> listPersons() {
        return (List<PersonEntity>) repositoryPerson.findAll();
    }

    @Override
    public Optional<PersonEntity> personById(int id) {
        return repositoryPerson.findById(id);
    }

    @Override
    public PersonEntity save(PersonEntity personEntity) {
        return repositoryPerson.save(personEntity);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public PersonEntity update(PersonEntity personEntity) {
        return null;
    }
}
