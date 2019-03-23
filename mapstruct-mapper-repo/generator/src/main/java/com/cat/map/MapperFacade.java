/**
 * 
 */
package com.cat.map;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.reflections.Reflections;

import com.google.common.base.Stopwatch;

/**
 * @author jucheme
 *
 */
@SuppressWarnings("rawtypes")
public class MapperFacade implements Mapper {
	static final Logger log = LogManager.getLogger(MapperFacade.class);

	private Map<FromToKey, StandardMapper> bindings;
	private Map<Class, List<StandardMapper>> listBindings;

	/**
	 * Construct!
	 * 
	 * @param packages
	 */
	public MapperFacade(String... packages) {
		Stopwatch sw = Stopwatch.createStarted();
		Map<FromToKey, StandardMapper> tempBindings = new HashMap<>();
		Map<Class, List<StandardMapper>> tempListBindings = new HashMap<>();

		Arrays.asList(packages).forEach(pack -> {

			Reflections reflections = new Reflections(pack);
			Set<Class<? extends StandardMapper>> annotated = reflections.getSubTypesOf(StandardMapper.class);
			if (annotated.isEmpty()) {
				log.warn("No MapStruct mappers were found in this package: {}!", pack);
				return;
			}

			annotated.forEach(c -> {
				if (c.isInterface()) {
					Type[] genericInterfaces = c.getGenericInterfaces();
					for (Type genericInterface : genericInterfaces) {
						if (genericInterface instanceof ParameterizedType) {
							Type[] genericTypes = ((ParameterizedType) genericInterface).getActualTypeArguments();
							Class from = (Class) genericTypes[0];
							Class to = (Class) genericTypes[1];
							StandardMapper sm = Mappers.getMapper(c);

							tempBindings.put(new FromToKey(from, to), sm);
							if (!tempListBindings.containsKey(from)) {
								tempListBindings.put(from, (List<StandardMapper>) new ArrayList<StandardMapper>());
							}
							tempListBindings.get(from).add(sm);
							log.info("Mapper found: from:{} to: {} using: {}", from.getSimpleName(), to.getSimpleName(), sm.getClass().getSimpleName());
						}
					}
				}
			});
		});
		this.bindings = Collections.unmodifiableMap(tempBindings);
		this.listBindings = Collections.unmodifiableMap(tempListBindings);
		log.info("MapperFacade setup in {}ms", sw.elapsed(TimeUnit.MILLISECONDS));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cat.map.Mapper#map(java.lang.Object, java.lang.Class)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T map(Object from, Class<T> to) {
		StandardMapper mapper = this.bindings.get(new FromToKey(from.getClass(), to));
		if (mapper != null) {
			return (T) mapper.map(from);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cat.map.Mapper#map(java.lang.Object, java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T> T map(Object from, Object to) {
		StandardMapper mapper = this.bindings.get(new FromToKey(from.getClass(), to.getClass()));
		if (mapper != null) {
			return (T) mapper.update(from, to);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cat.map.Mapper#mapAll(java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Object> mapAll(Object from) {
		List<Object> mappings = new ArrayList<>();
		if (this.listBindings.containsKey(from.getClass())) {
			this.listBindings.get(from.getClass()).forEach(mapper -> {
				mappings.add(mapper.map(from));
			});
		}
		return mappings;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cat.map.Mapper#hasRegisteredMapper(java.lang.Class,
	 * java.lang.Class)
	 */
	@Override
	public boolean hasRegisteredMapper(Class from, Class to) {
		return this.bindings.containsKey(new FromToKey(from, to));
	}
}