/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.example.dto.MammalDto;
import org.mapstruct.example.dto.MammalEntity;
import org.mapstruct.factory.Mappers;

/**
 * This mapper is a copy of {@link SourceTargetMapper} to demonstrate how to use the processor plugin for compiling
 * mapper in the test sources.
 *
 * @author Filip Hrisafov
 */
@Mapper
public interface SourceTargetTestMapper {

    SourceTargetTestMapper MAPPER = Mappers.getMapper( SourceTargetTestMapper.class );

    @Mapping(target = "numberOfStomachs", source = "numberOfStomachs")
    void toTarget(MammalDto source, Long numberOfStomachs, @MappingTarget MammalEntity target);
}
