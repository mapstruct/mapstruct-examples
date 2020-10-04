/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.mycompany.mapper;

import java.util.List;

/**
 *
 * @author Sjaak Derksen
 */
public class Source {


    private List<Integer> myIntegers;
    private List<String> myStrings;

    public List<Integer> getMyIntegers() {
        return myIntegers;
    }

    public void setMyIntegers( List<Integer> myIntegers ) {
        this.myIntegers = myIntegers;
    }

    public List<String> getMyStrings() {
        return myStrings;
    }

    public void setMyStrings( List<String> myStrings ) {
        this.myStrings = myStrings;
    }


}
