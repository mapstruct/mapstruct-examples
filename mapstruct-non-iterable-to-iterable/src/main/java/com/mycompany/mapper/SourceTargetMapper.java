package com.mycompany.mapper;

import com.mycompany.mapper.util.NonIterableToIterable;
import com.mycompany.mapper.util.ToList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(uses = NonIterableToIterable.class)
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper(SourceTargetMapper.class);

    @Mappings( {
        @Mapping( target = "myIntegers", source = "myInteger", qualifiedBy = ToList.class ),
        @Mapping( target = "myStrings", source = "myString", qualifiedBy = ToList.class )
    } )
    Iterable toTarget(NonIterable s);
}
