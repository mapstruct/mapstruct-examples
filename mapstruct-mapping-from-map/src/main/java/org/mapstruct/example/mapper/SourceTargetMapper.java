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
import org.mapstruct.example.mapper.util.MappingUtil;
import org.mapstruct.example.mapper.util.MappingUtil.Ip;
import org.mapstruct.example.mapper.util.MappingUtil.Server;
import org.mapstruct.factory.Mappers;

/**
 * @author Adam Gurgul
 */

@Mapper( uses = MappingUtil.class )
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    @Mapping(source = "map", target = "ip", qualifiedBy = Ip.class )
    @Mapping(source = "map", target = "server", qualifiedBy = Server.class )
    Target toTarget(Source s);
}
