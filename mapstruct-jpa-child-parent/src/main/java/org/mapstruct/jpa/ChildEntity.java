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
public class ChildEntity {

    private String name;
    private ParentEntity myParent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParentEntity getMyParent() {
        return myParent;
    }

    public void setMyParent(ParentEntity myParent) {
        this.myParent = myParent;
    }

}
