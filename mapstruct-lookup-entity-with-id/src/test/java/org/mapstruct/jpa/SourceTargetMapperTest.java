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
