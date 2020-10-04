/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.quarkus.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.example.quarkus.dto.PersonDto;
import org.mapstruct.example.quarkus.service.Person;

@Mapper(config = QuarkusMappingConfig.class)
public interface PersonMapper {
    @Mapping(target = "surname", source = "lastname")
    PersonDto toResource(Person person);
}
