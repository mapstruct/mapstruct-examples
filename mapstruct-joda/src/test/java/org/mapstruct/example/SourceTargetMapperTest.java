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

import java.math.BigDecimal;
import org.joda.time.DateTime;
import org.mapstruct.example.mapper.SourceTargetMapper;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mapstruct.example.dto.DateTimeBean;
import org.mapstruct.example.dto.XmlGregorianCalendarBean;

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

        DateTimeBean s = new DateTimeBean();
        s.setDateTime( new DateTime( 2000, 1, 15, 12, 0 ) );

        XmlGregorianCalendarBean t = SourceTargetMapper.INSTANCE.toXmlGregorianCalendarBean( s );

        assertEquals( "2000-01-15T12:00:00.000+02:00", t.getxMLGregorianCalendar().toString() );
    }

}
