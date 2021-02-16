package com.example.mapstructtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mapstructtest.model.AutoValueCar;
import com.example.mapstructtest.model.AutoValueCarDto;
import com.example.mapstructtest.model.AutoValueFluentCar;
import com.example.mapstructtest.model.AutoValueFluentCarDto;
import com.example.mapstructtest.model.Car;
import com.example.mapstructtest.model.CarDto;
import com.example.mapstructtest.model.CarFluentSetter;
import com.example.mapstructtest.model.CarType;
import com.example.mapstructtest.model.ImmutableConstructableCar;
import com.example.mapstructtest.model.ImmutableConstructibleCarDto;
import com.example.mapstructtest.model.mapping.AutoValueFluentMapper;
import com.example.mapstructtest.model.mapping.AutoValueMapper;
import com.example.mapstructtest.model.mapping.CarMapper;
import com.example.mapstructtest.model.mapping.ImmutableConstructableCarMapper;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv_text);
	}

	@Override
	protected void onResume() {
		super.onResume();
        StringBuilder sb = new StringBuilder();
        sb.append(manualMappingWithFluentSetter());
		sb.append(withAutoValue());
		sb.append(withAutoValueFluent());
		sb.append(withAutoValueFluent());
//		sb.append(withImmutable()); // Not yet for MapStruct 1.3
        tv.setText(sb.toString());
	}

	String withImmutable() {
		// MapStruct 1.3 does not support this immutable style contstructor.
		ImmutableConstructableCar immutableConstructableCar = new ImmutableConstructableCar("Immutable Audi", 6, CarType.LARGE);
		ImmutableConstructibleCarDto immutableCarDto = ImmutableConstructableCarMapper.INSTANCE.carToCarDto(immutableConstructableCar);
		return getString("Immutable: ", immutableConstructableCar, immutableCarDto);
	}

	String manualMappingWithFluentSetter() {
		Car car = new Car();
		car.setConstructor("Audi");
		car.setNumberOfSeats(5);
		car.setType(CarType.LUXURY);
		// Map the regular car
		CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);
		// Then map it via fluent setter version
		CarFluentSetter carFluentSetter = CarMapper.INSTANCE.toFluentSetterCar(carDto);
		CarDto carDtoAgain = CarMapper.INSTANCE.toDto(carFluentSetter);
		return getString("Car and car with fluent setter", car, carDto, carFluentSetter, carDtoAgain);
	}

	String withAutoValue() {
		AutoValueCar.Builder builder = AutoValueCar.builder();
		builder.setConstructor("Audi");
		builder.setNumberOfSeats(5);
		builder.setNumberOfAirbags(3);
		builder.setType(CarType.LUXURY);
		AutoValueCar car = builder.build();

		AutoValueCarDto carDto = AutoValueMapper.INSTANCE.toDto(car);
		AutoValueCar carAgain = AutoValueMapper.INSTANCE.toModel(carDto);
		return getString("AutoValue mapping with MapStruct", car, carDto, carAgain);
	}

	String withAutoValueFluent() {
		AutoValueFluentCar.Builder builder = AutoValueFluentCar.builder();
		builder.constructor("Audi");
		builder.numberOfSeats(5);
		builder.type(CarType.LUXURY);
		AutoValueFluentCar car = builder.build();
		// MapStruct 1.3 does NOT work with fluent accessor style for getters, but does work with fluent setters
		AutoValueFluentCarDto carDto = AutoValueFluentMapper.INSTANCE.toDto(car);
		AutoValueFluentCar carAgain = AutoValueFluentMapper.INSTANCE.toModel(carDto);
		return getString("AutoValue with fluent setter mapping", car, carDto, carAgain);
	}

	private String getString(String info, Object... objs) {
		StringBuilder strb = new StringBuilder();
		strb.append(info);
		for (Object obj : objs) {
			strb.append('\n');
			strb.append(obj.toString());
		}
		strb.append('\n');
		strb.append('\n');
		return strb.toString();
	}
}
