package com.mycompany.mapper.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonIterableToIterable {

    @ToList
    public <T> List<T> toList(T in) {
        if (in != null) {
            return Collections.singletonList(in);
        } else {
            return new ArrayList<T>();
        }
    }
}
