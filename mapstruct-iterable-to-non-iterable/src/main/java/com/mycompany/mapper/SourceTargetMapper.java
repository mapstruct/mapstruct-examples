/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.mycompany.mapper;

import com.mycompany.mapper.util.FirstElement;
import com.mycompany.mapper.util.IterableNonIterableUtil;
import com.mycompany.mapper.util.LastElement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper( uses = IterableNonIterableUtil.class )
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    @Mapping( source = "myIntegers", target = "myInteger", qualifiedBy = FirstElement.class )
    @Mapping( source = "myStrings", target = "myString", qualifiedBy = LastElement.class )
    Target toTarget( Source s );
}
