/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.metadata.entities;

/**
 *
 * @author Sjaak Derksen
 */
public class OrganisationPE extends LegalEntityPE {

    private String chamberOfCommerceNumber;

    public String getChamberOfCommerceNumber() {
        return chamberOfCommerceNumber;
    }

    public void setChamberOfCommerceNumber(String chamberOfCommerceNumber) {
        this.chamberOfCommerceNumber = chamberOfCommerceNumber;
    }

}
