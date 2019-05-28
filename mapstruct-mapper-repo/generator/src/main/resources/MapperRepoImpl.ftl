package org.mapstruct.example.repo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

<#list repoItems as repoItem>
import ${repoItem.sourceType};
</#list>
<#list repoItems as repoItem>
import ${repoItem.targetType};
</#list>
<#list repoItems as repoItem>
import ${repoItem.mapperType};
</#list>
<#list repoItems as repoItem>
import ${repoItem.mapperType}Impl;
</#list>

@SuppressWarnings("rawtypes")
public class MapperRepoImpl implements MapperRepo {

    private Map<FromToKey, StandardMapper> bindings;
    private Map<Class, List<StandardMapper>> listBindings;

    public MapperRepoImpl() {

        Map<FromToKey, StandardMapper> tempBindings = new HashMap<>();
        Map<Class, List<StandardMapper>> tempListBindings = new HashMap<>();

        <#list repoItems as repoItem>
        tempBindings.put(new FromToKey( ${repoItem.sourceTypeShort}.class, ${repoItem.targetTypeShort}.class ), new ${repoItem.mapperTypeShort}Impl() );
        if ( !tempListBindings.containsKey( ${repoItem.sourceTypeShort}.class ) ) {
            tempListBindings.put( ${repoItem.sourceTypeShort}.class, new ArrayList<StandardMapper>() );
        }
        tempListBindings.get( ${repoItem.sourceTypeShort}.class ).add( new ${repoItem.mapperTypeShort}Impl() );
        </#list>

        this.bindings = Collections.unmodifiableMap(tempBindings);
        this.listBindings = Collections.unmodifiableMap(tempListBindings);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T map(Object from, Class<T> to) {
        StandardMapper mapper = this.bindings.get(new FromToKey(from.getClass(), to));
        if (mapper != null) {
            return (T) mapper.map(from);
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T map(Object from, Object to) {
        StandardMapper mapper = this.bindings.get(new FromToKey(from.getClass(), to.getClass()));
        if (mapper != null) {
            return (T) mapper.update(from, to);
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object> mapAll(Object from) {
        List<Object> mappings = new ArrayList<>();
        if (this.listBindings.containsKey(from.getClass())) {
            this.listBindings.get( from.getClass()).forEach( mapper -> mappings.add( mapper.map( from ) ) );
        }
        return mappings;
    }

    @Override
    public boolean hasRegisteredMapper(Class from, Class to) {
        return this.bindings.containsKey(new FromToKey(from, to));
    }
}
