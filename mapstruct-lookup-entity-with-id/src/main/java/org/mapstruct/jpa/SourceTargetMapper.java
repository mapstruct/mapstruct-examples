/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
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
