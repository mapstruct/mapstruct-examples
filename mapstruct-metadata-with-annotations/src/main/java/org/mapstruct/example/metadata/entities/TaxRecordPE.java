/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.metadata.entities;

import org.mapstruct.example.metadata.mapper.annotations.Treatment;

/**
 *
 * @author Sjaak Derksen
 */
public class TaxRecordPE {

    private int number;

    private int year;

    private LegalEntityPE legalEntity;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LegalEntityPE getLegalEntity() {
        return legalEntity;
    }

    @Treatment( formatAs = "organisation" )
    public void setLegalEntity(LegalEntityPE legalEntity) {
        this.legalEntity = legalEntity;
    }

}
