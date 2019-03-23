/**
 * 
 */
package com.cat.map.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cat.map.StandardMapper;
import com.cat.map.domain.Boss;
import com.cat.map.domain.Person;

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