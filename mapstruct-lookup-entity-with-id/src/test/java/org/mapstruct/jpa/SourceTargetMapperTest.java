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

        ToothPaste paste = new ToothPaste();
        paste.setName( "Paradontax" );
        paste.setDescription( "with active enzimes" );

        Toothbrush brush = new Toothbrush();
        brush.setName( "Oral-B" );
        brush.setDescription( "rotating head" );

        ArticleRepository repo = new ArticleRepository();

        CombinedOfferingEntity entity = SourceTargetMapper.MAPPER.toEntity( brush, paste, repo );

        //results
        assertThat( entity ).isNotNull();
        assertThat( entity.getKey() ).isNotNull();
        assertThat( entity.getKey().getName1() ).isEqualTo( "Oral-B" );
        assertThat( entity.getKey().getName2() ).isEqualTo( "Paradontax" );
        assertThat( entity.getDescriptionArticle1() ).isEqualTo( "rotating head" );
        assertThat( entity.getDescriptionArticle2() ).isEqualTo( "with active enzimes" );

    }

}
