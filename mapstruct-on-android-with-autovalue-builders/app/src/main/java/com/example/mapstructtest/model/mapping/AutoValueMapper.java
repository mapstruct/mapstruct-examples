package com.example.mapstructtest.model.mapping;

import com.example.mapstructtest.model.AutoValueCar;
import com.example.mapstructtest.model.AutoValueCarDto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoValueMapper {
    AutoValueMapper INSTANCE = Mappers.getMapper(AutoValueMapper.class);

    // Java 8 added repeated annotations. If not running java 8,
    // wrap in @Mappings annotation as this out-commented example
//    @Mappings({
//            @Mapping(source = "numberOfSeats", target = "seatCount"),
//            @Mapping(source = "numberOfAirbags", target = "airbagCount")
//    })
    @Mapping(source = "numberOfSeats", target = "seatCount")
    @Mapping(source = "numberOfAirbags", target = "airbagCount")
    AutoValueCarDto toDto(AutoValueCar car);

    @InheritInverseConfiguration
    AutoValueCar toModel(AutoValueCarDto car);
}