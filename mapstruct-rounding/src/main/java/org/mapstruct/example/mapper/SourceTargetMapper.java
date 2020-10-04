/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.example.dto.Source;
import org.mapstruct.example.dto.Target;
import org.mapstruct.example.mapper.util.RoundingUtil;
import org.mapstruct.example.mapper.util.RoundingUtil.Fraction2;
import org.mapstruct.example.mapper.util.RoundingUtil.Fraction3;
import org.mapstruct.factory.Mappers;


@Mapper( uses = RoundingUtil.class )
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    @Mapping( target = "bd2", qualifiedBy = Fraction2.class )
    @Mapping( target = "bd3", qualifiedBy = Fraction3.class )
    @Mapping( target = "bdUnConstrained" )
    Target toTarget( Source s );
}
