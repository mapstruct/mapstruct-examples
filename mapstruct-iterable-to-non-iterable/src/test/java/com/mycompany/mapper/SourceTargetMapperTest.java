/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.mycompany.mapper;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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

        Source s = new Source();
        s.setMyIntegers( Arrays.asList( 5, 3, 7 ) );
        s.setMyStrings( Arrays.asList( "five", "three", "seven" ) );

        Target t = SourceTargetMapper.MAPPER.toTarget( s );
        assertEquals( new Integer( 5 ), t.getMyInteger() );
        assertEquals( "seven", t.getMyString() );
    }



}
