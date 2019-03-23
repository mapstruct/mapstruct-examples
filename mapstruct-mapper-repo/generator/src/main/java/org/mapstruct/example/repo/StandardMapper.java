/**
 * 
 */
package org.mapstruct.example.repo;

import org.mapstruct.MappingTarget;

/**
 * @author jucheme
 *
 */
public interface StandardMapper<From, To> {

	/**
	 * Maps from one object to another.
	 * 
	 * @param from
	 * @return to
	 */
	To map(From from);

	/**
	 * Update the object.
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	To update(From from, @MappingTarget To to);
}
