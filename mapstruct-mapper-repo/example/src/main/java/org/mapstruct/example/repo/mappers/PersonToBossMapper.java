/**
 * 
 */
package org.mapstruct.example.repo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.example.repo.AddToRepo;
import org.mapstruct.example.repo.StandardMapper;
import org.mapstruct.example.repo.domain.Boss;
import org.mapstruct.example.repo.domain.Person;

/**
 * @author jucheme
 *
 */
@AddToRepo
@Mapper
public interface PersonToBossMapper extends StandardMapper<Person, Boss> {

	@Mapping(source = "firstName", target = "name")
	@Mapping(target = "title", constant = "Boss")
	Boss map(Person p);
}