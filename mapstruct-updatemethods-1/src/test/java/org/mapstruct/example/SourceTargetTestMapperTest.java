/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example;

import org.junit.Test;
import org.mapstruct.example.dto.MammalDto;
import org.mapstruct.example.dto.MammalEntity;
import org.mapstruct.example.mapper.SourceTargetTestMapper;

import static org.fest.assertions.Assertions.assertThat;


/**
 * This is a copy of {@link SourceTargetMapperTest} to demonstrate the usage of Mappers in the test sources.
 *
 * @author Filip Hrisafov
 */
public class SourceTargetTestMapperTest {


    /**
     * Test if everything is working when sources are present
     */
    @Test
    public void test() {

        MammalDto s = new MammalDto();
        s.setNumberOfLegs( 4 );

        MammalEntity t = new MammalEntity();

        // its a cow ;)
        SourceTargetTestMapper.MAPPER.toTarget( s, 3L, t );

        assertThat( t.getNumberOfLegs() ).isEqualTo( 4 );
        assertThat( t.getNumberOfStomachs() ).isEqualTo( 3 );

    }


    /**
     * Leave source null
     */
    @Test
    public void testSourceIsNull() {

        MammalDto s = null;

        MammalEntity t = new MammalEntity();

        // its a cow ;)
        SourceTargetTestMapper.MAPPER.toTarget( s, 3L, t );

        assertThat( t.getNumberOfLegs() ).isNull();
        assertThat( t.getNumberOfStomachs() ).isEqualTo( 3 );

    }

    /**
     * Leave source content is null
     */
    @Test
    public void testSourceContentIsNull() {

        MammalDto s = new MammalDto();

        MammalEntity t = new MammalEntity();

        // its a cow ;)
        SourceTargetTestMapper.MAPPER.toTarget( s, 3L, t );

        assertThat( t.getNumberOfLegs() ).isNull();
        assertThat( t.getNumberOfStomachs() ).isEqualTo( 3 );

    }

    /**
     * Leave non bean parameter is null
     */
    @Test
    public void testSourceNonBeanParameterIsNull() {

        MammalDto s = new MammalDto();
        s.setNumberOfLegs( 4 );

        MammalEntity t = new MammalEntity();

        // its a cow ;)
        SourceTargetTestMapper.MAPPER.toTarget( s, null, t );

        assertThat( t.getNumberOfLegs() ).isEqualTo( 4 );
        assertThat( t.getNumberOfStomachs() ).isNull();

    }

    /**
     * target pre-initialized
     */
    @Test
    public void testTargetIsPreInitialized() {


        MammalDto s = null;

        // lets create a human
        MammalEntity t = new MammalEntity();
        t.setNumberOfLegs( 2L );
        t.setNumberOfStomachs( 1L );

        SourceTargetTestMapper.MAPPER.toTarget( s, null, t );

        // and we have a human
        assertThat( t.getNumberOfLegs() ).isEqualTo( 2 );
        assertThat( t.getNumberOfStomachs() ).isEqualTo( 1 );

    }
}
