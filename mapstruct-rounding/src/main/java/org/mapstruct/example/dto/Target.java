/**
 *  Copyright 2012-2015 Gunnar Morling (http://www.gunnarmorling.de/)
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
