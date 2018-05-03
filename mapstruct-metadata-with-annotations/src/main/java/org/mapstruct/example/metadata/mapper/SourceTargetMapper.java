/**
 *  Copyright 2012-2018 Gunnar Morling (http://www.gunnarmorling.de/)
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
package org.mapstruct.example.metadata.mapper;

import org.mapstruct.example.metadata.mapper.util.TaxContext;
import java.lang.annotation.Annotation;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.example.metadata.dto.LegalEntity;
import org.mapstruct.example.metadata.dto.TaxRecord;
import org.mapstruct.example.metadata.entities.LegalEntityPE;
import org.mapstruct.example.metadata.entities.OrganisationPE;
import org.mapstruct.example.metadata.entities.PersonPE;
import org.mapstruct.example.metadata.entities.TaxRecordPE;
import org.mapstruct.example.metadata.mapper.annotations.IgnoreMapping;
import org.mapstruct.example.metadata.mapper.annotations.Treatment;
import org.mapstruct.factory.Mappers;




@Mapper
public abstract class SourceTargetMapper {

    public static final SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    public abstract TaxRecordPE toTarget( TaxRecord s, @Context TaxContext ctx );

    protected LegalEntityPE convert( LegalEntity s, @Context TaxContext ctx ) {

        List<Annotation> annotations = ctx.getAnnotationsForMethod( "setLegalEntity" );
        String formatAs = annotations.stream()
            .filter( Treatment.class::isInstance )
            .map( Treatment.class::cast )
            .findFirst()
            .map( Treatment::formatAs )
            .orElse( "person" );
        if ( "organisation".equals( formatAs ) ) {
            return mapOrganisation( s );
        }
        else {
            return mapPerson( s );
        }
    }

    @IgnoreMapping
    @Mapping( target = "socialSecurityNumber", source = "id" )
    protected abstract PersonPE mapPerson( LegalEntity s );

    @IgnoreMapping
    @Mapping( target = "chamberOfCommerceNumber", source = "id" )
    protected abstract OrganisationPE mapOrganisation( LegalEntity s );
}
