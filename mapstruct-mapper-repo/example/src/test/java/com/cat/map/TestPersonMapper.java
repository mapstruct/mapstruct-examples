/**
 * 
 */
package com.cat.map;

import org.junit.Assert;
import org.junit.Test;

import com.cat.map.domain.Employee;
import com.cat.map.domain.Person;
import com.cat.map.mappers.PersonMapper;

/**
 * @author jucheme
 *
 */
public class TestPersonMapper {

	@Test
	public void testStuff() {
		// given
		Person p = new Person("mark", "juchems", "411 manor", 54L);

		// when
		Employee e = PersonMapper.INSTANCE.map(p);

		// then
		Assert.assertNotNull(e);
		Assert.assertEquals(e.getAddress(), p.getAddress());
		Assert.assertEquals(e.getName(), p.getFirstName());
	}
}