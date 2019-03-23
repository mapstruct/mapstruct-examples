/**
 * 
 */
package org.mapstruct.example.repo;

import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import org.mapstruct.example.repo.domain.Car;
import org.mapstruct.example.repo.domain.CarDto;
import org.mapstruct.example.repo.domain.CarType;
import org.mapstruct.example.repo.mappers.CarMapper;

/**
 * @author jucheme
 *
 */
public class CarMapperTest {
	@Test
	public void shouldMapCarToDto() {
		// given
		Car car = new Car("Morris", 5, CarType.SPORTS);

		// when
		CarDto carDto = CarMapper.INSTANCE.map(car);

		// then
		Assert.assertNotNull(carDto);
		Assert.assertEquals(carDto.getMake(), "Morris");
		Assert.assertEquals(carDto.getSeatCount(), 5);
	}

	@Test
	public void anotherTest() {
		// given
		Car car = new Car("Morris", 5, CarType.SPORTS);

		CarDto carDto = Mappers.getMapper(CarMapper.class).map(car);
		System.out.println(carDto);
	}
}
