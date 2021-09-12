package com.sofkau.crudPerson.mappers;

import com.sofkau.crudPerson.dtos.PersonDto;
import com.sofkau.crudPerson.entities.PersonEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {


    PersonDto toPersonDto(PersonEntity personEntity);
    List<PersonDto> toPersonsDto(List<PersonEntity> personEntities);

    @InheritInverseConfiguration
    PersonEntity toPersonEntity(PersonDto personDto);

}
