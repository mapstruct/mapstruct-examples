/**
 * 
 */
package org.mapstruct.example.repo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.example.repo.AddToRepo;
import org.mapstruct.example.repo.StandardMapper;
import org.mapstruct.example.repo.domain.Employee;
import org.mapstruct.example.repo.domain.Person;

/**
 * @author jucheme
 *
 */
@AddToRepo
@Mapper
public interface PersonMapper extends StandardMapper<Person, Employee> {

	@Mapping(source = "firstName", target = "name")
	Employee map(Person p);
}