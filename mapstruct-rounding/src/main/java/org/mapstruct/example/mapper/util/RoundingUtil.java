/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.mapper.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.mapstruct.Qualifier;

/**
 *
 * @author Sjaak Derksen
 */
public class RoundingUtil {


    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Fraction2 { }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface Fraction3 { }


    @Fraction2
    public BigDecimal fraction2( BigDecimal in ) {

        return in == null ? null : in.setScale( 2, RoundingMode.DOWN );
    }

    @Fraction3
    public BigDecimal fraction3( BigDecimal in ) {

        return in == null ? null : in.setScale( 3, RoundingMode.DOWN );
    }

}
