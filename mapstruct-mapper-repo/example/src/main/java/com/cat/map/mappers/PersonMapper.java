/**
 * 
 */
package com.cat.map.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cat.map.StandardMapper;
import com.cat.map.domain.Employee;
import com.cat.map.domain.Person;

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