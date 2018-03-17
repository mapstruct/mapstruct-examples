/**
 *  Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
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
