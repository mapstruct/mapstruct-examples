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
package org.mapstruct.jpa;

import java.util.Arrays;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

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

        // prepare dto's
        ParentDto parent = new ParentDto();
        parent.setName( "jim" );
        ChildDto childDto1 = new ChildDto();
        childDto1.setName( "jack" );
        ChildDto childDto2 = new ChildDto();
        childDto2.setName( "jill" );
        parent.setChildren( Arrays.asList( childDto1, childDto2 ) );


        ParentEntity parentEntity = new ParentEntity();
        SourceTargetMapper.MAPPER.toEntity( parent, parentEntity );

        //results
        assertThat( parentEntity ).isNotNull();
        assertThat( parentEntity.getName() ).isEqualTo( "jim" );
        assertThat( parentEntity.getChildren() ).hasSize( 2 );
        assertThat( parentEntity.getChildren().get( 0 ).getName() ).isEqualTo( "jack" );
        assertThat( parentEntity.getChildren().get( 0 ).getChildAge() ).isNull();
        assertThat( parentEntity.getChildren().get( 1 ).getName() ).isEqualTo( "jill" );
        assertThat( parentEntity.getChildren().get( 1 ).getChildAge() ).isNull();
    }

}
