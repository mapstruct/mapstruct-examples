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

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SourceTargetMapper {

    SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );

    @Mapping( target = "key", ignore = true )
    @Mapping( target = "descriptionArticle1", source = "brush.description" )
    @Mapping( target = "descriptionArticle2", source = "paste.description" )
    CombinedOfferingEntity toEntity(Toothbrush brush, ToothPaste paste, @Context ArticleRepository repo);

    @ObjectFactory
    default <T extends Entity> T lookup(Toothbrush brush, ToothPaste paste, @Context ArticleRepository repo,
        @TargetType Class<T> targetType ) {
        ComposedKey key = new ComposedKey(brush.getName(), paste.getName() );
        CombinedOfferingEntity entity = repo.lookup( key );
        if ( entity == null ) {
            entity = new CombinedOfferingEntity();
        }
        return (T) entity;
    }

}
