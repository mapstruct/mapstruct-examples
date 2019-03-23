/**
 * 
 */
package org.mapstruct.example.repo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import org.mapstruct.example.repo.domain.Boss;
import org.mapstruct.example.repo.domain.Car;
import org.mapstruct.example.repo.domain.CarDto;
import org.mapstruct.example.repo.domain.CarType;
import org.mapstruct.example.repo.domain.Employee;
import org.mapstruct.example.repo.domain.Person;

/**
 * @author jucheme
 *
 */
public class TestMapperFacade {

	@Test
	public void testMapToFromNew() {
		MapperFacade mf = new MapperFacade("org.mapstruct.example.repo", "mark.is.cool");
		Car car = new Car("Morris", 5, CarType.SPORTS);
		Person p = new Person("mark", "juchems", "411 manor", 54L);

		CarDto c = mf.map(car, CarDto.class);
		System.out.println(c);

		Employee e = mf.map(p, Employee.class);
		System.out.println(e);

		Boss b = mf.map(p, Boss.class);
		System.out.println(b);
	}

	@Test
	public void testMapObjectToObject() {
		Mapper mf = new MapperFacade("org.mapstruct.example.repo");
		Car car = new Car("Morris", 5, CarType.SPORTS);

		CarDto carDto = new CarDto();
		carDto.setMake("toyota");
		CarDto x = mf.map(car, carDto);
		Assert.assertSame(x, carDto);
		Assert.assertEquals("Morris", carDto.getMake());
	}

	/**
	 * Test mapAll
	 */
	@Test
	public void testMapAll() {
		Mapper mf = new MapperFacade("org.mapstruct.example.repo");
		Person p = new Person("mark", "juchems", "411 manor", 54L);

		List<Object> result = mf.mapAll(p);
		Assert.assertEquals(2, result.size());
		result.forEach(r -> {
			System.out.println(r);
		});

		Assert.assertEquals(0, mf.mapAll(Long.class).size());
	}

	/**
	 * Test method.
	 */
	@Test
	public void testHasRegisteredMapper() {
		Mapper mf = new MapperFacade("org.mapstruct.example.repo");

		Assert.assertTrue(mf.hasRegisteredMapper(Car.class, CarDto.class));
		Assert.assertFalse(mf.hasRegisteredMapper(Car.class, Person.class));
	}
}