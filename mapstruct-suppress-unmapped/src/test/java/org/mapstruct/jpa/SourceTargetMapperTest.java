/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
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
