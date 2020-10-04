/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example;

import static org.assertj.core.api.Assertions.assertThat;
import org.mapstruct.example.metadata.mapper.SourceTargetMapper;
import org.junit.Test;
import org.mapstruct.example.metadata.dto.LegalEntity;
import org.mapstruct.example.metadata.dto.TaxRecord;
import org.mapstruct.example.metadata.entities.OrganisationPE;
import org.mapstruct.example.metadata.entities.TaxRecordPE;
import org.mapstruct.example.metadata.mapper.util.TaxContext;

/**
 *
 * @author Sjaak Derksen
 */
public class SourceTargetMapperTest {

    public SourceTargetMapperTest() {
    }

    /**
     * Test of toTarget method, of class SourceTargetMapper.
     */
    @Test
    public void testToTarget() {

        LegalEntity legalEntity = new LegalEntity();
        legalEntity.setName( "ACME" );
        legalEntity.setAddress( "Tinseltown" );
        legalEntity.setId( "123.4567" );
        TaxRecord taxRecord = new TaxRecord();
        taxRecord.setNumber( 1 );
        taxRecord.setYear( 2017 );
        taxRecord.setLegalEntity( legalEntity );

        TaxRecordPE taxRecordPE = SourceTargetMapper.MAPPER.toTarget( taxRecord, new TaxContext() );

        assertThat( taxRecordPE ).isNotNull();
        assertThat( taxRecordPE.getNumber() ).isEqualTo( 1 );
        assertThat( taxRecordPE.getYear() ).isEqualTo( 2017 );
        assertThat( taxRecordPE.getLegalEntity() ).isNotNull();
        assertThat( taxRecordPE.getLegalEntity().getName() ).isEqualTo( "ACME" );
        assertThat( taxRecordPE.getLegalEntity().getAddress() ).isEqualTo( "Tinseltown" );
        // check whether annotation analysis worked
        assertThat( taxRecordPE.getLegalEntity() ).isInstanceOf( OrganisationPE.class );
        OrganisationPE organisation = (OrganisationPE) taxRecordPE.getLegalEntity();
        assertThat( ( organisation ).getChamberOfCommerceNumber() ).isEqualTo( "123.4567" );
    }



}
