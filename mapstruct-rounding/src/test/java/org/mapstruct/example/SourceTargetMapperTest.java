/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example;

import java.math.BigDecimal;
import org.mapstruct.example.mapper.SourceTargetMapper;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mapstruct.example.dto.Source;
import org.mapstruct.example.dto.Target;

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
        s.setBd2( new BigDecimal( 1.3333) );
        s.setBd3( new BigDecimal( 1.3333) );
        s.setBdUnConstrained(new BigDecimal( 1.3333 ) );

        Target t = SourceTargetMapper.MAPPER.toTarget( s );

        assertEquals( new BigDecimal( "1.33" ), t.getBd2() );
        assertEquals( new BigDecimal( "1.333" ), t.getBd3() );
        assertEquals( 1.333d, t.getBdUnConstrained().doubleValue(), 0.001d );
    }



}
