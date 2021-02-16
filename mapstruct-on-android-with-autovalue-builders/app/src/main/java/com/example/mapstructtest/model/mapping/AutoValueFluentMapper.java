package com.example.mapstructtest.model.mapping;

import com.example.mapstructtest.model.AutoValueFluentCar;
import com.example.mapstructtest.model.AutoValueFluentCarDto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoValueFluentMapper {
	AutoValueFluentMapper INSTANCE = Mappers.getMapper(AutoValueFluentMapper.class);

	// MapStruct 1.3 does NOT work with fluent accessor style like shown here
	@Mapping(source = "numberOfSeats", target = "seatCount")
	AutoValueFluentCarDto toDto(AutoValueFluentCar car);
	@InheritInverseConfiguration
	AutoValueFluentCar toModel(AutoValueFluentCarDto car);
}