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
