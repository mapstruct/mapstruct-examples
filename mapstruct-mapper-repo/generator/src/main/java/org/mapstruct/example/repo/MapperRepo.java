/**
 * 
 */
package org.mapstruct.example.repo;

import java.util.List;

/**
 * @author jucheme
 *
 */
public interface MapperRepo {

	/**
	 * Maps from an object to a new instance of an object.
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	<T> T map(Object from, Class<T> to);

	/**
	 * Maps from an exsisting objec TO an existing object.
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	<T> T map(Object from, Object to);

	/**
	 * Maps this object using all available mappers.
	 * 
	 * @param from
	 * @return
	 */
	List<Object> mapAll(Object from);

	/**
	 * Do we have a mapper for these two classes?
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	boolean hasRegisteredMapper(Class from, Class to);

	static MapperRepo getInstance() {
		try {
			return (MapperRepo)Class.forName( "org.mapstruct.example.repo.MapperRepoImpl" ).newInstance();
		}
		catch ( ClassNotFoundException | InstantiationException | IllegalAccessException ex ) {
			throw new IllegalStateException( ex );
		}
	}
}