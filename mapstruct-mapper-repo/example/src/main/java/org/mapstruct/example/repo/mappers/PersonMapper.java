/**
 * 
 */
package org.mapstruct.example.repo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.example.repo.StandardMapper;
import org.mapstruct.factory.Mappers;

import org.mapstruct.example.repo.domain.Employee;
import org.mapstruct.example.repo.domain.Person;

/**
 * @author jucheme
 *
 */
@Mapper
public interface PersonMapper extends StandardMapper<Person, Employee> {

	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

	@Mapping(source = "firstName", target = "name")
	Employee map(Person p);
}