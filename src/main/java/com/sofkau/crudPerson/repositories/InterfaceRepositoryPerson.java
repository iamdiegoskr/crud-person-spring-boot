package com.sofkau.crudPerson.repositories;


import com.sofkau.crudPerson.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceRepositoryPerson extends CrudRepository<PersonEntity,Integer> {
    
}
