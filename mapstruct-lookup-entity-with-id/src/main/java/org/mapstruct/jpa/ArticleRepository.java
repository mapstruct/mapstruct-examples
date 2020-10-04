/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.jpa;

/**
 *
 * @author Sjaak Derksen
 */
public class ArticleRepository {

    public CombinedOfferingEntity lookup(ComposedKey key) {
        // do some DB lookups here.
        CombinedOfferingEntity entity = new CombinedOfferingEntity();
        entity.setKey( key );
        return entity;
    }

}
