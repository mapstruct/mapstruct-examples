package com.example.mapstructtest.model.mapping;

import com.example.mapstructtest.model.Car;
import com.example.mapstructtest.model.CarDto;
import com.example.mapstructtest.model.CarFluentSetter;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
	CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

	@Mapping(source = "numberOfSeats", target = "seatCount")
	CarDto carToCarDto(Car car);

	@Mapping(source = "numberOfSeats", target = "seatCount")
	CarDto toDto(CarFluentSetter car);

	@InheritInverseConfiguration
	CarFluentSetter toFluentSetterCar(CarDto car);
}