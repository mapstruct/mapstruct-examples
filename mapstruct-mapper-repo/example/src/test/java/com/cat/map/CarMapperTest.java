/**
 * 
 */
package com.cat.map;

import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import com.cat.map.domain.Car;
import com.cat.map.domain.CarDto;
import com.cat.map.domain.CarType;
import com.cat.map.mappers.CarMapper;

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
