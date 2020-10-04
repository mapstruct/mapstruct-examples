/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.metadata.mapper;

import org.mapstruct.example.metadata.mapper.util.TaxContext;
import java.lang.annotation.Annotation;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.example.metadata.dto.LegalEntity;
import org.mapstruct.example.metadata.dto.TaxRecord;
import org.mapstruct.example.metadata.entities.LegalEntityPE;
import org.mapstruct.example.metadata.entities.OrganisationPE;
import org.mapstruct.example.metadata.entities.PersonPE;
import org.mapstruct.example.metadata.entities.TaxRecordPE;
import org.mapstruct.example.metadata.mapper.annotations.DoNotSelectForMapping;
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

    @DoNotSelectForMapping
    @Mapping( target = "socialSecurityNumber", source = "id" )
    protected abstract PersonPE mapPerson( LegalEntity s );

    @DoNotSelectForMapping
    @Mapping( target = "chamberOfCommerceNumber", source = "id" )
    protected abstract OrganisationPE mapOrganisation( LegalEntity s );
}
