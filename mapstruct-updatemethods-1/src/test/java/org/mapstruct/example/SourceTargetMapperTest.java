/**
 *  Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
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
package org.mapstruct.example;

import org.junit.Test;
import org.mapstruct.example.mapper.SourceTargetMapper;
import org.mapstruct.example.protobuf.MammalDto;
import org.mapstruct.example.protobuf.MammalEntity;

import static org.fest.assertions.Assertions.assertThat;


/**
 *
 * @author Sjaak Derksen
 */
public class SourceTargetMapperTest {


    /**
     * Test if everything is working when sources are present
     */
    @Test
    public void test() {

        MammalDto s = new MammalDto();
        s.setNumberOfLegs( 4 );

        MammalEntity t = new MammalEntity();

        // its a cow ;)
        SourceTargetMapper.MAPPER.toTarget( s, 3L, t );

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
        SourceTargetMapper.MAPPER.toTarget( s, 3L, t );

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
        SourceTargetMapper.MAPPER.toTarget( s, 3L, t );

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
        SourceTargetMapper.MAPPER.toTarget( s, null, t );

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

        SourceTargetMapper.MAPPER.toTarget( s, null, t );

        // and we have a human
        assertThat( t.getNumberOfLegs() ).isEqualTo( 2 );
        assertThat( t.getNumberOfStomachs() ).isEqualTo( 1 );

    }


}
