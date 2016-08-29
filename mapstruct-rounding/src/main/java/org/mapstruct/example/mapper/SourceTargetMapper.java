/**
 *  Copyright 2012-2016 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.example.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.example.dto.Source;
import org.mapstruct.example.dto.Target;
import org.mapstruct.example.mapper.util.RoundingUtil;
import org.mapstruct.example.mapper.util.RoundingUtil.Fraction2;
import org.mapstruct.example.mapper.util.RoundingUtil.Fraction3;
import org.mapstruct.factory.Mappers;


@Mapper( uses = RoundingUtil.class )
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    @Mappings( {
        @Mapping( target = "bd2", qualifiedBy = Fraction2.class ),
        @Mapping( target = "bd3", qualifiedBy = Fraction3.class ),
        @Mapping( target = "bdUnConstrained" )
    } )
    Target toTarget( Source s );
}
