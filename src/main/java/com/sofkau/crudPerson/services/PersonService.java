package com.sofkau.crudPerson.services;

import com.sofkau.crudPerson.dtos.PersonDto;
import com.sofkau.crudPerson.entities.PersonEntity;
import com.sofkau.crudPerson.mappers.PersonMapper;
import com.sofkau.crudPerson.repositories.InterfaceRepositoryPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements InterfacePersonService {

    @Autowired
    private InterfaceRepositoryPerson repositoryPerson;

    @Autowired
    private PersonMapper mapper;

    @Override
    public List<PersonDto> listPersons() {
        List<PersonEntity> allPersons = (List<PersonEntity>) repositoryPerson.findAll();
        return mapper.toPersonsDto(allPersons);
    }

    @Override
    public Optional<PersonDto> personById(int id) {
        return repositoryPerson.findById(id).map(personEntity -> mapper.toPersonDto(personEntity));
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        PersonEntity personEntity = mapper.toPersonEntity(personDto);
        return mapper.toPersonDto(repositoryPerson.save(personEntity));
    }

    @Override
    public boolean delete(int id) {
        return personById(id).map(personDto -> {
            repositoryPerson.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<PersonDto> update(PersonDto personDto) {

        Optional<PersonDto> personDtoUpdate = personById(personDto.getId());

        return personDtoUpdate.map(personDtoToUpdate -> {
            personDtoToUpdate.setName(personDto.getName());
            personDtoToUpdate.setAge(personDto.getAge());

            PersonEntity personEntityToUpdate = mapper.toPersonEntity(personDtoToUpdate);

            return mapper.toPersonDto(repositoryPerson.save(personEntityToUpdate));
        });
    }
}
