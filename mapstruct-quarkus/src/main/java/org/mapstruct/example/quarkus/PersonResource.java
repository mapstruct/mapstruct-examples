/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.quarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mapstruct.example.quarkus.mapper.PersonMapper;
import org.mapstruct.example.quarkus.dto.PersonDto;
import org.mapstruct.example.quarkus.service.PersonService;

@Path("/person")
public class PersonResource {

    @Inject
    PersonService personService;

    @Inject
    PersonMapper personMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PersonDto loadPerson() {
        return personMapper.toResource( personService.loadPerson() );
    }
}