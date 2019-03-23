/**
 * 
 */
package org.mapstruct.example.repo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.example.repo.StandardMapper;
import org.mapstruct.factory.Mappers;

import org.mapstruct.example.repo.domain.Boss;
import org.mapstruct.example.repo.domain.Person;

/**
 * @author jucheme
 *
 */
@Mapper
public interface PersonToBossMapper extends StandardMapper<Person, Boss> {

	PersonToBossMapper INSTANCE = Mappers.getMapper(PersonToBossMapper.class);

	@Mapping(source = "firstName", target = "name")
	@Mapping(target = "title", constant = "Boss")
	Boss map(Person p);
}