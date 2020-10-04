/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.jpa;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper( uses = SourceTargetMapper.LenientMapper.class )
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    void toEntity(ParentDto s, @MappingTarget ParentEntity t);

    @Mapper( unmappedTargetPolicy = ReportingPolicy.IGNORE )
    public interface LenientMapper {

        // ChildDto.name will be mapped to ChildEntity.name (based on name), explicit ignore would still be required
        // ChildDto.age will not be mapped ChildDto.childAge (ignore) and there's no warning either
        // this is handy when @BeanMapping#ignoreByDefault causes too many manual mappings to add
        void toEntity(ChildDto s, @MappingTarget ChildEntity t);
    }
}
