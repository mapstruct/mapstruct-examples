/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mapstruct.example.metadata.mapper.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mapstruct.BeforeMapping;
import org.mapstruct.TargetType;

/**
 *
 * @author Sjaak Derksen
 */
public class TaxContext {

    private final Map<String, List<Annotation>> annotations = new HashMap<>();

    @BeforeMapping
    public void registerAnnotationsForTarget(@TargetType Class<?> t) {
        Method[] methods = t.getMethods();
        for ( Method method : methods ) {
            for ( Annotation annotation : method.getAnnotations() ) {
                registerAnnotationForMethod( method.getName(), annotation );
            }
        }
    }

    private void registerAnnotationForMethod(String methodName, Annotation annotation) {
        if ( !annotations.containsKey( methodName ) ) {
            annotations.put( methodName, new ArrayList<>() );
        }
        annotations.get( methodName ).add( annotation );
    }

    public List<Annotation> getAnnotationsForMethod(String methodName) {
        return annotations.getOrDefault( methodName, new ArrayList<>() );
    }
}
