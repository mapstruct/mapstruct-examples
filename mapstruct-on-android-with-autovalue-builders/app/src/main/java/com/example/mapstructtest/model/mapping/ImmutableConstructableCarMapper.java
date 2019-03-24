package com.example.mapstructtest.model.mapping;

import com.example.mapstructtest.model.ImmutableConstructableCar;
import com.example.mapstructtest.model.ImmutableConstructibleCarDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper
public interface ImmutableConstructableCarMapper {
	ImmutableConstructableCarMapper INSTANCE = Mappers.getMapper(ImmutableConstructableCarMapper.class);

	// MapStruct 1.3 does not support this immutable style contstructor.
//	@Mapping(source = "numberOfSeats", target = "seatCount")
	ImmutableConstructibleCarDto carToCarDto(ImmutableConstructableCar car);
}