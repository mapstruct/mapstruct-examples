/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.dto;


/**
 *
 * @author Sjaak Derksen
 */
public class MammalEntity {

    private Long numberOfLegs;
    private Long numberOfStomachs;

    public Long getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(Long numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public Long getNumberOfStomachs() {
        return numberOfStomachs;
    }

    public void setNumberOfStomachs(Long numberOfStomachs) {
        this.numberOfStomachs = numberOfStomachs;
    }


}
