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


@Mapper
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    @Mapping( target = "numberOfStomachs", source = "numberOfStomachs" )
    void toTarget( MammalDto source, Long numberOfStomachs, @MappingTarget MammalEntity target );
}
