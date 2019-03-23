/**
 * 
 */
package com.cat.map.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.cat.map.StandardMapper;
import com.cat.map.domain.Car;
import com.cat.map.domain.CarDto;

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