package com.mycompany.mapper;

import com.mycompany.entities.Target;
import com.mycompany.dto.Source;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface STMapper {

    STMapper MAPPER = Mappers.getMapper( STMapper.class );

    @Mapping( source = "test", target = "testing" )
    Target toTarget( Source s );
}
