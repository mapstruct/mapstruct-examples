/**
 * 
 */
package org.mapstruct.example.repo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.example.repo.StandardMapper;
import org.mapstruct.factory.Mappers;

import org.mapstruct.example.repo.domain.Car;
import org.mapstruct.example.repo.domain.CarDto;

/**
 * @author jucheme
 *
 */
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CarMapper extends StandardMapper<Car, CarDto> {

	CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
	static StandardMapper getMapper() {
		return INSTANCE;
	}

	@Mapping(source = "numberOfSeats", target = "seatCount")
	CarDto map(Car Car);
}