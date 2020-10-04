/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.dto;

import java.math.BigDecimal;

/**
 *
 * @author Sjaak Derksen
 */
public class Target {

    private BigDecimal bd2;

    private BigDecimal bd3;

    private BigDecimal bdUnConstrained;

    public BigDecimal getBd2() {
        return bd2;
    }

    public void setBd2(BigDecimal bd2) {
        this.bd2 = bd2;
    }

    public BigDecimal getBd3() {
        return bd3;
    }

    public void setBd3(BigDecimal bd3) {
        this.bd3 = bd3;
    }

    public BigDecimal getBdUnConstrained() {
        return bdUnConstrained;
    }

    public void setBdUnConstrained(BigDecimal bdUnConstrained) {
        this.bdUnConstrained = bdUnConstrained;
    }

}
