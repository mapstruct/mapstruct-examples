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
public class CombinedOfferingEntity implements Entity {

    private ComposedKey key;
    private String descriptionArticle1;
    private String descriptionArticle2;

    @Override
    public ComposedKey getKey() {
        return key;
    }

    public void setKey(ComposedKey key) {
        this.key = key;
    }

    public String getDescriptionArticle1() {
        return descriptionArticle1;
    }

    public void setDescriptionArticle1(String descriptionArticle1) {
        this.descriptionArticle1 = descriptionArticle1;
    }

    public String getDescriptionArticle2() {
        return descriptionArticle2;
    }

    public void setDescriptionArticle2(String descriptionArticle2) {
        this.descriptionArticle2 = descriptionArticle2;
    }

}
